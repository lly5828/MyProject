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
        MyClass myClass=initMyClass();
        myClass.showCourseTable();

        clear();
        addWholeClass(myClass);


        DatabaseManager databaseManager=new DatabaseManager();
//
//        MyClassesDAO myClassesDAO=new MyClassesDAO();
//        MyClass my=(MyClass) myClassesDAO.findById(myClass.getId());
        Student llyGET=databaseManager.findStudentById(1);
        Teacher teaMGET=databaseManager.findTeacherById(1);
//
//        LeaveRecordFactoryDao leaveRecordFactoryDao=new LeaveRecordFactoryDao();
//        leaveRecordFactoryDao.addLeaveRecord(my.getLeaveRecordFactory(),new SchoolTime(14,2,DayTime.morning1),"rex",llyGET.getId(),32767);

        AttendanceRecordsDAO attendanceRecordsDAO=new AttendanceRecordsDAO();
        attendanceRecordsDAO.changeStatus(llyGET.getAttendanceRecordByTime(new SchoolTime(14,1,DayTime.morning1)),Status.normal);
        attendanceRecordsDAO.changeStatus(llyGET.getAttendanceRecordByTime(new SchoolTime(14,1,DayTime.morning3)),Status.normal);


//        LeaveRecordDAO leaveRecordDAO=new LeaveRecordDAO();
//        leaveRecordDAO.changeResult((LeaveRecord) leaveRecordDAO.findById(1), LeaveResult.pass,teaMGET);
//
//        System.out.println("x");
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

    public static MyClass initMyClass(){
        Student lly = new Student("lly", "123", true, "1");
        Student shl = new Student("shl", "123", true, "2");
        Student lhy = new Student("lhy", "123", true, "3");
        lly.setFaceInformation("/opt/myProject_another/photoes/peopleList/lly1.jpeg");
        shl.setFaceInformation("/opt/myProject_another/photoes/peopleList/shl2.jpeg");
        lhy.setFaceInformation("/opt/myProject_another/photoes/peopleList/lhy1.jpeg");

        MyClass myClass = new MyClass("testClass");
        myClass.setId(2201);


        ClassRoom classRoom = new ClassRoom();
        classRoom.setId(1);
        classRoom.setPlace("a1");

        Teacher teaMath = new Teacher("teaM", "123", true, "1");
        Teacher teaChinese = new Teacher("teaC", "789", false, "2");
        Teacher teaEnglish = new Teacher("teaE", "789", false, "3");
        Teacher teaPhysical = new Teacher("teaPh", "789", true, "4");
        Teacher teaChemistry = new Teacher("teaChe", "789", false, "5");
        Teacher teaBiology = new Teacher("teaB", "789", false, "6");
        Teacher teaPolitics = new Teacher("teaP", "789", true, "7");
        Teacher teaGeography = new Teacher("teaG", "789", false, "8");
        Teacher teaHistory = new Teacher("teaH", "789", true, "9");
        Teacher teaJava = new Teacher("teaJ", "789", false, "10");
        Teacher teaPython = new Teacher("teaPy", "789", false, "11");


//数学，语文，英语，物理，化学，生物，政治，历史，地理
        Course math = new Course("数学", myClass, teaMath, classRoom);
        math.addCourseTime(new CourseTime(1, 3));
        math.addCourseTime(new CourseTime(2, 1));
        math.addCourseTime(new CourseTime(2, 2));
        math.addCourseTime(new CourseTime(3, 4));
        math.addCourseTime(new CourseTime(4, 2));
        math.addCourseTime(new CourseTime(5, 2));
        math.setId(1);
        Course chinese = new Course("语文", myClass, teaChinese, classRoom);
        chinese.addCourseTime(new CourseTime(1, 1));
        chinese.addCourseTime(new CourseTime(1, 2));
        chinese.addCourseTime(new CourseTime(2, 4));
        chinese.addCourseTime(new CourseTime(3, 3));
        chinese.addCourseTime(new CourseTime(4, 1));
        chinese.addCourseTime(new CourseTime(5, 1));
        chinese.setId(2);
        Course english = new Course("英语", myClass, teaEnglish, classRoom);
        english.addCourseTime(new CourseTime(1,4));
        english.addCourseTime(new CourseTime(2,3));
        english.addCourseTime(new CourseTime(3,1));
        english.addCourseTime(new CourseTime(3,2));
        english.addCourseTime(new CourseTime(4,3));
        english.addCourseTime(new CourseTime(5,3));
        english.setId(3);
        Course physical = new Course("物理", myClass, teaPhysical, classRoom);
        physical.addCourseTime(new CourseTime(1,5));
        physical.addCourseTime(new CourseTime(3,5));
        physical.addCourseTime(new CourseTime(3,6));
        physical.setId(4);
        Course chemistry = new Course("化学", myClass, teaChemistry, classRoom);
        chemistry.addCourseTime(new CourseTime(1,6));
        chemistry.addCourseTime(new CourseTime(3,7));
        chemistry.addCourseTime(new CourseTime(3,8));
        chemistry.setId(5);
        Course biology = new Course("生物", myClass, teaBiology, classRoom);
        biology.addCourseTime(new CourseTime(1,7));
        biology.addCourseTime(new CourseTime(4,5));
        biology.addCourseTime(new CourseTime(4,6));
        biology.setId(6);
        Course politics = new Course("政治", myClass, teaPolitics, classRoom);
        politics.addCourseTime(new CourseTime(2,5));
        politics.addCourseTime(new CourseTime(4,7));
        politics.addCourseTime(new CourseTime(4,8));
        politics.setId(7);
        Course history = new Course("历史", myClass, teaHistory, classRoom);
        history.addCourseTime(new CourseTime(2,6));
        history.addCourseTime(new CourseTime(5,5));
        history.addCourseTime(new CourseTime(5,6));
        history.setId(8);
        Course geography = new Course("地理", myClass, teaGeography, classRoom);
        geography.addCourseTime(new CourseTime(2,7));
        geography.addCourseTime(new CourseTime(5,7));
        geography.addCourseTime(new CourseTime(5,8));
        geography.setId(9);
        Course java = new Course("Java", myClass, teaJava, classRoom);
        java.addCourseTime(new CourseTime(1,8));
        java.addCourseTime(new CourseTime(4,4));
        java.setId(10);
        Course python = new Course("Python", myClass, teaPython, classRoom);
        python.addCourseTime(new CourseTime(2,8));
        python.addCourseTime(new CourseTime(5,4));
        python.setId(11);

        Course empty = new Course("empty", myClass, Teacher.newNullTeacher(myClass), classRoom);
        empty.addCourseTime(new CourseTime(0, DayTime.morning1));
        empty.setId(0);

        myClass.setCourse(math);
        myClass.setCourse(chinese);
        myClass.setCourse(english);
        myClass.setCourse(physical);
        myClass.setCourse(chemistry);
        myClass.setCourse(biology);
        myClass.setCourse(politics);
        myClass.setCourse(history);
        myClass.setCourse(geography);
        myClass.setCourse(java);
        myClass.setCourse(python);
        myClass.setCourse(empty);
        myClass.initCourseTable();

        myClass.addStudent(lly);
        myClass.addStudent(shl);
        myClass.addStudent(lhy);

        return myClass;
    }

}
