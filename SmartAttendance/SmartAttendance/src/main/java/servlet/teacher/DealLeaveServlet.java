package servlet.teacher;

import MyInterface.InterfaceToWeb;
import basicClass.LeaveInfo.LeaveRecordFactory;
import basicClass.Student;
import basicClass.Teacher;
import jdk.nashorn.internal.runtime.arrays.IteratorAction;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


//网址：http://localhost:8080/test/DealLeaveServlet
@WebServlet(name = "DealLeaveServlet", value = "/DealLeaveServlet")
public class DealLeaveServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String teaID = req.getParameter("teacherID");
//        Teacher teacher=InterfaceToWeb.getTeacher(teaID);

        Teacher teacher = (Teacher) req.getAttribute("teacher");

        LeaveRecordFactory leaveRecordFactory = InterfaceToWeb.getLeaveRecord(teacher);
        if (leaveRecordFactory == null) {
            resp.getWriter().write("no right to deal");
            req.setAttribute("teacher", teacher);
            req.getRequestDispatcher("/TeacherMainServlet").forward(req, resp);
        } else {
            try {
                int leaveRecordNum = Integer.parseInt(req.getParameter("LeaveRecordNum"));
                String result = req.getParameter("result");
                if (result.equals("true")) {
                    InterfaceToWeb.dealLeaveRecord(teacher, leaveRecordNum, true);
                } else if (result.equals("false")) {
                    InterfaceToWeb.dealLeaveRecord(teacher, leaveRecordNum, false);
                } else {
                    resp.getWriter().write("fail expression");
                }
            } catch (NumberFormatException e) {
                resp.getWriter().write("fail expression");
            }


            req.setAttribute("teacher", teacher);
            req.getRequestDispatcher("/DealLeaveServlet").forward(req, resp);
        }


    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
