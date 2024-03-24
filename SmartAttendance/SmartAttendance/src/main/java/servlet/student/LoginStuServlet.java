package servlet.student;

import MyInterface.InterfaceToWeb;
import MyInterface.info.StudentInfo;
import basicClass.Student;
import servlet.JsonData;
import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//网址：http://localhost:8080/test/LoginStuServlet


@WebServlet(name = "LoginStuServlet", value = "/LoginStuServlet")
public class LoginStuServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String name = req.getParameter("name");
        String stuID = req.getParameter("studentID");
        Student student = InterfaceToWeb.getStudent(stuID);
        JsonData<StudentInfo> jsonStudentInfo;
        if (!student.getName().equals(name)) {
            jsonStudentInfo=new JsonData<>(1,"fail");
        } else {
            jsonStudentInfo=new JsonData<>(0,"success",new StudentInfo(student));
        }
        jsonStudentInfo.postData(resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        this.doGet(req, resp);
    }
}



