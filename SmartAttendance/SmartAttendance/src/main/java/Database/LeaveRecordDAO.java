package Database;

import basicClass.DayTime;
import basicClass.LeaveInfo.LeaveRecord;
import basicClass.LeaveInfo.LeaveResult;
import basicClass.SchoolTime;
import basicClass.Student;
import basicClass.Teacher;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class LeaveRecordDAO extends BaseDAO {
    public LeaveRecordDAO() throws SQLException {
        super();
    }

    public LeaveRecordDAO(Connection connection) {
        super(connection);
    }

    //    @Override
//    public void insert(Object obj) throws SQLException {
//        if (obj instanceof LeaveRecord) {
//            LeaveRecord leaveRecord = (LeaveRecord) obj;
//            String query = "INSERT INTO LeaveRecord (leaveRecordNum ,startTimeId, endTimeId, reason, studentApplyId, teacherDealId, leaveResult,factoryId) VALUES (?, ?, ?, ?, ?, ?,?,?)";
//            try (PreparedStatement statement = connection.prepareStatement(query)) {
//                statement.setInt(1, leaveRecord.getLeaveRecordNum());
//                TimeDao timeDao = new TimeDao();
//                timeDao.insertSchoolTime(leaveRecord.getStartTime());
//                timeDao.insertSchoolTime(leaveRecord.getEndTime());
//                statement.setInt(2, leaveRecord.getStartTime().getId());
//                statement.setInt(3, leaveRecord.getEndTime().getId());
//                statement.setString(4, leaveRecord.getReason());
//                statement.setInt(5, leaveRecord.getStudent_apply().getId());
//                statement.setInt(6, leaveRecord.getTeacher_deal().getId());
//                statement.setString(7, leaveRecord.getLeaveResult().toString());
//                statement.setInt(8, leaveRecord.getFactoryId());
//                statement.executeUpdate();
//            }
//        }
//    }
    @Override
    public void insert(Object obj) throws SQLException {
        if (obj instanceof LeaveRecord) {
            LeaveRecord leaveRecord = (LeaveRecord) obj;
            String query = "INSERT INTO LeaveRecord (leaveRecordNum,reason,studentApplyId,teacherDealId,leaveResult,factoryId,weekNo,dayNo,timeNo) VALUES (?, ?, ?, ?, ?, ?,?,?,?)";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, leaveRecord.getLeaveRecordNum());
                statement.setString(2, leaveRecord.getReason());
                statement.setInt(3, leaveRecord.getStudentApplyId());
                statement.setInt(4, leaveRecord.getTeacherDealId());
                statement.setString(5, leaveRecord.getLeaveResult().toString());
                statement.setInt(6, leaveRecord.getFactoryId());
                statement.setInt(7, leaveRecord.getStartTime().getWeek());
                statement.setInt(8, leaveRecord.getStartTime().getDayInWeek());
                statement.setInt(9, leaveRecord.getStartTime().getDayTime().dayTimeToNumber());
                statement.executeUpdate();
            }
        }
    }

    @Override
    public void update(Object obj) throws SQLException {
//        if (obj instanceof LeaveRecord) {
//            LeaveRecord leaveRecord = (LeaveRecord) obj;
//            String query = "UPDATE LeaveRecord SET startTime = ?, endTime = ?, reason = ?, studentApplyId = ?, teacherDealId = ?, leaveResult = ? WHERE leaveRecordNum = ?";
//            try (PreparedStatement statement = connection.prepareStatement(query)) {
//                statement.setInt(1,leaveRecord.getLeaveRecordNum());
//                statement.setTimestamp(2, leaveRecord.startTimeToTimestamp());
//                statement.setTimestamp(3, leaveRecord.endTimeToTimestamp());
//                statement.setString(4, leaveRecord.getReason());
//                statement.setString(5, leaveRecord.getStudent_apply().getStudentNumber());
//                statement.setString(6, leaveRecord.getTeacher_deal().getTeacherNumber());
//                statement.setString(7, leaveRecord.getLeaveResult().toString());
//
//                statement.executeUpdate();
//            }
//        }
    }

    @Override
    public void delete(Object obj) throws SQLException {
        if (obj instanceof LeaveRecord) {
            LeaveRecord leaveRecord = (LeaveRecord) obj;
            String query = "DELETE FROM LeaveRecords WHERE leaveRecordNum = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, leaveRecord.getLeaveRecordNum());
                statement.executeUpdate();
            }
        }
    }

