package Camera.startCheck;

import Camera.Camera;
import basicClass.MyClass;
import basicClass.SchoolTime;

public class CheckRunnable implements Runnable{
    private boolean flag;
    private MyClass myClass;

    SchoolTime now;

    Camera camera=new Camera();

    public CheckRunnable(MyClass myClass) {
        this.myClass = myClass;
    }

    public void open(){
        flag=true;
    }
    public void close(){
        flag=false;
    }
    @Override
    public void run() {
        while (flag){
            now=SchoolTime.getNowSchoolTime();
            if(now.ifRestTime()) {
                camera.takePhotoAndAnalyse(myClass,now);
            }

        }
    }
}
