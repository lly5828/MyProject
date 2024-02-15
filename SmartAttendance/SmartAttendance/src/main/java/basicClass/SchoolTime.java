package basicClass;
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
}
