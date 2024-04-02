package basicClass.LeaveInfo;

import Database.BaseDAO;
import Database.LeaveRecordDAO;
import basicClass.DayTime;
import basicClass.SchoolTime;
import basicClass.Student;
import basicClass.Teacher;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;

public class LeaveRecord {
    int studentApplyId;
    int teacherDealId;

    int factoryId;




    int leaveRecordNum;

    SchoolTime startTime;

    SchoolTime endTime;

    String reason;

    Student student_apply;

    Teacher teacher_deal;

    LeaveResult leaveResult;


    public LeaveRecord(int leaveRecordNum, SchoolTime startTime, SchoolTime endTime, String reason, Student student_apply,Teacher teacher_deal,int factoryId) {
        this.leaveRecordNum = leaveRecordNum;
        this.startTime = startTime;
        this.endTime = endTime;
        this.reason = reason;
        this.student_apply = student_apply;
        this.teacher_deal = teacher_deal;
        this.leaveResult=LeaveResult.waiting;
        this.factoryId=factoryId;
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



    public SchoolTime getStartTime() {
        return startTime;
    }

    public int getLeaveRecordNum() {
        return leaveRecordNum;
    }

    public String getReason() {
        return reason;
    }

    public boolean ifDayTimeDuring(DayTime dayTime){
        return (dayTime.courseToNumber()>=this.getStartTime().getDayTime().courseToNumber()&&dayTime.courseToNumber()<=this.getStartTime().getDayTime().courseToNumber())?true:false;
    }

    public boolean ifDuring(SchoolTime schoolTime){
        if(schoolTime.getWeek()==startTime.getWeek()){
            if (schoolTime.getDayInWeek()== startTime.getDayInWeek()){
                if(ifDayTimeDuring(schoolTime.getDayTime())){
                    return true;
                }else {
                    return false;
                }
            }else {
                return false;
            }
        }else {
            return false;
        }
    }




    public LeaveResult getLeaveResult() {
        return leaveResult;
    }
    // 假设定义一个方法将 SchoolTime 转换为 Timestamp
    public Timestamp startTimeToTimestamp() {
        // 假设 SchoolTime 类中有获取时间戳的方法 getTime()
        return new Timestamp(startTime.getTimeInMillis());
    }

    public Timestamp endTimeToTimestamp() {
        // 假设 SchoolTime 类中有获取时间戳的方法 getTime()
        return new Timestamp(endTime.getTimeInMillis());
    }

    public void saveToDatabase() {
        try {
            Connection connection = null;
            BaseDAO dao = new LeaveRecordDAO(connection); // 假设LeaveRecordDAO是实际的LeaveRecord数据库操作类
            dao.insert(this); // 调用BaseDAO中的insert方法将LeaveRecord对象保存到数据库
        } catch (SQLException e) {
            // 处理异常
        }
    }
    public void setStartTime(SchoolTime startTime) {
        this.startTime = startTime; // 使用 SchoolTime 的构造方法将 Timestamp 转换为 SchoolTime
    }
    public void setStartTime(Timestamp startTime) {
        this.startTime = SchoolTime.timestampToSchool(startTime);
    }

    public LeaveRecord() {
    }

    public void setLeaveRecordNum(int leaveRecordNum) {
        this.leaveRecordNum = leaveRecordNum;
    }

    public void setEndTime(SchoolTime endTime) {
        this.endTime = endTime;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public void setStudent_apply(Student student_apply) {
        this.student_apply = student_apply;
    }

    public void setTeacher_deal(Teacher teacher_deal) {
        this.teacher_deal = teacher_deal;
    }



    public void setTeacherDealId(int teacherDealId) {
        this.teacherDealId = teacherDealId;
    }

    public void setStudentApplyId(int studentApplyId) {
        this.studentApplyId = studentApplyId;
    }
    public void setEndTime(Timestamp endTime) {
        this.endTime = SchoolTime.timestampToSchool(endTime);
    }

    public int getStudentApplyId() {
        return studentApplyId;
    }

    public int getTeacherDealId() {
        return teacherDealId;
    }

    public int getFactoryId() {
        return factoryId;
    }

    public void setFactoryId(int factoryId) {
        this.factoryId = factoryId;
    }

    public SchoolTime getEndTime() {
        return endTime;
    }
}
