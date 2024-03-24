package basicClass;

import basicClass.face.FaceInformation;

import java.util.ArrayList;
import java.util.Map;


//学生
public class Student extends Person{
    public static final int countWeeks=20;//周数

    public MyClass getMyClass() {
        return myClass;
    }

    protected MyClass myClass;
    protected String studentNumber;
    protected Status status;
    protected ArrayList<AttendanceRecord> attendanceRecords;

    public Student(String name,String phoneNumber,boolean sex,MyClass myClass,String studentNumber){
        super(name, phoneNumber, sex);
        this.myClass=myClass;
        this.studentNumber=studentNumber;
        this.status=Status.normal;
        this.attendanceRecords=new ArrayList<>();
    }

    public Student(String name,String phoneNumber,boolean sex,String studentNumber){
        super(name, phoneNumber, sex);
        this.studentNumber=studentNumber;
        this.status=Status.normal;
        this.attendanceRecords=new ArrayList<>();
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

    public void setMyClass(MyClass myClass) {
        this.myClass = myClass;
    }

    public void addAttendanceRecord(SchoolTime schoolTime,String courseName,Status status){
        attendanceRecords.add(new AttendanceRecord(schoolTime,courseName,status));
    }

    public ArrayList<AttendanceRecord> getAttendanceRecords() {
        return attendanceRecords;
    }

    public String getStudentNumber() {
        return studentNumber;
    }
}


