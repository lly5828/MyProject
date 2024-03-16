//package test;
//
//import Camera.Camera;
//import Camera.startCheck.Check;
//import basicClass.*;
//import basicClass.face.FaceController;
//import basicClass.face.FaceInformation;
//
//import java.util.ArrayList;
//
//public class Test {
//    public static void main(String[] args) {
//        FaceController faceController=new FaceController();
//
////        FaceInformation faceInformation1=faceController.addFace("/opt/myProject_another/photoes/peopleList/shl2.jpeg");
////        FaceInformation faceInformation2=faceController.addFace("/opt/myProject_another/photoes/peopleList/lly1.jpeg");
////
////        ArrayList<FaceInformation> peopleList=new ArrayList<>();
////        peopleList.add(faceInformation1);
////        peopleList.add(faceInformation2);
////
////        FaceInformation targetFace=faceController.addFace("/opt/myProject_another/photoes/shl1.jpeg");
////
////
////        for (FaceInformation faceInformation:peopleList){
////            if(faceController.ifSamePeople(targetFace,faceInformation)){
////                System.out.println("true");
////            }
////        }
////        System.out.println(faceController.ifSamePeople(faceInformation1,faceInformation2)?"true":"false");
//
//        Student lly=new Student("lly","123",true,"1");
//        Student shl=new Student("shl","123",true,"2");
//        Student lhy=new Student("lhy","123",true,"3");
//
//        lly.setFaceInformation("/opt/myProject_another/photoes/peopleList/lly1.jpeg");
//        shl.setFaceInformation("/opt/myProject_another/photoes/peopleList/shl2.jpeg");
//        lhy.setFaceInformation("/opt/myProject_another/photoes/peopleList/lhy1.jpeg");
//
//        MyClass myClass=new MyClass("testClass");
//        myClass.addStudent(lly);
//        myClass.addStudent(shl);
//        myClass.addStudent(lhy);
//
////        FaceInformation sourceFace=faceController.addFace("/opt/myProject/photoFromCamera/1710076382841.png");
////        Student student=myClass.ifThisClassStudent(sourceFace);
////        if(student!=null){
////            System.out.println(student.getName());
////        }
//
//
//
//        SchoolTime schoolTime=new SchoolTime(1,1,DayTime.afternoon1);
//
////        Camera camera=new Camera();
////        String str= camera.getPhoto();
////        FaceInformation sourceFace=faceController.addFace(str);
////        Student student=myClass.ifThisClassStudent(sourceFace);
////        if(student!=null){
////            System.out.println(student.getName());
////        }
//
////        camera.takePhotoAndAnalyse(myClass);
//
//        Check check=new Check(myClass);
//
//
//
//        myClass.getName();
//
//
//
//
//    }
//}
