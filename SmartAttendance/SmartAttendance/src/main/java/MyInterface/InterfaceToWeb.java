package MyInterface;

import Database.DatabaseManager;
import Database.LeaveRecordDAO;
import Database.LeaveRecordFactoryDao;
import Database.MyClassesDAO;
import MyInterface.info.AttendanceInfo;
import MyInterface.info.LeaveInfo;
import basicClass.*;
import basicClass.LeaveInfo.LeaveRecord;
import basicClass.LeaveInfo.LeaveRecordFactory;
import basicClass.LeaveInfo.LeaveResult;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class InterfaceToWeb {
    public static Student getStudent(String studentNum) {
        DatabaseManager databaseManager = new DatabaseManager();
        Student student = databaseManager.findStudentById(Integer.parseInt(studentNum));
        return student;
        //
//        return new Student("testStudent", "111", true, new MyClass("aaa"), studentNum);
        //
    }

    public static ArrayList getAttendanceRecord(Student student) {
        return student.getAttendanceRecords();
    }

    public static int applyLeave(Student student, SchoolTime schoolTime, String reason) {
        try {
            LeaveRecordFactoryDao leaveRecordFactoryDao = new LeaveRecordFactoryDao();
            LeaveRecordFactory leaveRecordFactory = student.getMyClassBySQL().getLeaveRecordFactory();
            leaveRecordFactoryDao.addLeaveRecord(leaveRecordFactory, schoolTime, reason, student, Teacher.newNullTeacher(student.getMyClassBySQL()));
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            return 1;
        }
        //
        return 0;
        //
    }

    public static Teacher getTeacher(String teacherNum) {
        Teacher teacher;
        //
//        teacher = new Teacher("testTeacher", "111", true, teacherNum);
//        MyClass myClass = new MyClass("xxx");
//        myClass.getLeaveRecordFactory().addLeaveRecord(new SchoolTime(14, 2, DayTime.morning1), "aaa", new Student("testStudent", "111", true, new MyClass("xxx"), "111"), new Teacher("testTeacher", "111", true, "111"));
//        myClass.getLeaveRecordFactory().addLeaveRecord(new SchoolTime(14, 3, DayTime.morning1), "aaa", new Student("testStudent2", "222", true, new MyClass("xxx"), "222"), new Teacher("testTeacher2", "222", true, "222"));
//        teacher.setTeachClass(myClass);
        //

        DatabaseManager databaseManager = new DatabaseManager();
        teacher = databaseManager.findTeacherById(Integer.parseInt(teacherNum));
        return teacher;
    }

    public static LeaveRecordFactory getLeaveRecord(Teacher teacher) throws SQLException {
        MyClass myClass = teacher.getTeachClassBySQL();
        LeaveRecordFactoryDao leaveRecordFactoryDao = null;
        try {
            leaveRecordFactoryDao = new LeaveRecordFactoryDao();
            return (LeaveRecordFactory) leaveRecordFactoryDao.findById(myClass.getLeaveRecordFactoryId());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        //
//        return new LeaveRecordFactory("aaa");
        //
    }

    public static LeaveRecordFactory getLeaveRecordFactory(MyClass myClass) {
        LeaveRecordFactoryDao leaveRecordFactoryDao = null;
        try {
            leaveRecordFactoryDao = new LeaveRecordFactoryDao();
            return (LeaveRecordFactory) leaveRecordFactoryDao.findById(myClass.getLeaveRecordFactoryId());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
//        return myClass.getLeaveRecordFactory();
    }

    public static ArrayList<LeaveInfo> factoryToLeaveInfo(LeaveRecordFactory leaveRecordFactory) {
        ArrayList<LeaveInfo> result = new ArrayList<>();
        ArrayList<LeaveInfo> dealed = new ArrayList<>();
        for (int i = 1; i <= leaveRecordFactory.getRecordCount(); i++) {
            if (leaveRecordFactory.getLeaveRecord(i).getLeaveResult() == LeaveResult.waiting) {
                try {
                    result.add(new LeaveInfo(leaveRecordFactory.getLeaveRecord(i)));
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            } else {
                try {
                    dealed.add(new LeaveInfo(leaveRecordFactory.getLeaveRecord(i)));
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        if (dealed.size() != 0)
            result.addAll(dealed);
        return result;
    }

    //    ifPass==true-->pass apply
    public static void dealLeaveRecord(Teacher teacher, int leaveRecordNum, boolean result) {

        MyClassesDAO myClassesDAO = null;
        MyClass myClass = null;
        try {
            myClassesDAO = new MyClassesDAO();
            myClass = (MyClass) myClassesDAO.findById(teacher.getTeachClassId());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        LeaveRecordFactory leaveRecordFactory = myClass.getLeaveRecordFactory();
        LeaveRecord leaveRecord = leaveRecordFactory.getLeaveRecord(leaveRecordNum);
        leaveRecord.setTeacher_deal(teacher);
        try {
            LeaveRecordDAO leaveRecordDAO = new LeaveRecordDAO();
            if (result) {
                leaveRecordDAO.changeResult(leaveRecordNum, LeaveResult.pass, teacher);
//                leaveRecord.setLeaveResult(LeaveResult.pass);
            } else {
                leaveRecordDAO.changeResult(leaveRecordNum, LeaveResult.fail, teacher);
//                leaveRecord.setLeaveResult(LeaveResult.fail);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    public static SchoolTime getDate(String dateStr, DayTime dayTime) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        GregorianCalendar g = new GregorianCalendar();
        try {
            g.setTime(dateFormat.parse(dateStr));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        int dayOfWeek = g.get(Calendar.DAY_OF_WEEK) == 1 ? 7 : g.get(Calendar.DAY_OF_WEEK) - 1;
        return new SchoolTime(g.get(Calendar.WEEK_OF_YEAR), dayOfWeek, dayTime);
    }

    public static String getDateBySchoolTime(SchoolTime schoolTime) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        GregorianCalendar g = getGreTimeBySchoolTime(schoolTime);
        return dateFormat.format(g.getTime());
    }

    public static GregorianCalendar getGreTimeBySchoolTime(SchoolTime schoolTime) {
        GregorianCalendar g = new GregorianCalendar();
        g.setWeekDate(2024, schoolTime.getWeek(), (schoolTime.getDayInWeek() == 7) ? 1 : schoolTime.getDayInWeek() + 1);
        return g;
    }

    public static ArrayList<AttendanceInfo> attendanceSituation(Student student) throws SQLException {
        ArrayList<AttendanceInfo> result = new ArrayList<>();
        ArrayList<AttendanceRecord> attendanceRecords = student.getAttendanceRecords();
        ArrayList<AttendanceRecord> thisMonthAR = new ArrayList<>();
//        SchoolTime now=SchoolTime.getNowSchoolTime();
        SchoolTime now = new SchoolTime(1, 1, DayTime.morning1);
        for (AttendanceRecord attendanceRecord : attendanceRecords) {
            if (getGreTimeBySchoolTime(attendanceRecord.getTime()).getTime().getMonth() == getGreTimeBySchoolTime(now).getTime().getMonth()) {
                thisMonthAR.add(attendanceRecord);
            }
        }


        for (AttendanceRecord attendanceRecord : thisMonthAR) {
            String dateStr = getDateBySchoolTime(attendanceRecord.getTime());
            boolean flag = false;
            for (AttendanceInfo attendanceInfo : result) {
                if (attendanceInfo.getDay().equals(dateStr)) {
                    flag = true;
                    attendanceInfo.add(attendanceRecord);
                    break;
                }
            }
            if(flag){
                continue;
            }else {
                MyClass myClass=student.getMyClassBySQL();
            boolean ifAsked = false;
            for (LeaveRecord leaveRecord : myClass.getLeaveRecordFactory().getLeaveRecord(student)) {
//                    if(leaveRecord.ifDuring(attendanceRecord.getTime())){
                if (leaveRecord.getStartTime().ifSameDay(attendanceRecord.getTime()) && leaveRecord.getLeaveResult() == LeaveResult.pass) {
                    ifAsked = true;
                    break;
                }
            }
            result.add(new AttendanceInfo(dateStr, ifAsked, attendanceRecord));
            }
        }


        //
//        student.addAttendanceRecord(SchoolTime.getNowSchoolTime(), new Course(1,"aaa"), Status.normal);
//        student.addAttendanceRecord(new SchoolTime(1, 1, DayTime.afternoon1), new Course(2,"bbb"), Status.normal);
//        result.add(new AttendanceInfo(getDateBySchoolTime(SchoolTime.getNowSchoolTime()), false, 8, 0));
//        result.add(new AttendanceInfo(getDateBySchoolTime(new SchoolTime(1, 1, DayTime.afternoon1)), true, 0, 0));
        //
        return result;
    }
}
