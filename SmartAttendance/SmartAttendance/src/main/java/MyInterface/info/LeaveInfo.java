package MyInterface.info;

import Database.BaseDAO;
import Database.DatabaseManager;
import Database.MyClassesDAO;
import MyInterface.InterfaceToWeb;
import basicClass.*;
import basicClass.LeaveInfo.LeaveRecord;

import java.sql.SQLException;


public class LeaveInfo {
    int leaveRecordNum;
    String student;
    String studentID;
    String myClass;
    String time;
    String reason;

    public LeaveInfo(LeaveRecord leaveRecord) throws SQLException {
        DatabaseManager databaseManager=new DatabaseManager();
        MyClassesDAO myClassesDAO=new MyClassesDAO();
        int studentId=leaveRecord.getStudentApplyId();
        this.leaveRecordNum=leaveRecord.getLeaveRecordNum();
        this.student = databaseManager.getStudentNameByStuId(studentId);
        this.studentID = String.valueOf(studentId);
        this.myClass = myClassesDAO.getClassNameByClassId(databaseManager.getStudentClassIdByStuId(studentId));
        this.time =  InterfaceToWeb.getDateBySchoolTime(leaveRecord.getStartTime());
        this.reason = leaveRecord.getReason();
        BaseDAO.closeConnection(databaseManager.conn);
        BaseDAO.closeConnection(myClassesDAO.connection);
    }

    public LeaveInfo(int leaveRecordNum,String student, String studentID, String myClass, String time, String reason) {
        this.leaveRecordNum=leaveRecordNum;
        this.student = student;
        this.studentID = studentID;
        this.myClass = myClass;
        this.time = time;
        this.reason = reason;
    }
}
