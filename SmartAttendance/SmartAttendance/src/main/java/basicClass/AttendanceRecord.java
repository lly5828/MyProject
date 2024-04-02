package basicClass;

public class AttendanceRecord {
    protected int id;
    protected int  courseId;
    protected int studentId;
//    protected int schoolTimeId;



    protected SchoolTime time;
    protected String courseName;
    protected Status status;

    public AttendanceRecord(SchoolTime time, String courseName,int courseId, Status status,int studentId) {
        this.time = time;
        this.courseName = courseName;
        this.status = status;
        this.studentId=studentId;
        this.courseId=courseId;
    }

    public AttendanceRecord() {
    }

    public void showAttendanceRecord() {
        System.out.print("Time:");
        time.showSchoolTime();
        System.out.println("\tCourse:" + courseName + "\tStatue" + status);
    }

    public String getCourseName() {
        return courseName;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public SchoolTime getTime() {
        return time;
    }

    public int getId() {
        return id;
    }

    public int getCourseId() {
        return courseId;
    }

    public int getStudentId() {
        return studentId;
    }

//    public int getSchoolTimeId() {
//        return schoolTimeId;
//    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

//    public void setSchoolTimeId(int schoolTimeId) {
//        this.schoolTimeId = schoolTimeId;
//    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setTime(SchoolTime time) {
        this.time = time;
    }
}
