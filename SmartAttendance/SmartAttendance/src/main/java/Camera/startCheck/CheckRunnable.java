package Camera.startCheck;

import Camera.Camera;
import Database.AttendanceRecordsDAO;
import Database.BaseDAO;
import Database.LeaveRecordFactoryDao;
import Database.MyClassesDAO;
import basicClass.*;
import basicClass.LeaveInfo.LeaveRecord;
import basicClass.LeaveInfo.LeaveRecordFactory;
import basicClass.LeaveInfo.LeaveResult;

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
//            boolean flagA=true;
            now = SchoolTime.getNowSchoolTime();
            if (now.ifRestTime()) {
                camera.takePhotoAndAnalyse(myClass, now);
//                flagA=false;
            } else if (now.ifCourseTime()) {
//                if(flagA==false){
                    setLeave(now);
//                    flagA=true;
//                }

            }

        }
    }

    private void setLeave(SchoolTime schoolTime) {
        int courseNum = schoolTime.getCourseTime().getDayTimeNumber();
        try {
            AttendanceRecordsDAO attendanceRecordsDAO = new AttendanceRecordsDAO();
            MyClassesDAO myClassesDAO=new MyClassesDAO();
            LeaveRecordFactoryDao leaveRecordFactoryDao=new LeaveRecordFactoryDao();
            int factoryId=myClassesDAO.getFactoryIdByClassId(myClass.getId());
            LeaveRecordFactory leaveRecordFactory=(LeaveRecordFactory) leaveRecordFactoryDao.findById(factoryId);
            for (Student student : myClass.getStudents()) {
                AttendanceRecord attendanceRecord = attendanceRecordsDAO.findByStuTime(student.getId(), schoolTime);
                if (attendanceRecord.getStatus() == Status.waiting) {
                    boolean ifAsked = false;
                    for (LeaveRecord leaveRecord : leaveRecordFactory.getLeaveRecord(student.getStudentNumber())) {
                        if (leaveRecord.ifDuring(schoolTime)&&leaveRecord.getLeaveResult()== LeaveResult.pass) {
                            attendanceRecord.setStatus(Status.leave);
                            attendanceRecordsDAO.changeStatus(attendanceRecord, Status.leave);
                            ifAsked = true;
                            break;
                        }
                    }
                    if (!ifAsked) {
                        attendanceRecord.setStatus(Status.absent);
                        attendanceRecordsDAO.changeStatus(attendanceRecord, Status.absent);
                    }


                }
            }
            BaseDAO.closeConnection(attendanceRecordsDAO.connection);
            BaseDAO.closeConnection(myClassesDAO.connection);
            BaseDAO.closeConnection(leaveRecordFactoryDao.connection);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


}
