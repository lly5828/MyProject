package test;

import basicClass.*;
import basicClass.face.FaceController;
import basicClass.face.FaceInformation;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        FaceController faceController=new FaceController();

        FaceInformation faceInformation1=faceController.addFace("/opt/myProject_another/photoes/peopleList/shl2.jpeg");
        FaceInformation faceInformation2=faceController.addFace("/opt/myProject_another/photoes/peopleList/lly1.jpeg");

        ArrayList<FaceInformation> peopleList=new ArrayList<>();
        peopleList.add(faceInformation1);
        peopleList.add(faceInformation2);

        FaceInformation targetFace=faceController.addFace("/opt/myProject_another/photoes/shl1.jpeg");


        for (FaceInformation faceInformation:peopleList){
            if(faceController.ifSamePeople(targetFace,faceInformation)){
                System.out.println("true");
            }
        }
        System.out.println(faceController.ifSamePeople(faceInformation1,faceInformation2)?"true":"false");

        Student lly=new Student("lly","123",true,"1");
        Student shl=new Student("shl","123",true,"2");

        lly.setFaceInformation("/opt/myProject_another/photoes/peopleList/lly1.jpeg");
        shl.setFaceInformation("/opt/myProject_another/photoes/peopleList/shl2.jpeg");

        MyClass myClass=new MyClass();
        myClass.addStudent(lly);
        myClass.addStudent(shl);

        FaceInformation sourceFace=faceController.addFace("/opt/myProject_another/photoes/lly2.jpeg");
        Student student=myClass.ifThisClassStudent(sourceFace);
        if(student!=null){
            System.out.println(student.getName());
        }


    }
}
