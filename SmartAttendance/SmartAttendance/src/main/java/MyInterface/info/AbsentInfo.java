package MyInterface.info;

import Database.BaseDAO;
import Database.CourseDAO;
import Database.DatabaseManager;
import Database.MyClassesDAO;
import MyInterface.InterfaceToWeb;
import basicClass.AttendanceRecord;
import basicClass.SchoolTime;

import java.sql.SQLException;
import java.util.ArrayList;

public class AbsentInfo {
    String time;
    ArrayList<AbsentRecord> absentRecords;

    public AbsentInfo(SchoolTime schoolTime) {
        this.time = InterfaceToWeb.getDateBySchoolTime(schoolTime);
        this.absentRecords=new ArrayList<>();
    }
    public void add(AbsentRecord absentRecord){
        this.absentRecords.add(absentRecord);
    }
    public void add(int number, AttendanceRecord attendanceRecord) throws SQLException {
        this.absentRecords.add(new AbsentRecord(number, attendanceRecord));
    }
}
class AbsentRecord{
    int number;
    String name;
    String stuClass;
    int stuNum;
    String course;
    String courseTime;

    public AbsentRecord(int number, AttendanceRecord attendanceRecord) throws SQLException {
        DatabaseManager databaseManager=new DatabaseManager();
        MyClassesDAO myClassesDAO=new MyClassesDAO();
        CourseDAO courseDAO=new CourseDAO();
        this.number = number;
        this.stuNum = attendanceRecord.getStudentId();
        name=databaseManager.getStudentNameByStuId(stuNum);
        int classId=databaseManager.getStudentClassIdByStuId(stuNum);
        stuClass= myClassesDAO.getClassNameByClassId(classId);
        course=courseDAO.getCourseNameById(attendanceRecord.getCourseId());
        courseTime=attendanceRecord.getTime().getDayTime().toString();
        BaseDAO.closeConnection(databaseManager.conn);
        BaseDAO.closeConnection(myClassesDAO.connection);
        BaseDAO.closeConnection(courseDAO.connection);
    }
}
