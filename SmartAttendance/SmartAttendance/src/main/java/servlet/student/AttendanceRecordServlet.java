package servlet.student;

import MyInterface.info.AttendanceInfo;
import MyInterface.InterfaceToWeb;
import basicClass.*;
import servlet.JsonData;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

//网址：http://localhost:8080/test/AttendanceRecordServlet

@WebServlet(name = "AttendanceRecordServlet", value = "/AttendanceRecordServlet")
public class AttendanceRecordServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String stuID = req.getParameter("studentID");
        Student student = InterfaceToWeb.getStudent(stuID);
        ArrayList<AttendanceInfo> attendanceInfos = null;
        try {
            attendanceInfos = InterfaceToWeb.attendanceSituation(stuID);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        JsonData<ArrayList<AttendanceInfo>> jsonAttendanceSituation=new JsonData<>(0,"success", attendanceInfos);
        jsonAttendanceSituation.postData(resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        this.doGet(req, resp);
    }
}
