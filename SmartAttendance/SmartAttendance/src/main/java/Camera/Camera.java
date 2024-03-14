package Camera;


import basicClass.*;
import basicClass.face.FaceController;
import com.arcsoft.face.toolkit.ImageFactory;
import com.arcsoft.face.toolkit.ImageInfo;
import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamUtils;
import com.github.sarxos.webcam.util.ImageUtils;

import java.awt.image.BufferedImage;

public class Camera {
    FaceController faceController;
    Webcam webcam;
    public Camera() {
        this.faceController = new FaceController();
        webcam=Webcam.getDefault();
    }
    public  void takePhotoAndAnalyse(MyClass myClass,SchoolTime schoolTime){
                String fileName=getPhoto();
                analyse(myClass,schoolTime,myClass.getNextCourseByTime(schoolTime).getName(),fileName);
    }
    private String getPhoto(){
        String fileName = "/opt/myProject/photoFromCamera/" + System.currentTimeMillis()+".png";
        WebcamUtils.capture(webcam, fileName, ImageUtils.FORMAT_PNG);

        return fileName;
    }

    private void analyse(MyClass myClass, SchoolTime schoolTime, String courseName,String fileName){
        Student student=myClass.ifThisClassStudent(faceController.addFace(fileName));
        if(student!=null){
            for(AttendanceRecord attendanceRecord:student.getAttendanceRecords()){
                if(attendanceRecord.getTime().equals(schoolTime))return;
            }

            student.addAttendanceRecord(schoolTime,courseName,Status.normal);
            System.out.println(student.getName()+schoolTime+courseName+Status.normal);
        }
    }

//    public void run(){
//        boolean flag=true;
//        while (flag) {
//            SchoolTime now = SchoolTime.getNowSchoolTime();
//
//
//        }
//    }
}


