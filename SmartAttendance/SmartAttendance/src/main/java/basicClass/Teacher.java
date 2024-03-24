package basicClass;
//老师
public class Teacher extends Person{
    MyClass teachClass;
    Course teachCourse;
    String teacherNumber;

    public Teacher(String name, String phoneNumber, boolean sex, String teacherNumber) {
        super(name, phoneNumber, sex);
        this.teacherNumber = teacherNumber;
    }

    public String getTeacherNumber() {
        return teacherNumber;
    }

    public MyClass getTeachClass() {
        return teachClass;
    }

    public void setTeachClass(MyClass teachClass) {
        this.teachClass = teachClass;
    }

    public void setTeachCourse(Course teachCourse) {
        this.teachCourse = teachCourse;
    }
}
