package MyInterface;

import MyInterface.info.AttendanceInfo;
import MyInterface.info.LeaveInfo;
import basicClass.*;
import basicClass.LeaveInfo.LeaveRecord;
import basicClass.LeaveInfo.LeaveRecordFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class InterfaceToWeb {
    public static Student getStudent(String studentNum){
        //
        return new Student("testStudent","111",true,new MyClass("aaa"),studentNum);
        //
    }

    public static ArrayList getAttendanceRecord(Student student){
        return student.getAttendanceRecords();
    }
    public static void applyLeave(Student student,int start_weekNum,int start_dayInWeek,int start_courseNum,
                                  int end_weekNum,int end_dayInWeek,int end_courseNum,String reason){}
    public static int applyLeave(Student student,SchoolTime startTime,SchoolTime endTime,String reason){
        //
        return 0;
        //
    }

    public static Teacher getTeacher(String teacherNum){
        Teacher teacher;
        //
        teacher=new Teacher("testTeacher","111",true,teacherNum);
        MyClass myClass=new MyClass("xxx");
        myClass.getLeaveRecordFactory().addLeaveRecord(new SchoolTime(14,2,DayTime.morning1),"aaa",new Student("testStudent","111",true,new MyClass("xxx"),"111"),new Teacher("testTeacher","111",true,"111"));
        myClass.getLeaveRecordFactory().addLeaveRecord(new SchoolTime(14,3,DayTime.morning1),"aaa",new Student("testStudent2","222",true,new MyClass("xxx"),"222"),new Teacher("testTeacher2","222",true,"222"));
        teacher.setTeachClass(myClass);
        //
        return teacher;
    }
    public static LeaveRecordFactory getLeaveRecord(Teacher teacher){
        //
        return new LeaveRecordFactory("aaa");
        //
    }
    public static LeaveRecordFactory getLeaveRecordFactory(MyClass myClass){



        return myClass.getLeaveRecordFactory();
    }
    public static ArrayList<LeaveInfo> factoryToLeaveInfo(LeaveRecordFactory leaveRecordFactory){
        ArrayList<LeaveInfo> result=new ArrayList<>();
        for(int i=1;i<=leaveRecordFactory.getRecordCount();i++){
            result.add(new LeaveInfo(leaveRecordFactory.getLeaveRecord(i)));
        }
        return result;
    }
    public static void dealLeaveRecord(Teacher teacher,int leaveRecordNum,boolean result){

    }

    public static SchoolTime getDate(String dateStr,DayTime dayTime) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        GregorianCalendar g=new GregorianCalendar();
        try {
            g.setTime(dateFormat.parse(dateStr));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        int dayOfWeek=g.get(Calendar.DAY_OF_WEEK)==1?7:g.get(Calendar.DAY_OF_WEEK)-1;
        return new SchoolTime(g.get(Calendar.WEEK_OF_YEAR),dayOfWeek,dayTime);
    }

    public static String getDateBySchoolTime(SchoolTime schoolTime){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        GregorianCalendar g=new GregorianCalendar();
        g.setWeekDate(2024,schoolTime.getWeek(), (schoolTime.getDayInWeek()==7)?1:schoolTime.getDayInWeek()+1);
        return dateFormat.format(g.getTime());
    }

    public static ArrayList<AttendanceInfo> attendanceSituation(Student student){
        ArrayList<AttendanceRecord> attendanceRecords=student.getAttendanceRecords();
        ArrayList<AttendanceInfo> result=new ArrayList<>();

        //
        student.addAttendanceRecord(SchoolTime.getNowSchoolTime(),"aaa", Status.normal);
        student.addAttendanceRecord(new SchoolTime(1,1, DayTime.afternoon1),"bbb", Status.normal);
        result.add(new AttendanceInfo(getDateBySchoolTime(SchoolTime.getNowSchoolTime()),false,8,0));
        result.add(new AttendanceInfo(getDateBySchoolTime(new SchoolTime(1,1, DayTime.afternoon1)),true,0,0));
        //
        return result;
    }
}
