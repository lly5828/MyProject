package Database;

import basicClass.AttendanceRecord;
import basicClass.DayTime;
import basicClass.SchoolTime;
import basicClass.Status;

import java.sql.*;
import java.util.ArrayList;

public class AttendanceRecordsDAO extends BaseDAO {

    public AttendanceRecordsDAO(Connection connection) {
        super(connection);
    }

    public AttendanceRecordsDAO() throws SQLException {
        super();
    }

//    @Override
//    public void insert(Object obj) throws SQLException {
//        if (obj instanceof AttendanceRecord) {
//            AttendanceRecord attendanceRecord = (AttendanceRecord) obj;
//            String query = "INSERT INTO AttendanceRecord (courseId, studentId, timeId, status) VALUES (?, ?, ?, ?)";
//            try (PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
//                statement.setInt(1, attendanceRecord.getCourseId());
//                statement.setInt(2, attendanceRecord.getStudentId());
//                TimeDao timeDao = new TimeDao();
//                timeDao.insertSchoolTime(attendanceRecord.getTime());
//                BaseDAO.closeConnection(timeDao.connection);
//                statement.setInt(3, attendanceRecord.getTime().getId());
//                statement.setString(4, attendanceRecord.getStatus().toString());
//                statement.executeUpdate();
//                ResultSet rs = statement.getGeneratedKeys();
//                if (rs.next()) {
//                    attendanceRecord.setId(rs.getInt(1));
//                }
//            }
//        }
//    }
    @Override
    public void insert(Object obj) throws SQLException {
        if (obj instanceof AttendanceRecord) {
            AttendanceRecord attendanceRecord = (AttendanceRecord) obj;
            String query = "INSERT INTO AttendanceRecord (courseId, studentId,status,weekNo,dayNo,timeNo) VALUES (?, ?, ?, ?,?,?)";
            try (PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
                statement.setInt(1, attendanceRecord.getCourseId());
                statement.setInt(2, attendanceRecord.getStudentId());
                statement.setString(3, attendanceRecord.getStatus().toString());

                statement.setInt(4, attendanceRecord.getTime().getWeek());
                statement.setInt(5, attendanceRecord.getTime().getDayInWeek());
                statement.setInt(6, attendanceRecord.getTime().getDayTime().dayTimeToNumber());

//                statement.setString(7, attendanceRecord.getCourseName().toString());

                statement.executeUpdate();
                ResultSet rs = statement.getGeneratedKeys();
                if (rs.next()) {
                    attendanceRecord.setId(rs.getInt(1));
                }
            }
        }
    }

    @Override
    public void update(Object obj) throws SQLException {
        if (obj instanceof AttendanceRecord) {
            AttendanceRecord attendanceRecord = (AttendanceRecord) obj;
            String query = "UPDATE AttendanceRecord SET status = ? WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, attendanceRecord.getStatus().toString());
                statement.executeUpdate();
            }
        }
    }

    @Override
    public void delete(Object obj) throws SQLException {
        if (obj instanceof AttendanceRecord) {
            AttendanceRecord attendanceRecord = (AttendanceRecord) obj;
            String query = "DELETE FROM AttendanceRecord WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, attendanceRecord.getId());
                statement.executeUpdate();
            }
        }
    }

    @Override
    public Object findById(int id) throws SQLException {
        String query = "SELECT * FROM AttendanceRecord WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    AttendanceRecord attendanceRecord = new AttendanceRecord();
                    attendanceRecord.setId(resultSet.getInt("id"));
                    CourseDAO courseDAO = new CourseDAO();
                    attendanceRecord.setCourseName(courseDAO.findById(resultSet.getInt("courseId")).getName());
                    attendanceRecord.setTime(new SchoolTime(resultSet.getInt("weekNo"),
                            resultSet.getInt("dayNo"), DayTime.numberToDayTime(resultSet.getInt("timeNo") )));
                    attendanceRecord.setStatus(Status.valueOf(resultSet.getString("status")));
                    attendanceRecord.setStudentId(attendanceRecord.getStudentId());
                    return attendanceRecord;
                }
            }
        }
        return null;
    }

    public ArrayList<AttendanceRecord> findByStudentId(int id) throws SQLException {
        ArrayList<AttendanceRecord> attendanceRecordArrayList = new ArrayList<>();
        String query = "SELECT * FROM AttendanceRecord WHERE studentId = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    AttendanceRecord attendanceRecord = new AttendanceRecord();
                    attendanceRecord.setId(resultSet.getInt("id"));
                    attendanceRecord.setCourseId(resultSet.getInt("courseId"));
                    CourseDAO courseDAO = new CourseDAO();
                    attendanceRecord.setCourseName(courseDAO.findById(attendanceRecord.getCourseId()).getName());
                    BaseDAO.closeConnection(courseDAO.connection);

//                    attendanceRecord.setCourseName(resultSet.getString("courseName"));

                    attendanceRecord.setTime(new SchoolTime(resultSet.getInt("weekNo"),
                            resultSet.getInt("dayNo"), DayTime.numberToDayTime(resultSet.getInt("timeNo") )));
                    attendanceRecord.setStudentId(id);


                    attendanceRecord.setStatus(Status.valueOf(resultSet.getString("status")));
                    attendanceRecordArrayList.add(attendanceRecord);
                }
            }
        }
        return attendanceRecordArrayList;
    }


    public AttendanceRecord findByStuTime(int stuId,SchoolTime schoolTime) throws SQLException {
        String query = "SELECT * FROM AttendanceRecord WHERE studentId = ? and weekNo=? and dayNo=? and timeNo=?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, stuId);
            statement.setInt(2, schoolTime.getWeek());
            statement.setInt(3, schoolTime.getDayInWeek());
            statement.setInt(4, schoolTime.getDayTime().dayTimeToNumber());
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    AttendanceRecord attendanceRecord = new AttendanceRecord();
                    attendanceRecord.setId(resultSet.getInt("id"));
                    CourseDAO courseDAO = new CourseDAO();
                    attendanceRecord.setCourseName(courseDAO.findById(resultSet.getInt("courseId")).getName());
                    attendanceRecord.setTime(new SchoolTime(resultSet.getInt("weekNo"),
                            resultSet.getInt("dayNo"), DayTime.numberToDayTime(resultSet.getInt("timeNo") )));
                    attendanceRecord.setStatus(Status.valueOf(resultSet.getString("status")));
                    attendanceRecord.setStudentId(stuId);
                    return attendanceRecord;
                }
            }
        }
        return null;
    }

    public void changeStatus(AttendanceRecord attendanceRecord, Status status) throws SQLException {

        String query = "UPDATE AttendanceRecord SET status = ? WHERE weekNo = ? and dayNo=? and timeNo=? and studentId=?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, status.toString());
//            statement.setInt(2, attendanceRecord.getId());
            statement.setInt(2, attendanceRecord.getTime().getWeek());
            statement.setInt(3, attendanceRecord.getTime().getDayInWeek());
            statement.setInt(4, attendanceRecord.getTime().getDayTime().dayTimeToNumber());
            statement.setInt(5, attendanceRecord.getStudentId());
            statement.executeUpdate();
        }

    }

}