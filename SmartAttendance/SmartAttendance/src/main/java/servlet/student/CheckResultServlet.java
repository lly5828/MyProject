package servlet.student;

import MyInterface.InterfaceToWeb;
import MyInterface.info.ResultInfo;
import basicClass.DayTime;
import basicClass.LeaveInfo.LeaveRecord;
import servlet.JsonData;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;


//网址：http://localhost:8080/test/CheckResultServlet

@WebServlet(name = "CheckResultServlet", value = "/CheckResultServlet")
public class CheckResultServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String stuID = req.getParameter("studentID");
        ResultInfo resultInfo=InterfaceToWeb.getLeaveRecordByStu(Integer.parseInt(stuID));
        JsonData<ResultInfo> jsonResult;
        if(resultInfo.isEmpty()){
            jsonResult=new JsonData<>(0,"no record",resultInfo);
        }else {
            jsonResult=new JsonData<>(0,"have record",resultInfo);
        }
        jsonResult.postData(resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        this.doGet(req, resp);
    }
}