package Camera.startCheck;

import Camera.Camera;
import basicClass.*;
import basicClass.LeaveInfo.LeaveRecord;

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
            } else if (now.ifCourseTime()) {
                setLeave(now);
            }

        }
    }

    private void setLeave(SchoolTime schoolTime){
        int courseNum=schoolTime.getCourseTime().getDayTimeNumber();
        for(Student student:myClass.getStudents()){
            if(student.getAttendanceRecordByTime(schoolTime).getStatus()== Status.waiting){
                boolean ifAsked=false;
                for (LeaveRecord leaveRecord:myClass.getLeaveRecordFactory().getLeaveRecord(student)){
                    if(leaveRecord.ifDuring(schoolTime)){
                        student.getAttendanceRecordByTime(schoolTime).setStatus(Status.leave);
                        ifAsked=true;
                        break;
                    }
                }
                if(!ifAsked){
                    student.getAttendanceRecordByTime(schoolTime).setStatus(Status.absent);
                }
            }
        }
    }
}
