package Database;

import basicClass.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CourseDAO extends BaseDAO {

    public CourseDAO(Connection connection) {
        super(connection);
    }
    public CourseDAO() throws SQLException {super();}

    @Override
    public void insert(Object obj) throws SQLException {
        if (obj instanceof Course) {
            Course course = (Course) obj;
            String sql = "INSERT INTO Course (name, myClassId, teacherId, classRoomId,id) VALUES (?, ?, ?, ?,?)";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, course.getName());
                statement.setInt(2, course.getMyClass().getId());
                statement.setInt(3, course.getTeacher().getId());
                statement.setInt(4, course.getClassRoom().getId());
                statement.setInt(5, course.getId());
                TimeDao timeDao=new TimeDao();
                for(CourseTime courseTime: course.getCourseTimes()){
                    courseTime.setCourseId(course.getId());
                    timeDao.insertCourseTimeWithCourseId(courseTime);
                }
                statement.executeUpdate();
            }
        } else {
            throw new IllegalArgumentException("Object is not an instance of Course");
        }
    }

    @Override
    public void update(Object obj) throws SQLException {
        if (obj instanceof Course) {
            Course course = (Course) obj;
            String sql = "UPDATE Course SET name = ?, myClassId = ?, teacherId = ?, classRoomId = ? WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, course.getName());
                statement.setInt(2, course.getMyClass().getId());
                statement.setInt(3, course.getTeacher().getId());
                statement.setInt(4, course.getClassRoom().getId());
                statement.setInt(5, course.getId());
                statement.executeUpdate();
            }
        } else {
            throw new IllegalArgumentException("Object is not an instance of Course");
        }
    }

    @Override
    public void delete(Object obj) throws SQLException {
        if (obj instanceof Course) {
            Course course = (Course) obj;
            String sql = "DELETE FROM Course WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, course.getId());
                statement.executeUpdate();
            }
        } else {
            throw new IllegalArgumentException("Object is not an instance of Course");
        }
    }

    @Override
    public Course findById(int id) throws SQLException {
        String sql = "SELECT * FROM Course WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    Course course = new Course();
                    course.setId(resultSet.getInt("id"));
                    course.setName(resultSet.getString("name"));
//                    MyClassesDAO myClassDAO = new MyClassesDAO(connection);  // 创建 MyClassDAO 实例
                    DatabaseManager databaseManager=new DatabaseManager();
                    ClassRoomDAO classRoomDAO = new ClassRoomDAO(connection);  // 创建 ClassRoomDAO 实例
                    course.setMyClassId(resultSet.getInt("myClassId"));
                    Teacher teacher = databaseManager.findTeacherById(resultSet.getInt("teacherId"));
                    ClassRoom classRoom = (ClassRoom) classRoomDAO.findById(resultSet.getInt("classRoomId"));  // 通过 classRoomDAO 调用 findById 方法
                    TimeDao timeDao=new TimeDao();
                    ArrayList<CourseTime> courseTimeArrayList=timeDao.findCourseTimesByCourseId(course.getId());
                    BaseDAO.closeConnection(timeDao.connection);
                    course.setTeacher(teacher);  // 设置 Teacher 对象到 course 中
                    course.setClassRoom(classRoom);  // 设置 ClassRoom 对象到 course 中
                    course.setCourseTimes(courseTimeArrayList);
                    return course;
                }
            }
        }
        return null;
    }

    public ArrayList<Course> findByMyClassId(int id) throws SQLException {
        ArrayList<Course> courseArrayList=new ArrayList<>();
        String sql = "SELECT * FROM Course WHERE myClassId = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Course course = new Course();
                    course.setId(resultSet.getInt("id"));
                    course.setName(resultSet.getString("name"));
                    DatabaseManager databaseManager=new DatabaseManager();
                    course.setMyClassId(resultSet.getInt("myClassId"));
                    Teacher teacher = databaseManager.findTeacherById(resultSet.getInt("teacherId"));
                    BaseDAO.closeConnection(databaseManager.conn);

                    TimeDao timeDao=new TimeDao();
                    ArrayList<CourseTime> courseTimeArrayList=timeDao.findCourseTimesByCourseId(course.getId());
                    BaseDAO.closeConnection(timeDao.connection);
                    course.setTeacher(teacher);  // 设置 Teacher 对象到 course 中
                    course.setCourseTimes(courseTimeArrayList);
                    courseArrayList.add(course);
                }
            }
        }
        return courseArrayList;
    }

    public String getCourseNameById(int id) throws SQLException {
        String sql = "SELECT * FROM Course WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getString("name");
                }
            }
        }
        return null;
    }
}