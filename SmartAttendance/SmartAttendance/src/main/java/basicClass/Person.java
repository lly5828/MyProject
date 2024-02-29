package basicClass;

import basicClass.face.FaceController;
import basicClass.face.FaceInformation;
import com.arcsoft.face.FaceEngine;

public class Person {
    protected String name;
    protected String phoneNumber;
    protected FaceInformation faceInformation;
    protected boolean sex;//false:woman ;true:man
    public Person(String name,String phoneNumber,boolean sex){
        this.name=name;
        this.phoneNumber=phoneNumber;
        this.sex=sex;
    }
    public Person(){
        this(null,null,true);
        System.out.println("no information insert!");
    }

    public String getName(){
        return name;
    }

//  输入照片路径设置人脸
    public void setFaceInformation(String filePath){
        FaceController faceController=new FaceController();
        this.faceInformation=faceController.addFace(filePath);
    }

//    获取人脸信息
    public FaceInformation getFaceInformation(){
        return faceInformation;
    }
}
