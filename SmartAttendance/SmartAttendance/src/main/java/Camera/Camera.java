package Camera;


import Database.AttendanceRecordsDAO;
import Database.BaseDAO;
import basicClass.*;
import basicClass.face.FaceController;
import com.arcsoft.face.toolkit.ImageFactory;
import com.arcsoft.face.toolkit.ImageInfo;
import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamUtils;
import com.github.sarxos.webcam.util.ImageUtils;

import java.awt.image.BufferedImage;
import java.io.File;
import java.sql.SQLException;

public class Camera {
    FaceController faceController;
    Webcam webcam;

    public Camera() {
        this.faceController = new FaceController();
        webcam = Webcam.getDefault();
    }

    public void takePhotoAndAnalyse(MyClass myClass, SchoolTime schoolTime) {
        String fileName = getPhoto();
        analyse(myClass, schoolTime, myClass.getNextCourseByTime(schoolTime), fileName);
        deletePhoto(fileName);
    }

    private String getPhoto() {
        String fileName = "/opt/myProject/photoFromCamera/" + System.currentTimeMillis() + ".png";
        WebcamUtils.capture(webcam, fileName, ImageUtils.FORMAT_PNG);

        return fileName;
    }

    private void analyse(MyClass myClass, SchoolTime schoolTime, Course course, String fileName) {
        Student student = myClass.ifThisClassStudent(faceController.addFace(fileName));
        if (student != null) {
            try {
                AttendanceRecordsDAO attendanceRecordsDAO = new AttendanceRecordsDAO();
//                for (AttendanceRecord attendanceRecord : attendanceRecordsDAO.findByStudentId(student.getId())) {
//                    if (attendanceRecord.getTime().equals(schoolTime.getNextSchoolTime())) {
//                        System.out.println(attendanceRecord.getStatus());
                AttendanceRecord attendanceRecord = attendanceRecordsDAO.findByStuTime(student.getId(),schoolTime.getNextSchoolTime());
                if (attendanceRecord.getStatus() != Status.waiting) {
                    return;
                }
                attendanceRecordsDAO.changeStatus(attendanceRecord, Status.normal);
                BaseDAO.closeConnection(attendanceRecordsDAO.connection);
                System.out.println(student.getName() + Status.normal);
                schoolTime.getNextSchoolTime().showSchoolTime();
                System.out.println(schoolTime.getNextSchoolTime().getDayTime().dayTimeToNumber());

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void deletePhoto(String filePath){
        File file = new File(filePath);
        // 判断目录或文件是否存在
        if (!file.exists()) {  // 不存在返回 false
            return ;
        } else {
            // 判断是否为文件
            if (file.isFile()) {  // 为文件时调用删除文件方法
                // 路径为文件且不为空则进行删除
                if (file.isFile() && file.exists()) {
                    file.delete();
                }
            }
        }
    }


}


