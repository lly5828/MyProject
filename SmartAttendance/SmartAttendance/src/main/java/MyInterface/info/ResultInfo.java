package MyInterface.info;

import Database.BaseDAO;
import Database.DatabaseManager;
import Database.MyClassesDAO;
import MyInterface.InterfaceToWeb;
import basicClass.LeaveInfo.LeaveRecord;

import java.sql.SQLException;
import java.util.ArrayList;

public class ResultInfo {
    ArrayList<Res> resArrayList;

    public ResultInfo() throws SQLException {
        resArrayList=new ArrayList<>();
    }
    public void add(LeaveRecord leaveRecord) throws SQLException {
        this.resArrayList.add(new Res(leaveRecord));
    }

//    空返回true
    public boolean isEmpty(){
        return (this.resArrayList.size()==0)?true:false;
    }
}
class Res{
    int leaveRecordNum;
    String teacher;
    String time;
    String reason;
    String result;
    public Res(LeaveRecord leaveRecord) throws SQLException {
        DatabaseManager databaseManager=new DatabaseManager();
        int teacherId=leaveRecord.getTeacherDealId();
        this.leaveRecordNum=leaveRecord.getLeaveRecordNum();
        this.time =  InterfaceToWeb.getDateBySchoolTime(leaveRecord.getStartTime());
        this.reason = leaveRecord.getReason();
        this.result=leaveRecord.getLeaveResult().toString();
        this.teacher=databaseManager.getTeacherNameByTeaId(teacherId);
        BaseDAO.closeConnection(databaseManager.conn);
    }
}
