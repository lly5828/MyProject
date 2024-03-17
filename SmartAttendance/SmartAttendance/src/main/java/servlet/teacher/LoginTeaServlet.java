package servlet.teacher;

import MyInterface.InterfaceToWeb;
import basicClass.Student;
import basicClass.Teacher;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//网址：http://localhost:8080/test/LoginTeaServlet

@WebServlet(name = "LoginTeaServlet", value = "/LoginTeaServlet")
public class LoginTeaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String teaID = req.getParameter("teacherID");

        System.out.println(name);
        System.out.println(teaID);
        Teacher teacher = InterfaceToWeb.getTeacher(teaID);
        if (!teacher.getName().equals(name)) teacher = null;
        if (teaID == null) {
            System.out.println("fail");
            resp.getWriter().write("fail");
//            req.getRequestDispatcher("返回登陆页面").forward(req, resp);
        } else {
            System.out.println("success");
            Gson gson = new Gson();
            String json = gson.toJson(teacher);
            System.out.println(json);
//            resp.getWriter().write("success");
            resp.getWriter().write(json);


//            req.setAttribute("student", student);
//            req.getRequestDispatcher("进入学生页面").forward(req, resp);
        }


    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}





