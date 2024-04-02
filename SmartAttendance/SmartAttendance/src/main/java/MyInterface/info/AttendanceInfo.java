package MyInterface.info;

import basicClass.AttendanceRecord;
import basicClass.Status;

public class AttendanceInfo {
    String day;
    boolean ifAskForLeave;//true:asked   false:not asked
    int normal;
    int leave;

    public AttendanceInfo(String day, boolean ifAskForLeave) {
        this(day,ifAskForLeave,0,0);
    }
    public AttendanceInfo(String day, boolean ifAskForLeave,int normal,int leave) {
        this.day = day;
        this.ifAskForLeave = ifAskForLeave;
        this.normal = normal;
        this.leave = leave;
    }

    public AttendanceInfo(String day,boolean ifAskForLeave,AttendanceRecord attendanceRecord) {
        this(day,ifAskForLeave,0,0);
        this.add(attendanceRecord);
    }

    public void add(AttendanceRecord attendanceRecord){
//        if(this.ifAskForLeave){
//            this.leave=0;
//            this.normal=0;
//            return;
//        }else {
            if(attendanceRecord.getStatus()==Status.normal){
                normal++;
            } else if (attendanceRecord.getStatus()==Status.absent) {
                leave++;
            }
//        }
    }

    public void setIfAskForLeave(boolean ifAskForLeave) {
        this.ifAskForLeave = ifAskForLeave;
    }

    public String getDay() {
        return day;
    }

    public boolean isIfAskForLeave() {
        return ifAskForLeave;
    }

    public int getNormal() {
        return normal;
    }

    public int getLeave() {
        return leave;
    }
}
