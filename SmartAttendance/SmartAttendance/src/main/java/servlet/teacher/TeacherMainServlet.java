package servlet.teacher;

import basicClass.Student;
import basicClass.Teacher;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//网址：http://localhost:8080/test/TeacherMainServlet

@WebServlet(name = "TeacherMainServlet", value = "/TeacherMainServlet")
public class TeacherMainServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Teacher teacher=(Teacher) req.getAttribute("teacher");
        Gson gson=new Gson();
        String json=gson.toJson(teacher);
        resp.getWriter().write(json);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
