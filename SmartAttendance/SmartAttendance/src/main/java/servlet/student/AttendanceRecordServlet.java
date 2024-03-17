package servlet.student;

import MyInterface.InterfaceToWeb;
import basicClass.*;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

//网址：http://localhost:8080/test/AttendanceRecordServlet

@WebServlet(name = "AttendanceRecordServlet", value = "/AttendanceRecordServlet")
public class AttendanceRecordServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String stuID = req.getParameter("studentID");
        Student student = InterfaceToWeb.getStudent(stuID);

//        Student testStu=new Student("xxx","xxx",true,"123");
//        testStu.addAttendanceRecord(SchoolTime.getNowSchoolTime(),"aaa", Status.normal);
//        testStu.addAttendanceRecord(new SchoolTime(1,1, DayTime.afternoon1),"bbb", Status.normal);

        ArrayList<AttendanceRecord> attendanceRecords=InterfaceToWeb.getAttendanceRecord(student);

        Gson gson = new Gson();
        String json = gson.toJson(attendanceRecords);
        resp.getWriter().write(json);

        req.setAttribute("student", student);
        req.getRequestDispatcher("/StudentMainServlet").forward(req, resp);


    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
