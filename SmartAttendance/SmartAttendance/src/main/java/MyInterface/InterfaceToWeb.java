package MyInterface;

import basicClass.AttendanceRecord;
import basicClass.LeaveInfo.LeaveRecordFactory;
import basicClass.Student;
import basicClass.Teacher;

import java.util.ArrayList;

public class InterfaceToWeb {
    public static Student getStudent(String studentNum){
        return new Student("testStudent","111",true,studentNum);
    }

    public static ArrayList getAttendanceRecord(Student student){return student.getAttendanceRecords();}
    public static void applyLeave(Student student,int start_weekNum,int start_dayInWeek,int start_courseNum,
                                  int end_weekNum,int end_dayInWeek,int end_courseNum,String reason){}


    public static Teacher getTeacher(String teacherNum){
        return new Teacher("testTeacher","111",true,teacherNum);
    }
    public static LeaveRecordFactory getLeaveRecord(Teacher teacher){
        return new LeaveRecordFactory("aaa");
    }
    public static void dealLeaveRecord(Teacher teacher,int leaveRecordNum,boolean result){

    }
}
