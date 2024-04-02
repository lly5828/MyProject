package basicClass;

import basicClass.LeaveInfo.LeaveRecordFactory;
import basicClass.face.FaceController;
import basicClass.face.FaceInformation;

import java.util.ArrayList;

public class MyClass {
    protected int id;

    String name;
    ArrayList<Student> students;
    ArrayList<Course> courses;
    Teacher teacher;
    Course[][] courseTable;
    LeaveRecordFactory leaveRecordFactory;
    int leaveRecordFactoryId;

    public void setLeaveRecordFactoryId(int leaveRecordFactoryId) {
        this.leaveRecordFactoryId = leaveRecordFactoryId;
    }

    public int getLeaveRecordFactoryId() {
        return leaveRecordFactoryId;
    }

    public void showCourseTable() {
        System.out.println("Class" + this.name + "Course Table");
//        for (int i=1;i<8;i++){
//            for (int j = 0; j < 9; j++) {
//
//            }
//        }
    }


    public void setCourse(Course course){
        this.courses.add(course);
    }
    public void initCourseTable(){
        for(Course course:this.courses){
            for(CourseTime courseTime: course.getCourseTimes()){
                courseTable[courseTime.getDayInWeek()][courseTime.getDayTimeNumber()]=course;
            }
        }
    }

    public MyClass() {
        courses = new ArrayList<>();
        students = new ArrayList<>();
        courseTable = new Course[6][9];//课程表从courseTable[1][1]开始用，横向为周几，竖向为第几节课
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 9; j++) {
                courseTable[i][j] = new Course("empty");
            }
        }
    }

    public MyClass(String name) {
        this();
        this.name = name;
        leaveRecordFactory=new LeaveRecordFactory(name);
    }

    public ArrayList<FaceInformation> getStudentsFace() {
        ArrayList<FaceInformation> faceInformations = new ArrayList<>();
        for (Student student : students) {
            faceInformations.add(student.getFaceInformation());
        }
        return faceInformations;
    }

    public void addStudent(Student student) {
        this.students.add(student);
        student.setMyClass(this);
    }

    public Student ifThisClassStudent(FaceInformation sourceFaceInformation) {
        if (sourceFaceInformation == null) return null;
        FaceController faceController = new FaceController();
        for (Student student : students) {
            if (faceController.ifSamePeople(student.getFaceInformation(), sourceFaceInformation)) {
                faceController.close();
                return student;
            }
        }
        faceController.close();
        return null;
    }

    public Course getNowCourse(SchoolTime schoolTime) {
        if (schoolTime.getDayTime() == DayTime.other)
            return null;
        if (schoolTime.getCourseTime().getDayTimeNumber() == 0) return new Course("rest");
        return courseTable[schoolTime.getDayInWeek()][schoolTime.getCourseTime().getDayTimeNumber()];

    }

    public Course getNextCourseByTime(SchoolTime schoolTime) {
        return courseTable[schoolTime.getDayInWeek()][(schoolTime.getCourseTime().getDayTimeNumber() == 0) ? schoolTime.getCourseTime().getNextCourseTimeNumber() : 0];
    }

    public String getName() {
        return name;
    }

    public LeaveRecordFactory getLeaveRecordFactory() {
        return leaveRecordFactory;
    }

//    public Teacher getTeacher() {
//        return teacher;
//    }

    public Course[][] getCourseTable() {
        return courseTable;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
        leaveRecordFactory=new LeaveRecordFactory(name);
    }

    public void setCourses(ArrayList<Course> courses) {
        this.courses = courses;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    public void setLeaveRecordFactory(LeaveRecordFactory leaveRecordFactory) {
        this.leaveRecordFactory = leaveRecordFactory;
    }
}
