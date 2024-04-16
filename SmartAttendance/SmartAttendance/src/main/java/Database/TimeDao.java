package Database;

import basicClass.*;
import basicClass.LeaveInfo.LeaveRecord;
import basicClass.LeaveInfo.LeaveRecordFactory;

import java.sql.*;
import java.util.ArrayList;

public class TimeDao {
    protected Connection connection;

    public TimeDao() throws SQLException {
        this.connection = DatabaseConnectionManager.getConnection();
    }

    public void insertSchoolTime(SchoolTime schoolTime) throws SQLException {
        String query = "INSERT INTO SchoolTimeTable (week,courseTimeId) VALUES (?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query,Statement.RETURN_GENERATED_KEYS)) {
            statement.setInt(1, schoolTime.getWeek());
            insertCourseTime(schoolTime.getCourseTime());
            statement.setInt(2, schoolTime.getCourseTime().getId());
            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
            if (rs.next()) {
                schoolTime.setId(rs.getInt(1));
            }
        }
    }

    public void insertCourseTime(CourseTime courseTime) throws SQLException {
//        String query = "INSERT INTO CourseTime (dayInWeek,dayTime) VALUES (?, ?)";
        String query = "INSERT INTO CourseTime (dayInWeek,timeNo) VALUES (?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            statement.setInt(1, courseTime.getDayInWeek());
//            statement.setString(2, courseTime.getDayTime().toString());
            statement.setInt(2, courseTime.getDayTime().dayTimeToNumber());
            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
            if (rs.next()) {
                courseTime.setId(rs.getInt(1));
            }
        }
    }

    public SchoolTime findSchoolTimeById(int id) throws SQLException {
        SchoolTime schoolTime = null;
        String query = "SELECT * FROM SchoolTimeTable WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    schoolTime = new SchoolTime();
                    schoolTime.setWeek(resultSet.getInt("week"));
                    CourseTime courseTime=findCourseTimeById(resultSet.getInt("courseTimeId"));
                    if(courseTime==null){
                        return null;
                    }else {
                        schoolTime.setCourseTime(courseTime);
                    }
                }
            }
        }
        return schoolTime;
    }

    public CourseTime findCourseTimeById(int id) throws SQLException {
        CourseTime courseTime = null;
        String query = "SELECT * FROM CourseTime WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    courseTime = new CourseTime();
                    courseTime.setDayInWeek(resultSet.getInt("dayInWeek"));
//                    courseTime.setDayTime(DayTime.valueOf(resultSet.getString("dayTime")));
                    courseTime.setDayTime(DayTime.numberToDayTime(resultSet.getInt("timeNo")));
                }
            }
        }
        return courseTime;
    }

    public ArrayList<CourseTime> findCourseTimesByCourseId(int courseId) {
        ArrayList<CourseTime> courseTimeArrayList = new ArrayList<>();
        String query = "SELECT * FROM CourseTime WHERE courseId = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, courseId);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                CourseTime courseTime = new CourseTime();
                courseTime.setDayInWeek(resultSet.getInt("dayInWeek"));
//                courseTime.setDayTime(DayTime.valueOf(resultSet.getString("dayTime")));
                courseTime.setDayTime(DayTime.numberToDayTime(resultSet.getInt("timeNo")));
                courseTimeArrayList.add(courseTime);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return courseTimeArrayList;
    }

    public void insertCourseTimeWithCourseId(CourseTime courseTime) throws SQLException {
//        String query = "INSERT INTO CourseTime (dayInWeek,dayTime,courseId) VALUES (?, ?,?)";
        String query = "INSERT INTO CourseTime (dayInWeek,timeNo,courseId) VALUES (?, ?,?)";
        try (PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            statement.setInt(1, courseTime.getDayInWeek());
//            statement.setString(2, courseTime.getDayTime().toString());
            statement.setInt(2, courseTime.getDayTime().dayTimeToNumber());
            statement.setInt(3, courseTime.getCourseId());
            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
            if (rs.next()) {
                courseTime.setId(rs.getInt(1));
            }
        }
    }
}
