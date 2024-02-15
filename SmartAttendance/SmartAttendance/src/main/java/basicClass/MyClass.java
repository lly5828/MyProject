package basicClass;

import java.util.ArrayList;

public class MyClass {
    String name;
    ArrayList<Student> students;
    ArrayList<Course> courses;

    Course[][] courseTable;

//    public void showCourseTable(){
//        System.out.println("Class"+this.name+"Course Table");
//        for (int i=1;i<8;i++){
//            for (DayTime j =DayTime.morning1 ;j!=null;j=MyFunction.nextDayTime(j) ) {
//                for(Course courseTimes:courses){
//                    for(CourseTime courseTime:courseTimes.courseTimes){
//                        if(courseTime.dayInWeek==i&&courseTime.dayTime.)
//                    }
//                }
//            }
//        }
//    }

    public MyClass() {
        courseTable = new Course[8][9];//课程表从courseTable[1][1]开始用，横向为周几，竖向为第几节课

        for (Course course : courses) {
            for (CourseTime courseTime : course.courseTimes) {
                courseTable[courseTime.dayInWeek][courseTime.getDayTimeNumber()]=course;
            }
        }


    }
}
