package Database;

import basicClass.*;
import basicClass.LeaveInfo.LeaveRecord;
import basicClass.LeaveInfo.LeaveRecordFactory;
import basicClass.LeaveInfo.LeaveResult;
import basicClass.face.FaceInformation;
import basicClass.Person;

import java.sql.*;
import java.util.ArrayList;

import basicClass.Person;
import basicClass.face.FaceInformation;
import com.arcsoft.face.FaceFeature;

import java.security.PermissionCollection;
import java.sql.*;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseManager {
    public Connection conn;
    private static final Logger LOGGER = Logger.getLogger(DatabaseManager.class.getName());

    // 连接数据库
    public DatabaseManager() {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/smart_attendance?useSSL=false", "test", "123456");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 关闭数据库连接
    public void closeConnection() {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    // 添加学生
    public void addStudent(Student student) {
        try {
            String query = "INSERT INTO Student (id, myClassId, studentNumber, status,name,phoneNumber,sex,faceInformationId) VALUES (?, ?, ?, ?,?,?,?,?)";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, student.getId());
            preparedStatement.setInt(2, student.getMyClass().getId());
            preparedStatement.setString(3, student.getStudentNumber());
            preparedStatement.setString(4, student.getStatus().toString());
            preparedStatement.setString(5, student.getName());
            preparedStatement.setString(6, student.getPhoneNumber());
            preparedStatement.setInt(7, (student.getSex()) ? 1 : 0);
            FaceInformationDAO faceInformationDAO = new FaceInformationDAO();
            faceInformationDAO.insert(student.getFaceInformation());
            preparedStatement.setInt(8, student.getFaceInformation().getId());
            AttendanceRecordsDAO attendanceRecordsDAO = new AttendanceRecordsDAO();
            for (AttendanceRecord attendanceRecord : student.getAttendanceRecords()) {
                attendanceRecordsDAO.insert(attendanceRecord);
            }


            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 删除学生
//    public void deleteStudent(int studentId) {
//        try {
//            String query = "DELETE FROM Student WHERE id = ?";
//            PreparedStatement preparedStatement = conn.prepareStatement(query);
//            preparedStatement.setInt(1, studentId);
//            preparedStatement.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }

    // 更新学生信息
//    public void updateStudent(Student student) {
//        try {
//            String query = "UPDATE Student SET myClassId = ?, studentNumber = ?, status = ? WHERE id = ?";
//            PreparedStatement preparedStatement = conn.prepareStatement(query);
//            preparedStatement.setInt(1, student.getMyClass().getId());
//            preparedStatement.setString(2, student.getStudentNumber());
//            preparedStatement.setString(3, student.getStatus().toString());
//            preparedStatement.setInt(4, student.getId());
//            preparedStatement.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }

    // 根据学生ID查找学生
    public Student findStudentById(int studentId) {
        try {
            String query = "SELECT * FROM Student WHERE id = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, studentId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                // 构造学生对象并返回
                // 注意：这里需要根据需要构造 MyClass 和 Status 对象
                Student student = new Student();
                student.setId(resultSet.getInt("id"));
                student.setName(resultSet.getString("name"));
                student.setStudentNumber(resultSet.getString("studentNumber"));
                student.setPhoneNumber(resultSet.getString("phoneNumber"));
                student.setSex((resultSet.getInt("sex") == 1) ? true : false);
                // 设置其他属性...
                int faceInformationId = resultSet.getInt("faceInformationId");
                FaceInformationDAO faceInformationDAO=new FaceInformationDAO();
                FaceInformation faceInformation1 = faceInformationDAO.findById(faceInformationId);
                student.setFaceInformation(faceInformation1.getPhotoPath());
                BaseDAO.closeConnection(faceInformationDAO.connection);

                AttendanceRecordsDAO attendanceRecordsDAO = new AttendanceRecordsDAO();
                student.setAttendanceRecords(attendanceRecordsDAO.findByStudentId(studentId));
                BaseDAO.closeConnection(attendanceRecordsDAO.connection);
                // 构造 MyClass 对象
                int myClassId = resultSet.getInt("myClassId");
                student.setMyClassId(myClassId);
                student.setStatus(Status.normal);

                return student;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<Student> findStudentsByMyClassId(int myClassId) {
        ArrayList<Student> studentArrayList = new ArrayList<>();
        try {
            String query = "SELECT * FROM Student WHERE MyClassId = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, myClassId);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Student student = findStudentById(resultSet.getInt("id"));
                studentArrayList.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return studentArrayList;
    }

    public Student getStudentInfoByStuId(int studentId) {
        try {
            String query = "SELECT * FROM Student WHERE id = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, studentId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Student student = new Student();
                student.setId(resultSet.getInt("id"));
                student.setName(resultSet.getString("name"));
                student.setStudentNumber(resultSet.getString("studentNumber"));
                student.setPhoneNumber(resultSet.getString("phoneNumber"));
                student.setSex((resultSet.getInt("sex") == 1) ? true : false);
                // 设置其他属性...
                int faceInformationId = resultSet.getInt("faceInformationId");
                FaceInformationDAO faceInformationDAO=new FaceInformationDAO();
                FaceInformation faceInformation1 = faceInformationDAO.findById(faceInformationId);
                student.setFaceInformation(faceInformation1.getPhotoPath());
                BaseDAO.closeConnection(faceInformationDAO.connection);

//                AttendanceRecordsDAO attendanceRecordsDAO = new AttendanceRecordsDAO();
//                student.setAttendanceRecords(attendanceRecordsDAO.findByStudentId(studentId));
//                BaseDAO.closeConnection(attendanceRecordsDAO.connection);
                // 构造 MyClass 对象
                int myClassId = resultSet.getInt("myClassId");
                student.setMyClassId(myClassId);
                student.setStatus(Status.normal);

                return student;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public int getStudentClassIdByStuId(int studentId) {
        try {
            String query = "SELECT * FROM Student WHERE id = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, studentId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt("myClassId");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    public String getStudentNameByStuId(int studentId){
        try {
            String query = "SELECT * FROM Student WHERE id = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, studentId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getString("name");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "null";
    }


    // 添加老师
    public void addTeacher(Teacher teacher) {
        try {
            String query = "INSERT INTO Teacher (id, teachClassId, teachCourseId, teacherNumber,name,phoneNumber,sex) VALUES (?, ?, ?, ?,?,?,?)";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, teacher.getId());
            preparedStatement.setInt(2, teacher.getTeachClass().getId());
            preparedStatement.setInt(3, teacher.getTeachCourse().getId());
            preparedStatement.setString(4, teacher.getTeacherNumber());
            preparedStatement.setString(5, teacher.getName());
            preparedStatement.setString(6, teacher.getPhoneNumber());
            preparedStatement.setInt(7, (teacher.getSex()) ? 1 : 0);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addTeacherWithoutCourse(Teacher teacher) {
        try {
            String query = "INSERT INTO Teacher (id, teachClassId, teacherNumber) VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, teacher.getId());
            preparedStatement.setInt(2, teacher.getTeachClass().getId());
            preparedStatement.setString(3, teacher.getTeacherNumber());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 删除老师
    public void deleteTeacher(int teacherId) {
        try {
            String query = "DELETE FROM Teacher WHERE id = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, teacherId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 更新老师信息
    public void updateTeacher(Teacher teacher) {
        try {
            String query = "UPDATE Teacher SET teachClassId = ?, teachCourseId = ?, teacherNumber = ? WHERE id = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, teacher.getTeachClass().getId());
            preparedStatement.setInt(2, teacher.getTeachCourse().getId());
            preparedStatement.setString(3, teacher.getTeacherNumber());
            preparedStatement.setInt(4, teacher.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 根据老师ID查找老师
    public Teacher findTeacherById(int teacherId) {
        try {
            String query = "SELECT * FROM Teacher WHERE id = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, teacherId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Teacher teacher = new Teacher();
                teacher.setId(resultSet.getInt("id"));
                teacher.setName(resultSet.getString("name"));
                teacher.setPhoneNumber(resultSet.getString("phoneNumber"));
                teacher.setSex((resultSet.getInt("sex") == 1) ? true : false);
                teacher.setTeacherNumber(resultSet.getString("teacherNumber"));

                teacher.setTeachClassId(resultSet.getInt("teachClassId"));
                return teacher;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public int getTeacherClassIdByTeaId(int teacherId) {
        try {
            String query = "SELECT * FROM Teacher WHERE id = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, teacherId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt("teachClassId");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

//}
//    查找类
    public Person findPersonById(int id) {
//        String SQL = "SELECT * FROM Person WHERE id = ?";
//        Person person = null;
//
//        try (Connection conn = connect();
//             PreparedStatement pstmt = conn.prepareStatement(SQL)) {
//
//            pstmt.setInt(1, id);
//            ResultSet rs = pstmt.executeQuery();
        Person person = null;
        try {
            String query = "SELECT * FROM Teacher Person id = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                person = new Person();
                person.setId(rs.getInt("id"));
                person.setName(rs.getString("name"));
                person.setFaceInformationId(rs.getInt("faceInformationId"));
                person.setPhoneNumber(rs.getString("phoneNumber"));
                person.setSex(rs.getBoolean("sex"));
                // 假设你有一个函数来填充faceInformation对象
                person.setFaceInformation(findFaceInformationById(person.getFaceInformationId()));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return person;
    }

    public FaceInformation findFaceInformationById(int id) {
//        String SQL = "SELECT * FROM FaceInformation WHERE id = ?";
        FaceInformation faceInformation = null;
        try {
            String query = "SELECT * FROM FaceInformation WHERE id = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                faceInformation = new FaceInformation();
                faceInformation.setId(rs.getInt("id"));
                faceInformation.setPhotoPath(rs.getString("PhotoPath"));
            }
        } catch (SQLException ex) {
//            System.out.println(ex.getMessage());
        }
        return faceInformation;
    }

    public MyClass findMyClassById(int myClassId) {
        MyClass myClass = new MyClass();
        ArrayList<Student> students = new ArrayList<>();
        ArrayList<Course> courses = new ArrayList<>();

        String query = "SELECT * FROM MyClass " +
                "LEFT JOIN Student ON MyClass.studentId = Student.id " +
                "LEFT JOIN Course ON MyClass.courseId = Course.id " +
                "WHERE MyClass.id = ?";

        try (
                PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setInt(1, myClassId);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                if (rs.getInt("studentId") != 0 && !students.contains(new Student(rs.getInt("studentId")))) {
                    students.add(findStudentById(rs.getInt("studentId")));
                }
                if (rs.getInt("courseId") != 0 && !courses.contains(new Course(rs.getInt("courseId")))) {
                    courses.add(findCourseId(rs.getInt("courseId")));
                }
                if (rs.isFirst()) {
                    myClass.setId(rs.getInt("id"));
                    myClass.setName(rs.getString("name"));
                }
            }
            myClass.setStudents(students);
            myClass.setCourses(courses);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return myClass;
    }

    public static Status getStatusFromDatabase(ResultSet rs, String columnName) throws SQLException {
        String statusStr = rs.getString(columnName);
        return Status.valueOf(statusStr);
    }

    private Status findStatusById(int statusId) {
        Status status = null;
        try (
                Statement statement = conn.createStatement();
                ResultSet rs = statement.executeQuery("SELECT * FROM students")) {

            while (rs.next()) {
                String name = rs.getString("name");
                // 使用getStatusFromDatabase方法获取枚举值
                status = getStatusFromDatabase(rs, "status");

                System.out.println("Name: " + name + ", Status: " + status);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public SchoolTime findSchoolTimeId(int schoolTimeId) {
        SchoolTime schoolTime = null;

        String query = "SELECT * FROM SchoolTime " +
                "LEFT JOIN CourseTime ON SchoolTime.courseTimeId = CourseTime.id " +
                "WHERE SchoolTime.id = ?";

        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, schoolTimeId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                schoolTime = new SchoolTime();
                schoolTime.setId(rs.getInt("id"));
                schoolTime.setWeek(rs.getInt("week"));
                schoolTime.setTimeInMillis(rs.getLong("timeInMillis"));

                // 假设CourseTime有一个能接受ResultSet并从中加载数据的构造函数
//                schoolTime.setCourseTime(new CourseTime(rs));/////////////////////////////////////////////////
                schoolTime.setCourseTime(findCourseTimeId(rs.getInt("courseTimeId")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return schoolTime;
    }

    public CourseTime findCourseTimeId(int courseTimeId) {
        CourseTime courseTime = null;
        String query = "SELECT * FROM CourseTime WHERE id = ?";
        try (
                PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, courseTimeId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                courseTime = new CourseTime();
                courseTime.setId(rs.getInt("id"));
                courseTime.setDayInWeek(rs.getInt("dayInWeek"));
                // 将数据库中的ENUM映射到Java中的DayTime枚举类型
                String dayTimeStr = rs.getString("dayTime");
                DayTime dayTime = DayTime.valueOf(dayTimeStr.toUpperCase());
                courseTime.setDayTime(dayTime);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return courseTime;
    }



    private PersonStatus findPersonStatusId(int id) {
        return null;
    }

    private DayTime findDayTime(String value) {
        DayTime dayTime = null;

        // 枚举类型在数据库中存储的是字符串，因此直接根据字符串进行查询
        String query = "SELECT * FROM DayTime WHERE value = ?";

        try (
                PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setString(1, value);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                // 假设DayTime枚举类型有一个静态方法可以根据字符串值获取枚举实例
                dayTime = DayTime.valueOf(rs.getString("value").toUpperCase());
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return dayTime;
    }

    private Course findCourseId(int courseId) {

        Course course = null;

        String query = "SELECT id, name, myClassId, teacherId, classRoomId FROM Course WHERE id = ?";

        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, courseId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                course = buildCourseFromResultSet(rs);
            }

        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error fetching course by ID", e);
        }

        return Optional.ofNullable(course).orElse(new Course());
    }

    private Course buildCourseFromResultSet(ResultSet rs) throws SQLException {
        Course course = new Course();
        course.setId(rs.getInt("id"));
        course.setName(rs.getString("name"));

        int myClassId = rs.getInt("myClassId");
        MyClass myClass = findMyClassById(myClassId); // 假设这个方法已经实现
        course.setMyClass(myClass);

        int teacherId = rs.getInt("teacherId");
        Teacher teacher = findTeacherById(teacherId); // 假设这个方法已经实现
        course.setTeacher(teacher);

        int classRoomId = rs.getInt("classRoomId");
        ClassRoom classRoom = findClassRoomId(classRoomId); // 假设这个方法已经实现
        course.setClassRoom(classRoom);

        return course;
    }


    private ClassRoom findClassRoomId(int classRoomId) {
        ClassRoom classRoom = null;

        String query = "SELECT * FROM ClassRoom WHERE id = ?";

        try (
                PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setInt(1, classRoomId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                classRoom = new ClassRoom();
                classRoom.setId(rs.getInt("id"));
                classRoom.setPlace(rs.getString("place"));

                // 获取该教室对应的所有课程
                Course[] courses = getCoursesForClassRoom(classRoom.getId());
                classRoom.setCourses(courses);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return classRoom;
    }

//     获取该教室对应的所有课程
    private Course[] getCoursesForClassRoom(int classRoomId) {
        Course[] courses = null;

        String query = "SELECT * FROM Course WHERE classRoomId = ?";

        try (
                PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setInt(1, classRoomId);

            ResultSet rs = ps.executeQuery();

            ArrayList<Course> courseList = new ArrayList<>();
            while (rs.next()) {
                Course course = new Course();
                course.setId(rs.getInt("id"));
                course.setName(rs.getString("name"));

                // 其他属性也可以在这里设置
                courseList.add(course);
            }

            courses = courseList.toArray(new Course[0]);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return courses;
    }

    public AttendanceRecord getAttendanceRecordById(int attendanceRecordId) {
        AttendanceRecord attendanceRecord = null;

        String query = "SELECT * FROM AttendanceRecord WHERE id = ?";

        try (
                PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setInt(1, attendanceRecordId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                attendanceRecord = new AttendanceRecord();
                attendanceRecord.setId(rs.getInt("id"));
                attendanceRecord.setCourseName(rs.getString("courseName"));
                attendanceRecord.setStatus(Status.valueOf(rs.getString("status")));

                // 获取时间信息
                SchoolTime time = getTimeForAttendanceRecord(rs.getInt("timeId"));
                attendanceRecord.setTime(time);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return attendanceRecord;
    }

//     获取时间信息
    private SchoolTime getTimeForAttendanceRecord(int timeId) {
        SchoolTime time = null;

        String query = "SELECT * FROM SchoolTimeTable WHERE id = ?";

        try (
                PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setInt(1, timeId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                time = new SchoolTime();
                time.setId(rs.getInt("id"));
                time.setTimeInMillis(rs.getLong("timeInMillis"));

                // 其他时间属性也可以在这里设置
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return time;
    }

    private LeaveResult findLeaveResultId(int id) {
        return null;
    }

    private LeaveRecordFactory findLeaveRecordFactoryId(int id) {
        return null;
    }


// 假设存在一个全局的 HikariDataSource 实例
// private static HikariDataSource dataSource;

    private LeaveRecord findLeaveRecordId(int leaveRecordNum) {
        LeaveRecord leaveRecord = null;

        try (
                PreparedStatement statement = conn.prepareStatement(
                        "SELECT lr.leaveRecordNum, lr.studentApplyId, lr.teacherDealId, lr.startTimeId, lr.endTimeId, lr.factoryId, lr.reason, lr.leaveResult, " +
                                "st1.time AS startTime, st2.time AS endTime, s.name AS studentName, t.name AS teacherName " +
                                "FROM LeaveRecord lr " +
                                "JOIN SchoolTimeTable st1 ON lr.startTimeId = st1.id " +
                                "JOIN SchoolTimeTable st2 ON lr.endTimeId = st2.id " +
                                "JOIN Student s ON lr.studentApplyId = s.id " +
                                "JOIN Teacher t ON lr.teacherDealId = t.id " +
                                "WHERE lr.leaveRecordNum = ?");) {

            statement.setInt(1, leaveRecordNum);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    leaveRecord = buildLeaveRecord(resultSet);
                }
            }
        } catch (SQLException e) {
            // 使用日志库如Log4j记录异常
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "Error fetching leave record", e);
        }

        return leaveRecord;
    }

    private LeaveRecord buildLeaveRecord(ResultSet resultSet) throws SQLException {
        LeaveRecord leaveRecord = new LeaveRecord();
        leaveRecord.setLeaveRecordNum(resultSet.getInt("leaveRecordNum"));
        leaveRecord.setStudentApplyId(resultSet.getInt("studentApplyId"));
        leaveRecord.setTeacherDealId(resultSet.getInt("teacherDealId"));

        //startTime对象
        leaveRecord.setStartTime(SchoolTime.timestampToSchool(resultSet.getTimestamp("startTime")));
        //endTime对象
        leaveRecord.setEndTime(SchoolTime.timestampToSchool(resultSet.getTimestamp("endTime")));


        leaveRecord.setReason(resultSet.getString("reason"));

        Student student = new Student();
        student.setName(resultSet.getString("studentName"));
        leaveRecord.setStudent_apply(student);

        Teacher teacher = new Teacher();
        teacher.setName(resultSet.getString("teacherName"));
        leaveRecord.setTeacher_deal(teacher);

        leaveRecord.setLeaveResult(LeaveResult.valueOf(resultSet.getString("leaveResult")));

        return leaveRecord;
    }


}