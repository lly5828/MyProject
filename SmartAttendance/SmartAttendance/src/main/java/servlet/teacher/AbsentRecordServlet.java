package servlet.teacher;

import MyInterface.InterfaceToWeb;
import MyInterface.info.AbsentInfo;
import MyInterface.info.TeacherInfo;
import basicClass.Teacher;
import com.google.gson.Gson;
import servlet.JsonData;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;


//网址：http://localhost:8080/test/AbsentRecordServlet

@WebServlet(name = "AbsentRecordServlet", value = "/AbsentRecordServlet")
public class AbsentRecordServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String teaID = req.getParameter("teacherID");
        try {
            AbsentInfo absentInfo=InterfaceToWeb.getTodayAbsentInfo(teaID);
            JsonData<AbsentInfo> jsonAbsent=new JsonData<>(0,"success",absentInfo);
            jsonAbsent.postData(resp);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}