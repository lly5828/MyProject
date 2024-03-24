package servlet.student;

import basicClass.Student;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//网址：http://localhost:8080/test/StudentMainServlet

@WebServlet(name = "StudentMainServlet", value = "/StudentMainServlet")
public class StudentMainServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Student student=(Student) req.getAttribute("student");
        Gson gson=new Gson();
        String json=gson.toJson(student);
        resp.getWriter().write(json);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}


