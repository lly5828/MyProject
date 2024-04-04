package Database;
import basicClass.LeaveInfo.LeaveRecordFactory;
import basicClass.MyClass;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MyClassesDAO extends BaseDAO {

    public MyClassesDAO(Connection connection) {
        super(connection);
    }
    public MyClassesDAO() throws SQLException {super();}

    @Override
    public void insert(Object obj) throws SQLException {
        if (obj instanceof MyClass) {
            MyClass myClass = (MyClass) obj;
            String query = "INSERT INTO MyClass (name,id,leaveRecordFactoryId) VALUES (?,?,?)";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, myClass.getName());
                statement.setInt(2,myClass.getId());
                LeaveRecordFactoryDao leaveRecordFactoryDao=new LeaveRecordFactoryDao();
                leaveRecordFactoryDao.insert(myClass.getLeaveRecordFactory());
                statement.setInt(3,myClass.getLeaveRecordFactory().getId());
                statement.executeUpdate();
            }
        }
    }

    @Override
    public void update(Object obj) throws SQLException {
        if (obj instanceof MyClass) {
            MyClass myClass = (MyClass) obj;
            String query = "UPDATE MyClass SET name = ? WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, myClass.getName());
                statement.setInt(2, myClass.getId());
                statement.executeUpdate();
            }
        }
    }

    @Override
    public void delete(Object obj) throws SQLException {
        if (obj instanceof MyClass) {
            MyClass myClass = (MyClass) obj;
            String query = "DELETE FROM MyClass WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, myClass.getId());
                statement.executeUpdate();
            }
        }
    }

    @Override
    public Object findById(int id) throws SQLException {
        String query = "SELECT * FROM MyClass WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    MyClass myClass = new MyClass();
                    myClass.setId(resultSet.getInt("id"));
                    myClass.setName(resultSet.getString("name"));
                    DatabaseManager databaseManager=new DatabaseManager();
                    myClass.setStudents(databaseManager.findStudentsByMyClassId(id));
                    BaseDAO.closeConnection(databaseManager.conn);
                    CourseDAO courseDAO=new CourseDAO();
                    myClass.setCourses(courseDAO.findByMyClassId(id));
                    BaseDAO.closeConnection(courseDAO.connection);
                    myClass.initCourseTable();
                    LeaveRecordFactoryDao leaveRecordFactoryDao=new LeaveRecordFactoryDao();
                    myClass.setLeaveRecordFactoryId(resultSet.getInt("leaveRecordFactoryId"));
                    LeaveRecordFactory leaveRecordFactory=(LeaveRecordFactory) leaveRecordFactoryDao.findById(myClass.getLeaveRecordFactoryId());
                    myClass.setLeaveRecordFactory(leaveRecordFactory);
                    BaseDAO.closeConnection(leaveRecordFactoryDao.connection);

                    return myClass;
                }
            }
        }
        return null;
    }

    public int getFactoryIdByClassId(int myClassId) {
        try {
            String query = "SELECT * FROM MyClass WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, myClassId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt("leaveRecordFactoryId");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    public String getClassNameByClassId(int myClassId){
        try {
            String query = "SELECT * FROM MyClass WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, myClassId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getString("name");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "null";
    }
}