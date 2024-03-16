package basicClass;

import Camera.setStuInfo.CameraJFrame;

import java.util.ArrayList;

public class Manager {
    ArrayList<MyClass> allClasses;
    ArrayList<Teacher> allTeachers;
    ArrayList<Course> allCourse;
    ArrayList<ClassRoom> allClassRooms;

    public Manager(ArrayList<MyClass> allClasses, ArrayList<Teacher> allTeachers, ArrayList<Course> allCourse, ArrayList<ClassRoom> allClassRooms) {
        this.allClasses = allClasses;
        this.allTeachers = allTeachers;
        this.allCourse = allCourse;
        this.allClassRooms = allClassRooms;
    }

    public Manager() {
        this.allClasses=new ArrayList<>();
        this.allTeachers=new ArrayList<>();
        this.allCourse=new ArrayList<>();
        this.allClassRooms=new ArrayList<>();
    }


    //    添加成功返回true
    public boolean addStudent(String myClassName, Student student){
        MyClass myClass=getClassByName(myClassName);
        if(myClass!=null){
            myClass.addStudent(student);
            student.setMyClass(myClass);
            return true;
        }else {
            return false;
        }

    }

    public MyClass getClassByName(String myClassName){
        for(MyClass myClass:allClasses){
            if(myClass.getName().equals(myClassName)){
                return myClass;
            }
        }
        return null;
    }



    public void logInStudentInfo(){
        CameraJFrame cameraJFrame=new CameraJFrame();
        cameraJFrame.login(this);
    }

    public void showStudent(String className,String stuId){
        MyClass myClass=getClassByName(className);
        if(myClass!=null){
            for(Student student: myClass.students){
                if(student.studentNumber.equals(stuId)){
                    System.out.println(student.getName());
                }
            }
        }
    }


//    public static void main(String[] args) {
//        Manager manager=new Manager();
//        manager.allClasses.add(new MyClass("aaa"));
//        manager.logInStudentInfo();
//    }
}
