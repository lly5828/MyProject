package Camera.startCheck;

import Camera.Camera;
import Database.AttendanceRecordsDAO;
import Database.BaseDAO;
import basicClass.*;
import basicClass.LeaveInfo.LeaveRecord;

import java.sql.SQLException;

public class CheckRunnable implements Runnable {
    private boolean flag;
    private MyClass myClass;

    SchoolTime now;

    Camera camera = new Camera();

    public CheckRunnable(MyClass myClass) {
        this.myClass = myClass;
    }

    public void open() {
        flag = true;
    }

    public void close() {
        flag = false;
    }

    @Override
    public void run() {
        while (flag) {
            now = SchoolTime.getNowSchoolTime();
            if (now.ifRestTime()) {
                camera.takePhotoAndAnalyse(myClass, now);
            } else if (now.ifCourseTime()) {
                setLeave(now);
            }

        }
    }

    private void setLeave(SchoolTime schoolTime) {
        int courseNum = schoolTime.getCourseTime().getDayTimeNumber();
        for (Student student : myClass.getStudents()) {
            AttendanceRecord attendanceRecord = student.getAttendanceRecordByTime(schoolTime);
            if (attendanceRecord.getStatus() == Status.waiting) {
                boolean ifAsked = false;
                try {
                    AttendanceRecordsDAO attendanceRecordsDAO = new AttendanceRecordsDAO();

                    for (LeaveRecord leaveRecord : myClass.getLeaveRecordFactory().getLeaveRecord(student)) {
                        if (leaveRecord.ifDuring(schoolTime)) {
                            attendanceRecord.setStatus(Status.leave);
                            attendanceRecordsDAO.changeStatus(attendanceRecord,Status.leave);
                            ifAsked = true;
                            break;
                        }
                    }
                    if (!ifAsked) {
                        attendanceRecord.setStatus(Status.absent);
                        attendanceRecordsDAO.changeStatus(attendanceRecord,Status.absent);
                    }
                    BaseDAO.closeConnection(attendanceRecordsDAO.connection);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
