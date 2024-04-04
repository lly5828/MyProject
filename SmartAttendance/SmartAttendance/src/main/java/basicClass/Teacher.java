package basicClass;

import Database.MyClassesDAO;

import java.sql.SQLException;

//老师
public class Teacher extends Person{
    int id;





    MyClass teachClass;
    Course teachCourse;
    String teacherNumber;

    public void setTeachClassId(int teachClassId) {
        this.teachClassId = teachClassId;
    }

    public int getTeachClassId() {
        return teachClassId;
    }

    int teachClassId;


    public Teacher(String name, String phoneNumber, boolean sex, String teacherNumber) {
        super(name, phoneNumber, sex);
        this.teacherNumber = teacherNumber;
        this.setId(Integer.parseInt(this.getTeacherNumber()));
    }

    public Teacher() {
    }

    public String getTeacherNumber() {
        return teacherNumber;
    }

    public MyClass getTeachClass() {
        return teachClass;
    }
    public MyClass getTeachClassBySQL() throws SQLException {
        MyClassesDAO myClassesDAO=new MyClassesDAO();
        return (MyClass) myClassesDAO.findById(teachClassId);
    }

    public void setTeachClass(MyClass teachClass) {
        this.teachClass = teachClass;
    }

    public void setTeachCourse(Course teachCourse) {
        this.teachCourse = teachCourse;
    }





    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Teacher(int teacherID, String name, String phoneNumber, String gender) {
        this.id=teacherID;
        this.name=name;
        this.phoneNumber=phoneNumber;
//        this
    }

    public Course getTeachCourse(){
        return teachCourse;
    }
    public Teacher(int personId,String teacherNumber,int teachClasID ) {
        this.id=personId;
        this.teacherNumber=teacherNumber;
        this.teachCourse.id=teachClasID;
    }
    public static Teacher newNullTeacher(MyClass myClass){
        Teacher teacher=new Teacher("null","null",true,"32767");
        teacher.setTeachClass(myClass);
        teacher.setId(32767);
        return teacher;
    }
    public static Teacher newNullTeacher(int myClass){
        Teacher teacher=new Teacher("null","null",true,"32767");
        teacher.setTeachClassId(myClass);
        teacher.setId(32767);
        return teacher;
    }

    public void setTeacherNumber(String teacherNumber) {
        this.teacherNumber = teacherNumber;
    }
}
