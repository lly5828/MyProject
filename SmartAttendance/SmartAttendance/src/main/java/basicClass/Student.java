package basicClass;

import Database.MyClassesDAO;
import basicClass.face.FaceInformation;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;


//学生
public class Student extends Person{
    protected int PersonId;




//    public static final int countWeeks=52;//周数
    public static final int countWeeks=1;//周数


    public MyClass getMyClass() {
        return myClass;
    }
    public MyClass getMyClassBySQL() throws SQLException {
        MyClassesDAO myClassesDAO=new MyClassesDAO();
        return (MyClass) myClassesDAO.findById(myClassId);
    }

    protected MyClass myClass;
    protected String studentNumber;
    protected Status status;
    int myClassId;
    protected ArrayList<AttendanceRecord> attendanceRecords;

    public Student(String name,String phoneNumber,boolean sex,MyClass myClass,String studentNumber){
        this(name, phoneNumber, sex, studentNumber);
        setMyClass(myClass);
    }

    public Student(String name,String phoneNumber,boolean sex,String studentNumber){
        super(name, phoneNumber, sex);
        this.studentNumber=studentNumber;
        this.status=Status.normal;
        this.attendanceRecords=new ArrayList<>();
        this.setId(Integer.parseInt(this.getStudentNumber()));
    }
    private ArrayList<AttendanceRecord> initAttendanceRecord(){
        ArrayList<AttendanceRecord> attendanceRecordArrayList=new ArrayList<>();
        for (int i = 1; i <=countWeeks ; i++) {
            for (int j = 1; j <=5 ; j++) {
                for (DayTime k = DayTime.morning1; k !=null ; k=k.nextCourseDayTime()) {
                    attendanceRecordArrayList.add(new AttendanceRecord(new SchoolTime(i,j,k),myClass.getCourseTable()[j][k.courseToNumber()].getName(),myClass.getCourseTable()[j][k.courseToNumber()].getId(),Status.waiting,Integer.parseInt(this.getStudentNumber())));
                }
            }
        }
        return attendanceRecordArrayList;
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
        this.attendanceRecords=initAttendanceRecord();
    }

    public void addAttendanceRecord(SchoolTime schoolTime,String courseName,int courseId,Status status,String studentNum){
        attendanceRecords.add(new AttendanceRecord(schoolTime,courseName,courseId,status,Integer.parseInt(studentNum)));
    }
    public void addAttendanceRecord(SchoolTime schoolTime,Course course,Status status){
        this.addAttendanceRecord(schoolTime,course.getName(),course.getId(),status,this.studentNumber);
    }

    public ArrayList<AttendanceRecord> getAttendanceRecords() {
        return attendanceRecords;
    }

    public AttendanceRecord getAttendanceRecordByTime(SchoolTime schoolTime){
        for(AttendanceRecord attendanceRecord:this.attendanceRecords){
            if(attendanceRecord.getTime().equals(schoolTime)){
                return attendanceRecord;
            }
        }
        AttendanceRecord attendanceRecord=new AttendanceRecord(schoolTime,this.getMyClass().getNowCourse(schoolTime).getName(),this.getMyClass().getNowCourse(schoolTime).getId(),Status.waiting,Integer.parseInt(this.studentNumber));
        this.attendanceRecords.add(attendanceRecord);
        return attendanceRecord;
    }

    public String getStudentNumber() {
        return studentNumber;
    }




    public int getPersonId() {
        return PersonId;
    }

    public void setPersonId(int personId) {
        PersonId = personId;
    }

    public Student() {
    }

    public Student(int personId) {
        PersonId = personId;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public void setStatus(Status status) {
        this.status = Status.normal;
    }

    public Status getStatus() {
        return Status.normal;
    }

    public void setAttendanceRecords(ArrayList<AttendanceRecord> attendanceRecords) {
        this.attendanceRecords = attendanceRecords;
    }

    public void setMyClassId(int myClassId) {
        this.myClassId = myClassId;
    }

    public int getMyClassId() {
        return myClassId;
    }

}


