package basicClass;

import basicClass.face.FaceController;
import basicClass.face.FaceInformation;

import java.util.ArrayList;

public class MyClass {
    String name;
    ArrayList<Student> students;
    ArrayList<Course> courses;

    Course[][] courseTable;

//    LeaveRecordFactory leaveRecordFactory;

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
        courses=new ArrayList<>();
        students=new ArrayList<>();
        courseTable = new Course[8][9];//课程表从courseTable[1][1]开始用，横向为周几，竖向为第几节课
        for (Course course : courses) {
            for (CourseTime courseTime : course.courseTimes) {
                courseTable[courseTime.dayInWeek][courseTime.getDayTimeNumber()]=course;
            }
        }
    }

    public ArrayList<FaceInformation> getStudentsFace(){
        ArrayList<FaceInformation> faceInformations=new ArrayList<>();
        for (Student student:students){
            faceInformations.add(student.getFaceInformation());
        }
        return faceInformations;
    }

    public void addStudent(Student student){
        this.students.add(student);
    }

    public Student ifThisClassStudent(FaceInformation sourceFaceInformation){
        FaceController faceController=new FaceController();
        for (Student student:students){
            if(faceController.ifSamePeople(student.getFaceInformation(),sourceFaceInformation)){
                faceController.close();
                return student;
            }
        }
        faceController.close();
        return null;
    }
}
