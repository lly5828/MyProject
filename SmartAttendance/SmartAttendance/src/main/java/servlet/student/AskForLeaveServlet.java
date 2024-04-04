package servlet.student;

import MyInterface.InterfaceToWeb;
import basicClass.*;
import servlet.JsonData;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;



//网址：http://localhost:8080/test/AskForLeaveServlet

@WebServlet(name = "AskForLeaveServlet", value = "/AskForLeaveServlet")
public class AskForLeaveServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        JsonData<String> jsonAskForLeave;
        String stuID = req.getParameter("studentID");
        String reason = req.getParameter("reason");
        String time = req.getParameter("time");
//        Student student = InterfaceToWeb.getStudent(stuID);
        int code = InterfaceToWeb.applyLeave(stuID, InterfaceToWeb.getDate(time,DayTime.morning1), reason);
        jsonAskForLeave = new JsonData<>(code, "finish");
        jsonAskForLeave.postData(resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        this.doGet(req, resp);
    }
}