//    @Override
//    public Object findById(int id) throws SQLException {
//        LeaveRecord leaveRecord = null;
//        String query = "SELECT * FROM LeaveRecord WHERE leaveRecordNum = ?";
//
//        try (PreparedStatement statement = connection.prepareStatement(query)) {
//            statement.setInt(1, id);
//            try (ResultSet resultSet = statement.executeQuery()) {
//                if (resultSet.next()) {
//                    leaveRecord = new LeaveRecord();
//                    leaveRecord.setLeaveRecordNum(resultSet.getInt("leaveRecordNum"));
//                    TimeDao timeDao = new TimeDao();
//                    SchoolTime startTime = timeDao.findSchoolTimeById(resultSet.getInt("startTimeId"));
//                    SchoolTime endTime = timeDao.findSchoolTimeById(resultSet.getInt("endTimeId"));
//                    leaveRecord.setStartTime(startTime);
//                    leaveRecord.setEndTime(endTime);
//                    leaveRecord.setReason(resultSet.getString("reason"));
//                    DatabaseManager databaseManager = new DatabaseManager();
//                    Student student = databaseManager.findStudentById(resultSet.getInt("studentApplyId"));
//                    Teacher teacher = databaseManager.findTeacherById(resultSet.getInt("teacherDealId"));
//                    leaveRecord.setStudent_apply(student);
//                    leaveRecord.setTeacher_deal(teacher);
//                    leaveRecord.setLeaveResult(LeaveResult.valueOf(resultSet.getString("leaveResult")));
//                }
//            }
//        }
//        return leaveRecord;
//    }

    //    public ArrayList<LeaveRecord> findLeaveRecordByFactoryId(int id) throws SQLException {
