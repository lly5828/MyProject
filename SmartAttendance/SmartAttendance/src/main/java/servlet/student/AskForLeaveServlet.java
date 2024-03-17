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


//网址：http://localhost:8080/test/AskForLeaveServlet

@WebServlet(name = "AskForLeaveServlet", value = "/AskForLeaveServlet")
public class AskForLeaveServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String stuID = req.getParameter("studentID");
        String reason = req.getParameter("reason");
        try {
            int start_weekNum = Integer.parseInt(req.getParameter("start_weekNum"));
            int start_dayInWeek = Integer.parseInt(req.getParameter("start_dayInWeek"));
            int start_courseNum = Integer.parseInt(req.getParameter("start_courseNum"));
            int end_weekNum = Integer.parseInt(req.getParameter("end_weekNum"));
            int end_dayInWeek = Integer.parseInt(req.getParameter("end_dayInWeek"));
            int end_courseNum = Integer.parseInt(req.getParameter("end_courseNum"));

            Student student = InterfaceToWeb.getStudent(stuID);
            InterfaceToWeb.applyLeave(student, start_weekNum, start_dayInWeek, start_courseNum, end_weekNum, end_dayInWeek, end_courseNum, reason);

            resp.getWriter().write("finish");

            req.setAttribute("student", student);
            req.getRequestDispatcher("/StudentMainServlet").forward(req, resp);
        } catch (NumberFormatException e) {
            resp.getWriter().write("fail exception");
        }

    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
