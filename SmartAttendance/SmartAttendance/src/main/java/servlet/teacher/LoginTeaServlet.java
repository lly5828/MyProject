package servlet.teacher;

import MyInterface.InterfaceToWeb;
import basicClass.Teacher;
import servlet.JsonData;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//网址：http://localhost:8080/test/LoginTeaServlet

@WebServlet(name = "LoginTeaServlet", value = "/LoginTeaServlet")
public class LoginTeaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String name = req.getParameter("name");
        String teaID = req.getParameter("teacherID");

        Teacher teacher = InterfaceToWeb.getTeacher(teaID);
        if (!teacher.getName().equals(name)) teacher = null;
        JsonData<Teacher> jsonTeacher;
        if (teacher == null) {
            jsonTeacher=new JsonData<>(1,"fail",teacher);
        } else {
            jsonTeacher=new JsonData<>(0,"success",teacher);
        }
        jsonTeacher.postData(resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws  IOException {
        this.doGet(req, resp);
    }
}





