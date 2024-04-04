package test;

import Database.*;
import Database.DatabaseConnectionManager;
import basicClass.*;
import basicClass.LeaveInfo.LeaveRecord;
import basicClass.LeaveInfo.LeaveRecordFactory;
import basicClass.LeaveInfo.LeaveResult;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestDao {
    public static void main(String[] args) throws SQLException {
        Student lly = new Student("lly", "123", true, "1");
        Student shl = new Student("shl", "123", true, "2");
        Student lhy = new Student("lhy", "123", true, "3");
        lly.setFaceInformation("/opt/myProject_another/photoes/peopleList/lly1.jpeg");
        shl.setFaceInformation("/opt/myProject_another/photoes/peopleList/shl2.jpeg");
        lhy.setFaceInformation("/opt/myProject_another/photoes/peopleList/lhy1.jpeg");

        MyClass myClass = new MyClass("testClass");
        myClass.setId(2201);


        Teacher teaM = new Teacher("teaM", "123", true, "1");
        Teacher teaC = new Teacher("teaC", "789", false, "2");

        ClassRoom classRoom = new ClassRoom();
        classRoom.setId(1);
        classRoom.setPlace("a1");

        Course math = new Course("math", myClass, teaM, classRoom);
        math.addCourseTime(new CourseTime(1, DayTime.morning1));
        math.addCourseTime(new CourseTime(3, DayTime.afternoon2));
        math.setId(1);
        Course computer = new Course("computer", myClass, teaC, classRoom);
        computer.addCourseTime(new CourseTime(1, DayTime.morning2));
        computer.addCourseTime(new CourseTime(2, DayTime.morning2));
        computer.setId(2);
        Course empty = new Course("empty", myClass, Teacher.newNullTeacher(myClass), classRoom);
        empty.addCourseTime(new CourseTime(0, DayTime.morning1));
        empty.setId(0);

        myClass.setCourse(math);
        myClass.setCourse(computer);
        myClass.setCourse(empty);
        myClass.initCourseTable();

        myClass.addStudent(lly);
        myClass.addStudent(shl);
        myClass.addStudent(lhy);

        clear();
        addWholeClass(myClass);


        DatabaseManager databaseManager=new DatabaseManager();

        MyClassesDAO myClassesDAO=new MyClassesDAO();
        MyClass my=(MyClass) myClassesDAO.findById(myClass.getId());
        Student llyGET=databaseManager.findStudentById(lly.getId());
        Teacher teaMGET=databaseManager.findTeacherById(teaM.getId());

        LeaveRecordFactoryDao leaveRecordFactoryDao=new LeaveRecordFactoryDao();
        leaveRecordFactoryDao.addLeaveRecord(my.getLeaveRecordFactory(),new SchoolTime(1,2,DayTime.morning1),"rex",llyGET.getId(),32767);

        AttendanceRecordsDAO attendanceRecordsDAO=new AttendanceRecordsDAO();
        attendanceRecordsDAO.changeStatus(llyGET.getAttendanceRecordByTime(new SchoolTime(1,1,DayTime.morning2)),Status.normal);
        attendanceRecordsDAO.changeStatus(llyGET.getAttendanceRecordByTime(new SchoolTime(1,1,DayTime.morning3)),Status.normal);


        LeaveRecordDAO leaveRecordDAO=new LeaveRecordDAO();
        leaveRecordDAO.changeResult((LeaveRecord) leaveRecordDAO.findById(1), LeaveResult.pass,teaMGET);

        System.out.println("x");
    }

    public static void addWholeClass(MyClass myClass) throws SQLException {
        DatabaseConnectionManager connectionManager = new DatabaseConnectionManager();
        DatabaseManager databaseManager = new DatabaseManager();
        CourseDAO courseDAO = new CourseDAO();
        MyClassesDAO myClassesDAO = new MyClassesDAO();
        myClassesDAO.insert(myClass);

        for (Student student : myClass.getStudents()) {
            databaseManager.addStudent(student);
        }
        for (Course course : myClass.getCourses()) {
            courseDAO.insert(course);
            databaseManager.addTeacher(course.getTeacher());
        }


    }

    public static void clear() throws SQLException {
        Connection connection = DatabaseConnectionManager.getConnection();
        String query = "delete from MyClass ";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.executeUpdate();
        query="delete from Student";
        statement= connection.prepareStatement(query);
        statement.executeUpdate();
        query="delete from Teacher";
        statement= connection.prepareStatement(query);
        statement.executeUpdate();
        query="delete from Course";
        statement= connection.prepareStatement(query);
        statement.executeUpdate();
        query="delete from FaceInformation";
        statement= connection.prepareStatement(query);
        statement.executeUpdate();
        query="delete from LeaveRecordFactory";
        statement= connection.prepareStatement(query);
        statement.executeUpdate();
        query="delete from LeaveRecord";
        statement= connection.prepareStatement(query);
        statement.executeUpdate();
        query="delete from SchoolTimeTable";
        statement= connection.prepareStatement(query);
        statement.executeUpdate();
        query="delete from CourseTime";
        statement= connection.prepareStatement(query);
        statement.executeUpdate();
        query="delete from AttendanceRecord";
        statement= connection.prepareStatement(query);
        statement.executeUpdate();
    }

}
