package basicClass;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Objects;

//时间
public class SchoolTime {
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
        return new SchoolTime(g.get(Calendar.WEEK_OF_YEAR),dayOfweek,DayTime.getNowDayTime());
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
        return this.week==that.week&&this.courseTime.equals(that.courseTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(week, courseTime);
    }

    public boolean ifRestTime(){
        return (this.courseTime.getNextCourseTimeNumber()==0)?false:true;
    }
}
