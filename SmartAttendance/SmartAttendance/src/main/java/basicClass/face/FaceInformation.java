package basicClass.face;

import com.arcsoft.face.FaceFeature;

public class FaceInformation {
    FaceFeature faceFeature;

    public FaceInformation(FaceFeature faceFeature){
        this.faceFeature=faceFeature;
    }

    public FaceFeature getFaceFeature(){
        return faceFeature;
    }
}
