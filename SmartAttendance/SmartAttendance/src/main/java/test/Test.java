package test;

import Camera.startCheck.Check;
import Database.DatabaseManager;
import Database.MyClassesDAO;
import MyInterface.InterfaceToWeb;
import basicClass.*;
import basicClass.face.FaceController;
import exception.MyException;

import java.sql.SQLException;

public class Test {
    public static void main(String[] args) throws SQLException {
//        FaceController faceController=new FaceController();
//        Student lly=new Student("lly","123",true,"1");
//        Student shl=new Student("shl","123",true,"2");
//        Student lhy=new Student("lhy","123",true,"3");
//
//        MyClassesDAO myClassesDAO=new MyClassesDAO();
//
//
//        lly.setFaceInformation("/opt/myProject_another/photoes/peopleList/lly1.jpeg");
//        shl.setFaceInformation("/opt/myProject_another/photoes/peopleList/shl2.jpeg");
//        lhy.setFaceInformation("/opt/myProject_another/photoes/peopleList/lhy1.jpeg");
//        MyClass myClass=new MyClass("testClass");
//        myClass.addStudent(lly);
//        myClass.addStudent(shl);
//        myClass.addStudent(lhy);

//        SchoolTime schoolTime=new SchoolTime(4,7,DayTime.afternoon1);


        SchoolTime.getNowSchoolTime().showSchoolTime();
        MyClassesDAO myClassesDAO=new MyClassesDAO();
        DatabaseManager databaseManager=new DatabaseManager();
        MyClass myClass=(MyClass) myClassesDAO.findById(2201);
        for(Student student: myClass.getStudents()){
            student.setMyClass(myClass);
            student.initFace();
        }
        try {
            Check check = new Check(myClass);
            myClass.getName();
        }catch (MyException e){
            e.printStackTrace();
        }



    }
}