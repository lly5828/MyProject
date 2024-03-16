package MyInterface;

import basicClass.Student;

public class InterfaceToWeb {
    public static Student getStudent(String studentNum){
        return new Student("aaa","111",true,studentNum);
    }
}
