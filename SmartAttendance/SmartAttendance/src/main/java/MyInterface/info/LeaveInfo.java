package MyInterface.info;

import MyInterface.InterfaceToWeb;
import basicClass.*;
import basicClass.LeaveInfo.LeaveRecord;


public class LeaveInfo {
    int leaveRecordNum;
    String student;
    String studentID;
    String myClass;
    String time;
    String reason;

    public LeaveInfo(LeaveRecord leaveRecord) {
        this(leaveRecord.getLeaveRecordNum(),leaveRecord.getStudent_apply().getName(),leaveRecord.getStudent_apply().getStudentNumber(),
                leaveRecord.getStudent_apply().getMyClass().getName(), InterfaceToWeb.getDateBySchoolTime(leaveRecord.getStartTime()),leaveRecord.getReason());
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
