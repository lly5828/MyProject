package servlet.teacher;

import MyInterface.InterfaceToWeb;
import MyInterface.info.LeaveInfo;
import basicClass.LeaveInfo.LeaveRecord;
import basicClass.LeaveInfo.LeaveRecordFactory;
import basicClass.MyClass;
import basicClass.Teacher;
import servlet.JsonData;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;


//网址：http://localhost:8080/test/DealLeaveServlet
@WebServlet(name = "DealLeaveServlet", value = "/DealLeaveServlet")
public class DealLeaveServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String teaID = req.getParameter("teacherID");
        Teacher teacher = InterfaceToWeb.getTeacher(teaID);
        JsonData<String> jsonDealLeave;
        LeaveRecordFactory leaveRecordFactory = InterfaceToWeb.getLeaveRecord(teacher);
        if (leaveRecordFactory == null) {
            jsonDealLeave=new JsonData<>(1,"no apply need to deal");
        } else {
            try {
                int leaveRecordNum = Integer.parseInt(req.getParameter("LeaveRecordNum"));
                String result = req.getParameter("result");
                if (result.equals("true")) {
                    InterfaceToWeb.dealLeaveRecord(teacher, leaveRecordNum, true);
                    jsonDealLeave=new JsonData<>(0,"pass the apply");
                } else if (result.equals("false")) {
                    InterfaceToWeb.dealLeaveRecord(teacher, leaveRecordNum, false);
                    jsonDealLeave=new JsonData<>(0,"reject the apply");
                } else {
                    jsonDealLeave=new JsonData<>(1,"error exception in result");
                }
            } catch (NumberFormatException e) {
                jsonDealLeave=new JsonData<>(1,"error exception in number");
            }
        }
        jsonDealLeave.postData(resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String teaID=req.getParameter("teacherID");
        Teacher teacher = InterfaceToWeb.getTeacher(teaID);
        MyClass myClass=teacher.getTeachClass();
        LeaveRecordFactory leaveRecordFactory=InterfaceToWeb.getLeaveRecordFactory(myClass);
        ArrayList<LeaveInfo> leaveInfos=InterfaceToWeb.factoryToLeaveInfo(leaveRecordFactory);
        JsonData<ArrayList<LeaveInfo>> jsonLeaveInfo;
        if(leaveInfos.size()<=0){
            jsonLeaveInfo=new JsonData<>(1,"no leaveInfo",leaveInfos);
        }else {
            jsonLeaveInfo=new JsonData<>(0, "leaveInfos", leaveInfos);
        }
        jsonLeaveInfo.postData(resp);
    }
}
