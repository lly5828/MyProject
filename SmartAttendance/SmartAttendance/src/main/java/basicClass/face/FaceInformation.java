package basicClass.face;

import com.arcsoft.face.FaceFeature;

public class FaceInformation {
    protected int id;
    protected String PhotoPath;



    FaceFeature faceFeature;

    public FaceInformation(FaceFeature faceFeature){
        this.faceFeature=faceFeature;
    }

    public FaceInformation() {
    }

    public FaceFeature getFaceFeature(){
        return faceFeature;
    }
    public FaceFeature getFaceFeatureBySQL(){
        FaceController faceController=new FaceController();
        this.faceFeature=faceController.addFace(getPhotoPath()).getFaceFeature();
        faceController.close();
        return faceFeature;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getPhotoPath() {
        return PhotoPath;
    }

    public void setPhotoPath(String photoPath) {
        PhotoPath = photoPath;
    }

    public FaceInformation(int foundId, String photoPath) {
        this.id=foundId;
        this.PhotoPath=photoPath;
//        FaceController faceController=new FaceController();
//        this.faceFeature=faceController.addFace(photoPath).getFaceFeature();
    }

    public void setFaceFeature(FaceFeature faceFeature) {
        this.faceFeature = faceFeature;
    }
}
