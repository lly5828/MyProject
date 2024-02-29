package basicClass;

import basicClass.face.FaceInformation;

import java.util.ArrayList;
import java.util.Map;


//学生
public class Student extends Person{
    public static final int countWeeks=20;//周数
    protected MyClass myClass;
    protected String studentNumber;
//    protected ArrayList<PersonStatus> status;
    protected Status status;


    protected ArrayList<AttendanceRecord> attendanceRecords;

    public Student(String name,String phoneNumber,boolean sex,MyClass myClass,String studentNumber){
        super(name, phoneNumber, sex);
        this.myClass=myClass;
        this.studentNumber=studentNumber;
        this.status=Status.normal;
        this.attendanceRecords=new ArrayList<>();
        for (int i = 1; i <=countWeeks ; i++) {
            for (int j = 1; j <= 7; j++) {
                for (DayTime k =DayTime.morning1 ; k!=null ; MyFunction.nextDayTime(k)) {

                }
            }
        }
    }

    public Student(String name,String phoneNumber,boolean sex,String studentNumber){
        super(name, phoneNumber, sex);
        this.studentNumber=studentNumber;
        this.status=Status.normal;
        this.attendanceRecords=new ArrayList<>();
//        for (int i = 1; i <=countWeeks ; i++) {
//            for (int j = 1; j <= 7; j++) {
//                for (DayTime k =DayTime.morning1 ; k!=null ; MyFunction.nextDayTime(k)) {
//
//                }
//            }
//        }
    }

    public void showStudentInformation(){
        System.out.println("name:"+this.name);
        System.out.println("phoneNumber:"+this.phoneNumber);
        System.out.println("sex:"+((this.sex)?"man":"woman"));
        System.out.println("MyClass:"+this.myClass.name);
        System.out.println("studentNumber:"+this.studentNumber);
        System.out.println("status:"+this.status);
    }

    public void showCourseInformation(){
//        for(Course course:this.myClass.courses){
//
//        }
    }

    public void showAttendanceRecord(){
        for(AttendanceRecord attendanceRecord:this.attendanceRecords){
            attendanceRecord.showAttendanceRecord();
        }
    }
}

class AttendanceRecord{
    protected SchoolTime time;
    protected Course course;
    protected Status status;
    public void showAttendanceRecord(){
        System.out.print("Time:");
        time.showSchoolTime();
        System.out.println("\tCourse:"+course.name+"\tStatue"+status);
    }
}
