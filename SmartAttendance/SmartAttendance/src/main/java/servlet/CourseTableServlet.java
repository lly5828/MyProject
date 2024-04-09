package servlet;

import MyInterface.InterfaceToWeb;
import basicClass.DayTime;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

//网址：http://localhost:8080/test/CourseTableServlet

@WebServlet(name = "CourseTableServlet", value = "/CourseTableServlet")
public class CourseTableServlet extends HttpServlet {
    @Override
    //传入学生学号
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String stuID = req.getParameter("studentID");
        try {
            String[][] res=InterfaceToWeb.getCourseTableStu(stuID);
            JsonData<String[][]> jsonCourseTable=new JsonData<>(0,"finish",res);
            jsonCourseTable.postData(resp);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    //传入教师工号
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String teaID = req.getParameter("teacherID");
        try {
            String[][] res=InterfaceToWeb.getCourseTableTea(teaID);
            JsonData<String[][]> jsonCourseTable=new JsonData<>(0,"finish",res);
            jsonCourseTable.postData(resp);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}