package MyInterface.info;

import basicClass.Teacher;

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

    public TeacherInfo(Teacher teacher) {
        this(teacher.getName(), teacher.getSex(), teacher.getPhoneNumber(), teacher.getTeachClass().getName(),teacher.getTeacherNumber());
    }
}
