package MyInterface.info;

import basicClass.MyClass;
import basicClass.Status;
import basicClass.Student;

public class StudentInfo {
    String name;
    boolean sex;
    String phoneNum;
    String myClass;
    String studentNumber;
    Status status;

    public StudentInfo(String name, boolean sex, String phoneNum, String myClass, String studentNumber, Status status) {
        this.name = name;
        this.sex = sex;
        this.phoneNum = phoneNum;
        this.myClass = myClass;
        this.studentNumber = studentNumber;
        this.status = status;
    }
    public StudentInfo(Student student){
        this(student.getName(),student.getSex(), student.getPhoneNumber(), student.getMyClass().getName(), student.getStudentNumber(), Status.normal);
    }
}
