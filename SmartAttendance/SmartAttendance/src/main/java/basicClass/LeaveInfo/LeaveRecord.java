package basicClass.LeaveInfo;

import basicClass.SchoolTime;
import basicClass.Student;
import basicClass.Teacher;

public class LeaveRecord {
    int leaveRecordNum;

    SchoolTime startTime;

    SchoolTime endTime;

    String reason;

    Student student_apply;

    Teacher teacher_deal;

    LeaveResult leaveResult;


    public LeaveRecord(int leaveRecordNum, SchoolTime startTime, SchoolTime endTime, String reason, Student student_apply, Teacher teacher_deal) {
        this.leaveRecordNum = leaveRecordNum;
        this.startTime = startTime;
        this.endTime = endTime;
        this.reason = reason;
        this.student_apply = student_apply;
        this.teacher_deal = teacher_deal;
        this.leaveResult=LeaveResult.waiting;
    }


    public Student getStudent_apply() {
        return student_apply;
    }

    public Teacher getTeacher_deal() {
        return teacher_deal;
    }

    public void setLeaveResult(LeaveResult leaveResult) {
        this.leaveResult = leaveResult;
    }

//    ifPass==true-->pass apply
    public void dealLeaveRecord(boolean ifPass){
        if(ifPass) {
            this.setLeaveResult(LeaveResult.pass);
        }else {
            this.setLeaveResult(LeaveResult.fail);
        }
    }

    public SchoolTime getStartTime() {
        return startTime;
    }

    public int getLeaveRecordNum() {
        return leaveRecordNum;
    }

    public String getReason() {
        return reason;
    }
}