//        ArrayList<LeaveRecord> leaveRecordArrayList = new ArrayList<>();
//        String query = "SELECT * FROM LeaveRecord WHERE factoryId = ?";
//        try (PreparedStatement statement = connection.prepareStatement(query)) {
//            statement.setInt(1, id);
//            try (ResultSet resultSet = statement.executeQuery()) {
//                while (resultSet.next()) {
//                    LeaveRecord leaveRecord = new LeaveRecord();
//                    leaveRecord = new LeaveRecord();
//                    leaveRecord.setLeaveRecordNum(resultSet.getInt("leaveRecordNum"));
//                    TimeDao timeDao = new TimeDao();
//                    SchoolTime startTime = timeDao.findSchoolTimeById(resultSet.getInt("startTimeId"));
//                    SchoolTime endTime = timeDao.findSchoolTimeById(resultSet.getInt("endTimeId"));
//                    leaveRecord.setStartTime(startTime);
//                    leaveRecord.setEndTime(endTime);
//                    leaveRecord.setReason(resultSet.getString("reason"));
//                    DatabaseManager databaseManager = new DatabaseManager();
//                    Student student = databaseManager.findStudentById(resultSet.getInt("studentApplyId"));
//                    Teacher teacher = databaseManager.findTeacherById(resultSet.getInt("teacherDealId"));
//                    leaveRecord.setStudent_apply(student);
//                    leaveRecord.setTeacher_deal(teacher);
//                    leaveRecord.setLeaveResult(LeaveResult.valueOf(resultSet.getString("leaveResult")));
//                    leaveRecord.setFactoryId(id);
//                    leaveRecordArrayList.add(leaveRecord);
//                }
//            }
//        }
//        return leaveRecordArrayList;
//    }
    @Override
    public Object findById(int id) throws SQLException {
        LeaveRecord leaveRecord = null;
        String query = "SELECT * FROM LeaveRecord WHERE leaveRecordNum = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    leaveRecord = new LeaveRecord();
                    leaveRecord.setLeaveRecordNum(resultSet.getInt("leaveRecordNum"));
                    leaveRecord.setReason(resultSet.getString("reason"));
                    DatabaseManager databaseManager = new DatabaseManager();
                    Student student = databaseManager.findStudentById(resultSet.getInt("studentApplyId"));
                    Teacher teacher = databaseManager.findTeacherById(resultSet.getInt("teacherDealId"));
                    leaveRecord.setStudent_apply(student);
                    leaveRecord.setTeacher_deal(teacher);
                    leaveRecord.setLeaveResult(LeaveResult.valueOf(resultSet.getString("leaveResult")));

                    leaveRecord.setTime(new SchoolTime(resultSet.getInt("weekNo"),
                            resultSet.getInt("dayNo"), DayTime.numberToDayTime(resultSet.getInt("timeNo") )));
                }
            }
        }
        return leaveRecord;
    }

    public ArrayList<LeaveRecord> findLeaveRecordByFactoryId(int id) throws SQLException {
        ArrayList<LeaveRecord> leaveRecordArrayList = new ArrayList<>();
        String query = "SELECT * FROM LeaveRecord WHERE factoryId = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    LeaveRecord leaveRecord = new LeaveRecord();
                    leaveRecord = new LeaveRecord();
                    leaveRecord.setLeaveRecordNum(resultSet.getInt("leaveRecordNum"));
                    leaveRecord.setReason(resultSet.getString("reason"));
                    leaveRecord.setStudentApplyId(resultSet.getInt("studentApplyId"));
                    leaveRecord.setTeacherDealId(resultSet.getInt("teacherDealId"));
                    leaveRecord.setLeaveResult(LeaveResult.valueOf(resultSet.getString("leaveResult")));
                    leaveRecord.setFactoryId(id);
                    leaveRecord.setTime(new SchoolTime(resultSet.getInt("weekNo"),
                            resultSet.getInt("dayNo"), DayTime.numberToDayTime(resultSet.getInt("timeNo") )));
                    leaveRecordArrayList.add(leaveRecord);
                }
            }
        }
        return leaveRecordArrayList;
    }

    public ArrayList<LeaveRecord> findLeaveRecordByStudentId(int id) throws SQLException {
        ArrayList<LeaveRecord> leaveRecordArrayList = new ArrayList<>();
        String query = "SELECT * FROM LeaveRecord WHERE studentApplyId = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    LeaveRecord leaveRecord = new LeaveRecord();
                    leaveRecord = new LeaveRecord();
                    leaveRecord.setLeaveRecordNum(resultSet.getInt("leaveRecordNum"));
                    leaveRecord.setReason(resultSet.getString("reason"));
                    leaveRecord.setStudentApplyId(resultSet.getInt("studentApplyId"));
                    leaveRecord.setTeacherDealId(resultSet.getInt("teacherDealId"));
                    leaveRecord.setLeaveResult(LeaveResult.valueOf(resultSet.getString("leaveResult")));
                    leaveRecord.setFactoryId(id);
                    leaveRecord.setTime(new SchoolTime(resultSet.getInt("weekNo"),
                            resultSet.getInt("dayNo"), DayTime.numberToDayTime(resultSet.getInt("timeNo") )));
                    leaveRecordArrayList.add(leaveRecord);
                }
            }
        }
        return leaveRecordArrayList;
    }


    public void changeResult(LeaveRecord leaveRecord, LeaveResult leaveResult, Teacher teacher) throws SQLException {
        String query = "UPDATE LeaveRecord SET teacherDealId = ?, leaveResult = ? WHERE leaveRecordNum = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, teacher.getId());
            statement.setString(2, leaveResult.toString());
            statement.setInt(3, leaveRecord.getLeaveRecordNum());
            statement.executeUpdate();
        }
    }

    public void changeResult(int leaveRecordNum, LeaveResult leaveResult, int teacherNum) throws SQLException {
        String query = "UPDATE LeaveRecord SET teacherDealId = ?, leaveResult = ? WHERE leaveRecordNum = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, teacherNum);
            statement.setString(2, leaveResult.toString());
            statement.setInt(3, leaveRecordNum);
            statement.executeUpdate();
        }
    }
}