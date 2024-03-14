package basicClass.face;
import com.arcsoft.face.*;
import com.arcsoft.face.enums.DetectMode;
import com.arcsoft.face.enums.DetectOrient;
import com.arcsoft.face.enums.ErrorInfo;
import com.arcsoft.face.enums.ImageFormat;
import com.arcsoft.face.toolkit.ImageFactory;
import com.arcsoft.face.toolkit.ImageInfo;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FaceController {

    FaceInformation faceInformation;

    FaceEngine faceEngine;

    int errorCode;

    ActiveFileInfo activeFileInfo;

    private static final float SAME_RATE=0.7F;

    public FaceController() {
        String appId = "5JU3BrWkw7PCYKMAyB3F1ZC5Ba1qRkPW9wejrW1vBt2z";
        String sdkKey = "6mS9DQM2QmNWjokWmFQE2iwYj86u7ub2SF1SC4f9zcuA";
        this.faceEngine = new FaceEngine("/opt/myProject/ArcSoft_ArcFace_Java_Linux_x64_V3.0/libs/LINUX64");

        errorCode = faceEngine.activeOnline(appId, sdkKey);

        if (errorCode != ErrorInfo.MOK.getValue() && errorCode != ErrorInfo.MERR_ASF_ALREADY_ACTIVATED.getValue()) {
            System.out.println("引擎激活失败");
        }


        activeFileInfo = new ActiveFileInfo();
        errorCode = faceEngine.getActiveFileInfo(activeFileInfo);
        if (errorCode != ErrorInfo.MOK.getValue() && errorCode != ErrorInfo.MERR_ASF_ALREADY_ACTIVATED.getValue()) {
            System.out.println("获取激活文件信息失败");
        }


        //引擎配置
        EngineConfiguration engineConfiguration = new EngineConfiguration();
        engineConfiguration.setDetectMode(DetectMode.ASF_DETECT_MODE_IMAGE);
        engineConfiguration.setDetectFaceOrientPriority(DetectOrient.ASF_OP_ALL_OUT);
        engineConfiguration.setDetectFaceMaxNum(10);
        engineConfiguration.setDetectFaceScaleVal(16);
        //功能配置
        FunctionConfiguration functionConfiguration = new FunctionConfiguration();
        functionConfiguration.setSupportAge(true);
        functionConfiguration.setSupportFace3dAngle(true);
        functionConfiguration.setSupportFaceDetect(true);
        functionConfiguration.setSupportFaceRecognition(true);
        functionConfiguration.setSupportGender(true);
        functionConfiguration.setSupportLiveness(true);
        functionConfiguration.setSupportIRLiveness(true);
        engineConfiguration.setFunctionConfiguration(functionConfiguration);

        //初始化引擎
        errorCode = faceEngine.init(engineConfiguration);

        if (errorCode != ErrorInfo.MOK.getValue()) {
            System.out.println("初始化引擎失败");
        }
    }

    public void close(){
        faceEngine.unInit();
    }

    public FaceInformation addFace(String filePath){
        ImageInfo imageInfo= ImageFactory.getRGBData(new File(filePath));
        List<FaceInfo> faceInfoList=new ArrayList<>();
        errorCode = faceEngine.detectFaces(imageInfo.getImageData(), imageInfo.getWidth(), imageInfo.getHeight(), imageInfo.getImageFormat(), faceInfoList);

        if(faceInfoList.isEmpty())return null;
        //特征提取
        FaceFeature faceFeature = new FaceFeature();
        errorCode = faceEngine.extractFaceFeature(imageInfo.getImageData(), imageInfo.getWidth(), imageInfo.getHeight(), imageInfo.getImageFormat(), faceInfoList.get(0), faceFeature);

        return new FaceInformation(faceFeature);
    }

    public FaceInformation addFace(ImageInfo imageInfo){
        List<FaceInfo> faceInfoList=new ArrayList<>();
        errorCode = faceEngine.detectFaces(imageInfo.getImageData(), imageInfo.getWidth(), imageInfo.getHeight(), imageInfo.getImageFormat(), faceInfoList);

        if(faceInfoList.isEmpty())return null;
        //特征提取
        FaceFeature faceFeature = new FaceFeature();
        errorCode = faceEngine.extractFaceFeature(imageInfo.getImageData(), imageInfo.getWidth(), imageInfo.getHeight(), imageInfo.getImageFormat(), faceInfoList.get(0), faceFeature);

        return new FaceInformation(faceFeature);
    }

    public boolean ifSamePeople(FaceInformation faceInformation1,FaceInformation faceInformation2){
        FaceSimilar faceSimilar=new FaceSimilar();
        errorCode=faceEngine.compareFaceFeature(faceInformation1.getFaceFeature(),faceInformation2.faceFeature,faceSimilar);

//        System.out.println(faceSimilar.getScore());
        if(faceSimilar.getScore()>SAME_RATE){
            return true;
        }else {
            return false;
        }
    }
}
