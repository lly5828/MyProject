package Database;

import basicClass.AttendanceRecord;
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

    @Override
    public void insert(Object obj) throws SQLException {
        if (obj instanceof AttendanceRecord) {
            AttendanceRecord attendanceRecord = (AttendanceRecord) obj;
            String query = "INSERT INTO AttendanceRecord (courseId, studentId, timeId, status) VALUES (?, ?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
                statement.setInt(1, attendanceRecord.getCourseId());
                statement.setInt(2, attendanceRecord.getStudentId());
                TimeDao timeDao = new TimeDao();
                timeDao.insertSchoolTime(attendanceRecord.getTime());
                BaseDAO.closeConnection(timeDao.connection);
                statement.setInt(3, attendanceRecord.getTime().getId());
                statement.setString(4, attendanceRecord.getStatus().toString());
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
                    DatabaseManager databaseManager = new DatabaseManager();
                    TimeDao timeDao = new TimeDao();
                    attendanceRecord.setTime(timeDao.findSchoolTimeById(resultSet.getInt("timeId")));
                    attendanceRecord.setStatus(Status.valueOf(resultSet.getString("status")));
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
                    TimeDao timeDao = new TimeDao();
                    attendanceRecord.setTime(timeDao.findSchoolTimeById(resultSet.getInt("timeId")));
                    BaseDAO.closeConnection(timeDao.connection);
                    attendanceRecord.setStatus(Status.valueOf(resultSet.getString("status")));
                    attendanceRecordArrayList.add(attendanceRecord);
                }
            }
        }
        return attendanceRecordArrayList;
    }

    public void changeStatus(AttendanceRecord attendanceRecord, Status status) throws SQLException{

        String query = "UPDATE AttendanceRecord SET status = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1,status.toString());
            statement.setInt(2, attendanceRecord.getId());
            statement.executeUpdate();
        }

    }

}