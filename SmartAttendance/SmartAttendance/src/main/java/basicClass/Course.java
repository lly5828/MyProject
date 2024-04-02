package basicClass;

import Database.*;
import basicClass.LeaveInfo.LeaveRecordFactory;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Course {
    int id;



    String name;
    ArrayList<CourseTime> courseTimes;
    MyClass myClass;
    Teacher teacher;
    ClassRoom classRoom;

    int myClassId;

    public Course(int id) {
        this.id = id;
    }

    public Course(String name) {
        this.name = name;
    }

    public Course(String name,Teacher teacher){
        this(name);
        this.teacher=teacher;
        courseTimes=new ArrayList<>();
    }

    public Course() {
        courseTimes=new ArrayList<>();
    }
    public Course(int id,String name){
        this.id=id;
        this.name=name;
        this.courseTimes=new ArrayList<>();
    }

    public Course(String name, MyClass myClass, Teacher teacher, ClassRoom classRoom) {
        this.name = name;
        this.myClass = myClass;
        this.classRoom = classRoom;
        courseTimes=new ArrayList<>();
        setTeacher(teacher);
        this.myClassId=myClass.id;
    }

    public void setCourseTimes(ArrayList<CourseTime> courseTimes){
        this.courseTimes=courseTimes;
    }

    public String getName() {
        return name;
    }


    public int getId() {
        return id;
    }

    public ArrayList<CourseTime> getCourseTimes() {
        return courseTimes;
    }

    public MyClass getMyClassById() throws SQLException {
        MyClassesDAO myClassesDAO=new MyClassesDAO();
        return (MyClass) myClassesDAO.findById(myClassId);
    }

    public MyClass getMyClass() {
        return myClass;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public ClassRoom getClassRoom() {
        return classRoom;
    }
//    public ClassRoom getClassRoomBySQL() throws SQLException {
//        ClassRoomDAO classRoomDAO=new ClassRoomDAO();
////        return classRoomDAO.findById(classRoomId)
//    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMyClass(MyClass myClass) {
        this.myClass = myClass;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
        teacher.setTeachClass(myClass);
        teacher.setTeachCourse(this);
    }

    public void setClassRoom(ClassRoom classRoom) {
        this.classRoom = classRoom;
    }

    public void addCourseTime(CourseTime courseTime){
        this.courseTimes.add(courseTime);
        courseTime.setCourseId(this.id);
    }

    public void setMyClassId(int myClassId) {
        this.myClassId = myClassId;
    }

    public int getMyClassId() {
        return myClassId;
    }

    public static Course newNullCourse(MyClass myClass){
        ClassRoom classRoom=new ClassRoom();
        classRoom.setId(1);
        classRoom.setPlace("a1");
        Course empty=new Course("empty",myClass,Teacher.newNullTeacher(myClass),classRoom);
        empty.addCourseTime(new CourseTime(0,DayTime.morning1));
        empty.setId(0);
        return empty;
    }
}
