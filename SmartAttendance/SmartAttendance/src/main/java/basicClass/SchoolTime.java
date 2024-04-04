package basicClass;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Objects;

//时间
public class SchoolTime {
    int id;
    private long timeInMillis;

    public SchoolTime() {
    }

    public void setWeek(int week) {
        this.week = week;
    }

    int week;
    CourseTime courseTime;
    public SchoolTime(int week, int dayInWeek, DayTime dayTime){
        this.week=week;
        this.courseTime=new CourseTime(dayInWeek,dayTime);
    }
    public void showSchoolTime(){
        System.out.print("Week:"+week+"\tDay In Week:周"+courseTime.dayInWeek+"\tCourse Time:"+courseTime.dayTime);
    }

    public static SchoolTime getNowSchoolTime(){
        Date date=new Date(System.currentTimeMillis());
        GregorianCalendar g=new GregorianCalendar();
        g.setTime(date);
        int dayOfweek=g.get(Calendar.DAY_OF_WEEK)==1?7:g.get(Calendar.DAY_OF_WEEK)-1;
        SchoolTime schoolTime=new SchoolTime(g.get(Calendar.WEEK_OF_YEAR),dayOfweek,DayTime.getNowDayTime());
        schoolTime.setTimeInMillis(date.getTime());
        return schoolTime;
    }



    public int getWeek() {
        return week;
    }
    public int getDayInWeek(){
        return courseTime.dayInWeek;
    }
    public DayTime getDayTime(){
        return courseTime.dayTime;
    }

    public CourseTime getCourseTime() {
        return courseTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SchoolTime that = (SchoolTime) o;
        return this.week==that.week&&this.getDayTime().equals(that.getDayTime())&&this.getDayInWeek()== that.getDayInWeek();
    }

    @Override
    public int hashCode() {
        return Objects.hash(week, courseTime);
    }

    public boolean ifRestTime(){
        return (this.courseTime.getNextCourseTimeNumber()==0)?false:true;
    }
    public boolean ifCourseTime(){return (this.courseTime.getDayTimeNumber()==0)?false:true;}




    public Timestamp toTimestamp() {
        // 假设 SchoolTime 内部存储的时间格式为符合 Timestamp 格式的字符串
        String timeString = this.convertToTimestampString(); // 假设有一个方法将时间转换为符合 Timestamp 格式的字符串
        return Timestamp.valueOf(timeString);
    }

    private String convertToTimestampString() {
        // 实现将 SchoolTime 转换为符合 Timestamp 格式的字符串的逻辑
        // 例如，可以使用 SimpleDateFormat 将日期转换为字符串
        // 这里是一个简单的示例:
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String timestampString = dateFormat.format(this.timeInMillis); // 假设 time 是 SchoolTime 类中的时间属性
        return timestampString;
    }

    public long getTimeInMillis() {
        return timeInMillis;
    }

    public void setTimeInMillis(long timeInMillis) {
        this.timeInMillis = timeInMillis;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setCourseTime(CourseTime courseTime) {
        this.courseTime = courseTime;
    }
    public static SchoolTime timestampToSchool(Timestamp timestamp){
        Date date=new Date(timestamp.getTime());
        GregorianCalendar g=new GregorianCalendar();
        g.setTime(date);
        int dayOfWeek=g.get(Calendar.DAY_OF_WEEK)==1?7:g.get(Calendar.DAY_OF_WEEK)-1;
        return new SchoolTime(g.get(Calendar.WEEK_OF_YEAR),dayOfWeek,DayTime.getNowDayTime());
    }
    public static Timestamp schoolTimeToTimestamp(SchoolTime schoolTime){
        return new Timestamp(schoolTime.getTimeInMillis());
    }

    public int getId() {
        return id;
    }

    public boolean ifSameDay(SchoolTime schoolTime){
        if(this.getWeek()==schoolTime.getWeek()){
            if(this.getCourseTime().getDayInWeek()==schoolTime.getCourseTime().getDayInWeek()){
                return true;
            }else {
                return false;
            }
        }else {
            return false;
        }
    }
    public SchoolTime getNextSchoolTime(){
        return new SchoolTime(this.week,this.getDayInWeek(),DayTime.numberToDayTime(this.getDayTime().dayTimeToNumber()+1));
    }
}
