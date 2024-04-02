package basicClass;

import basicClass.face.FaceController;
import basicClass.face.FaceInformation;
import com.arcsoft.face.FaceEngine;
import com.arcsoft.face.toolkit.ImageInfo;

public class Person {

    protected int id;//身份证
    protected int faceInformationId;





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
//        FaceController faceController=new FaceController();
        this.faceInformation=new FaceInformation();
        faceInformation.setPhotoPath(filePath);
//        faceController.close();
    }

    public void setFaceInformation(ImageInfo imageInfo){
        FaceController faceController=new FaceController();
        this.faceInformation=faceController.addFace(imageInfo);
        faceController.close();
    }

//    获取人脸信息
    public FaceInformation getFaceInformation(){
        return faceInformation;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public boolean getSex() {
        return sex;
    }

    public int getId() {
        return id;
    }

    public int getFaceInformationId() {
        return faceInformationId;
    }

    public boolean isSex() {
        return sex;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setFaceInformation(FaceInformation faceInformation) {
        this.faceInformation = faceInformation;
    }
    public void setFaceInformationId(int faceInformationId) {
        this.faceInformationId = faceInformationId;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }
}
