package MyInterface.info;

public class AttendanceInfo {
    String day;
    boolean ifAskForLeave;//true:asked   false:not asked
    int normal;
    int leave;

    public AttendanceInfo(String day, boolean ifAskForLeave, int normal, int leave) {
        this.day = day;
        this.ifAskForLeave = ifAskForLeave;
        this.normal = normal;
        this.leave = leave;
    }
}
