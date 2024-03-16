package servlet;

import MyInterface.InterfaceToWeb;
import basicClass.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/successServlet")

public class SuccessServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Student student = (Student) req.getAttribute("student");
        resp.setContentType("text/html;charset=utf-8");
        resp.getWriter().write("success");
    }
}

