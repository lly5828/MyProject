package test;

import basicClass.*;

public class Test {
    public static void main(String[] args) {
        Student student = new Student("aaa","121212",true,new MyClass(),"1", Status.normal);
        student.showStudentInformation();


        for (DayTime i = DayTime.morning1; i!=null; i=MyFunction.nextDayTime(i)) {
            System.out.println(i);
        }
    }
}
