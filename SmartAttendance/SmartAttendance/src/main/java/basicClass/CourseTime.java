package basicClass;

public class CourseTime {
    protected int dayInWeek;
    protected DayTime dayTime;
    public CourseTime(int dayInWeek,DayTime dayTime){
        this.dayInWeek=dayInWeek;
        this.dayTime=dayTime;
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
            default:
                return 8;
        }
    }
}
