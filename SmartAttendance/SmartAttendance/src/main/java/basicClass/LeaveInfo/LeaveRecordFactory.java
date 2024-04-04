package basicClass.LeaveInfo;

import Database.DatabaseManager;
import basicClass.DayTime;
import basicClass.SchoolTime;
import basicClass.Student;
import basicClass.Teacher;
import exception.MyException;

import java.util.ArrayList;
import java.util.HashMap;

public class LeaveRecordFactory {
    int id;
    String name;

    HashMap<Integer,LeaveRecord> leaveRecords;

    int recordCount;

    public LeaveRecordFactory(String name) {
        this.name = name;
        this.leaveRecords=new HashMap<>();
        recordCount=0;
    }

    public LeaveRecordFactory() {
    }

    public void addLeaveRecord(SchoolTime startTime, SchoolTime endTime, String reason, Student student_apply, Teacher teacher_deal){
        this.recordCount++;
        int leaveRecordNum=this.recordCount;
        this.leaveRecords.put(recordCount,new LeaveRecord(leaveRecordNum, startTime, endTime, reason, student_apply,teacher_deal,this.getId()));
    }
    public void addLeaveRecord(SchoolTime schoolTime, String reason, Student student_apply, Teacher teacher_deal){
        addLeaveRecord(new SchoolTime(schoolTime.getWeek(), schoolTime.getDayInWeek(), DayTime.morning1),
                new SchoolTime(schoolTime.getWeek(), schoolTime.getDayInWeek(), DayTime.afternoon4),reason,student_apply,teacher_deal);
    }
    public LeaveRecord addLeaveRecordReturn(SchoolTime schoolTime, String reason, int student_applyId, int teacher_dealId){
        this.recordCount++;
        int leaveRecordNum=this.recordCount;
//        LeaveRecord leaveRecord=new LeaveRecord(leaveRecordNum,new SchoolTime(schoolTime.getWeek(), schoolTime.getDayInWeek(), DayTime.morning1),
//                new SchoolTime(schoolTime.getWeek(), schoolTime.getDayInWeek(), DayTime.afternoon4),reason,student_apply,teacher_deal,this.getId());

        LeaveRecord leaveRecord1=LeaveRecord.leaveRecordSql(leaveRecordNum,new SchoolTime(schoolTime.getWeek(), schoolTime.getDayInWeek(), DayTime.morning1),
                new SchoolTime(schoolTime.getWeek(), schoolTime.getDayInWeek(), DayTime.afternoon4),reason,student_applyId,teacher_dealId,this.getId());


        leaveRecords.put(recordCount,leaveRecord1);
        return leaveRecord1;
    }



//    search by recordNum
    public LeaveRecord getLeaveRecord(int recordNum){
        return this.leaveRecords.get(recordNum);
    }

//    search by student
//    return the arrayList<LeaveRecord>
    public ArrayList<LeaveRecord> getLeaveRecord(Student student){
        ArrayList<LeaveRecord> result=new ArrayList<>();
        for (LeaveRecord leaveRecord:leaveRecords.values()) {
            if(leaveRecord.getStudent_apply().getStudentNumber().equals(student.getStudentNumber())){
                result.add(leaveRecord);
            }
        }
        if(result.size()==0){
//            throw new MyException("The Student haven't Asked For Leave");
        }
        return result;
    }
    public ArrayList<LeaveRecord> getLeaveRecord(String studentNum){
        ArrayList<LeaveRecord> result=new ArrayList<>();
        for (LeaveRecord leaveRecord:leaveRecords.values()) {
            if(leaveRecord.getStudentApplyId()==(Integer.parseInt(studentNum))){
                result.add(leaveRecord);
            }
        }
        if(result.size()==0){
//            throw new MyException("The Student haven't Asked For Leave");
        }
        return result;
    }

//    search by teacher
//    return the arrayList<LeaveRecord>
    public ArrayList<LeaveRecord> getLeaveRecord(Teacher teacher){
        ArrayList<LeaveRecord> result=new ArrayList<>();
        for (LeaveRecord leaveRecord:leaveRecords.values()) {
            if(leaveRecord.getTeacher_deal().equals(teacher)){
                result.add(leaveRecord);
            }
        }
        if(result.size()==0){
            throw new MyException("The Teacher Haven't Record Needed To Deal");
        }
        return result;
    }


    public HashMap<Integer, LeaveRecord> getAllLeaveRecords() {
        return leaveRecords;
    }

    public String getName() {
        return name;
    }

    public int getRecordCount() {
        return recordCount;
    }

    public static HashMap<Integer,LeaveRecord> arrayToHashMap(ArrayList<LeaveRecord> arrayList){
        HashMap<Integer,LeaveRecord> hashMap=new HashMap<>();
        for(LeaveRecord leaveRecord:arrayList){
            hashMap.put(leaveRecord.getLeaveRecordNum(),leaveRecord);
        }
        return hashMap;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRecordCount(int recordCount) {
        this.recordCount = recordCount;
    }

    public void setLeaveRecords(ArrayList<LeaveRecord> leaveRecordArrayList) {
        this.leaveRecords=arrayToHashMap(leaveRecordArrayList);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
