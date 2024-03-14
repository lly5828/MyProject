package basicClass;

import java.util.ArrayList;

public class Course {
    String name;
    ArrayList<CourseTime> courseTimes;
    MyClass myClass;
    Teacher teacher;
    ClassRoom classRoom;

    public Course(String name) {
        this.name = name;
    }

    public Course(String name,Teacher teacher){
        this(name);
        this.teacher=teacher;
    }

    public String getName() {
        return name;
    }


//    public void showCourse(){
//
//    }
}
