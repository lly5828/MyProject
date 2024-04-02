package basicClass;

import java.util.Objects;

public class CourseTime {
    protected int dayInWeek;//7->1->2->.....->6
    protected DayTime dayTime;

    int id;
    int courseId;
    public CourseTime(int dayInWeek,DayTime dayTime){
        this.dayInWeek=dayInWeek;
        this.dayTime=dayTime;
    }

    public CourseTime() {
    }

    public int getDayInWeek() {
        return dayInWeek;
    }

    public int getDayTimeNumber() {
        switch (this.dayTime){
            case morning1:
                return 1;
            case morning2:
                return 2;
            case morning3:
                return 3;
            case morning4:
                return 4;
            case afternoon1:
                return 5;
            case afternoon2:
                return 6;
            case afternoon3:
                return 7;
            case afternoon4:
                return 8;
            default:return 0;
        }
    }


//    在下课时间调用，返回下一节上课时间
    public int getNextCourseTimeNumber(){
        switch (this.dayTime){
            case mRest0_1:
                return 1;
            case mRest1_2:
                return 2;
            case mRest2_3:
                return 3;
            case mRest3_4:
                return 4;
            case aRest0_1:
                return 5;
            case aRest1_2:
                return 6;
            case aRest2_3:
                return 7;
            case aRest3_4:
                return 8;
            default:return 0;
        }
    }

    public void setDayInWeek(int dayInWeek) {
        this.dayInWeek = dayInWeek;
    }

    public void setDayTime(DayTime dayTime) {
        this.dayTime = dayTime;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CourseTime that = (CourseTime) o;
        return dayInWeek == that.dayInWeek && dayTime == that.dayTime;
    }

    @Override
    public int hashCode() {
        return Objects.hash(dayInWeek, dayTime);
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public int getCourseId() {
        return courseId;
    }

    public int getId() {
        return id;
    }

    public DayTime getDayTime() {
        return dayTime;
    }
}
