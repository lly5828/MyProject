package Database;

import basicClass.Course;
import basicClass.LeaveInfo.LeaveRecord;
import basicClass.LeaveInfo.LeaveRecordFactory;
import basicClass.LeaveInfo.LeaveResult;
import basicClass.SchoolTime;
import basicClass.Student;
import basicClass.Teacher;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LeaveRecordFactoryDao extends BaseDAO {
    public LeaveRecordFactoryDao() throws SQLException {
        super();
    }

    @Override
    public void insert(Object obj) throws SQLException {
        if (obj instanceof LeaveRecordFactory) {
            LeaveRecordFactory leaveRecordFactory = (LeaveRecordFactory) obj;
            String query = "INSERT INTO LeaveRecordFactory (name,recordCount) VALUES (?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(query,Statement.RETURN_GENERATED_KEYS) ){
                statement.setString(1,leaveRecordFactory.getName());
                statement.setInt(2, leaveRecordFactory.getRecordCount());
                statement.executeUpdate();
                ResultSet rs=statement.getGeneratedKeys();
                if(rs.next()){
                    LeaveRecordDAO leaveRecordDAO=new LeaveRecordDAO();
                    int id= rs.getInt(1);
                    leaveRecordFactory.setId(id);
                    for(LeaveRecord leaveRecord:leaveRecordFactory.getAllLeaveRecords().values()){
                        leaveRecord.setFactoryId(id);
                        leaveRecordDAO.insert(leaveRecord);
                    }
                }
            }
        }
    }

    @Override
    public void update(Object obj) throws SQLException {
        if (obj instanceof LeaveRecordFactory) {
            LeaveRecordFactory leaveRecordFactory = (LeaveRecordFactory) obj;
            String sql = "UPDATE LeaveRecordFactory SET recordCount = ? WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, leaveRecordFactory.getRecordCount());
                statement.setInt(2, leaveRecordFactory.getId());
                statement.executeUpdate();
            }
        } else {
            throw new IllegalArgumentException("Object is not an instance of Course");
        }
    }

    @Override
    public void delete(Object obj) throws SQLException {

    }

    @Override
    public Object findById(int id) throws SQLException {
        LeaveRecordFactory leaveRecordFactory = null;
        String query = "SELECT * FROM LeaveRecordFactory WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    leaveRecordFactory = new LeaveRecordFactory();
                    leaveRecordFactory.setName(resultSet.getString("name"));
                    leaveRecordFactory.setRecordCount(resultSet.getInt("recordCount"));
                    leaveRecordFactory.setId(id);
                    // 继续设置其他属性
                    LeaveRecordDAO leaveRecordDAO=new LeaveRecordDAO();
                    leaveRecordFactory.setLeaveRecords(leaveRecordDAO.findLeaveRecordByFactoryId(id));
                }
            }
        }
        return leaveRecordFactory;
    }

    public void addLeaveRecord(LeaveRecordFactory leaveRecordFactory, SchoolTime schoolTime, String reason, int student, int teacher) throws SQLException {
        LeaveRecord leaveRecord=leaveRecordFactory.addLeaveRecordReturn(schoolTime,reason,student,teacher);
        update(leaveRecordFactory);
        leaveRecord.setFactoryId(leaveRecordFactory.getId());
        LeaveRecordDAO leaveRecordDAO=new LeaveRecordDAO();
        leaveRecordDAO.insert(leaveRecord);
        BaseDAO.closeConnection(leaveRecordDAO.connection);
    }
}
