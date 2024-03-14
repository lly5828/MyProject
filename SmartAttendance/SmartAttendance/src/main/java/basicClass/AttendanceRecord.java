package basicClass;

public class AttendanceRecord {

    public SchoolTime getTime() {
        return time;
    }

    protected SchoolTime time;
    protected String courseName;
    protected Status status;

    public AttendanceRecord(SchoolTime time, String courseName, Status status) {
        this.time = time;
        this.courseName = courseName;
        this.status = status;
    }

    public void showAttendanceRecord() {
        System.out.print("Time:");
        time.showSchoolTime();
        System.out.println("\tCourse:" + courseName + "\tStatue" + status);
    }

}
