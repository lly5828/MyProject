package MyInterface.info;

import basicClass.Teacher;

import java.sql.SQLException;

public class TeacherInfo {
    String name;
    boolean sex;
    String phoneNum;
    String teachClass;
    String teacherNum;


    public TeacherInfo(String name, boolean sex, String phoneNum, String teachClass, String teacherNum) {
        this.name = name;
        this.sex = sex;
        this.phoneNum = phoneNum;
        this.teachClass = teachClass;
        this.teacherNum = teacherNum;
    }

    public TeacherInfo(Teacher teacher) throws SQLException {
        this(teacher.getName(), teacher.getSex(), teacher.getPhoneNumber(), teacher.getTeachClassBySQL().getName(),teacher.getTeacherNumber());
    }
}
