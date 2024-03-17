package servlet.student;

import MyInterface.InterfaceToWeb;
import basicClass.Student;
import com.google.gson.Gson;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//网址：http://localhost:8080/test/LoginStuServlet


@WebServlet(name = "LoginStuServlet", value = "/LoginStuServlet")
public class LoginStuServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String stuID = req.getParameter("studentID");
        Student student = InterfaceToWeb.getStudent(stuID);

        if (!student.getName().equals(name)) student = null;
        if (student == null) {
            resp.getWriter().write("fail");
//            req.getRequestDispatcher("返回登陆页面").forward(req, resp);
        } else {
//            System.out.println("success");
            Gson gson=new Gson();
            String json=gson.toJson(student);
            resp.getWriter().write(json);

            req.setAttribute("student", student);
            req.getRequestDispatcher("/StudentMainServlet").forward(req, resp);
        }


    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}



