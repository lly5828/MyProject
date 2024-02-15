package basicClass;

public class MyFunction {
    public static DayTime nextDayTime(DayTime dayTime) {
        switch (dayTime) {
            case morning1:
                return DayTime.morning2;
            case morning2:
                return DayTime.morning3;
            case morning3:
                return DayTime.morning4;
            case morning4:
                return DayTime.afternoon1;
            case afternoon1:
                return DayTime.afternoon2;
            case afternoon2:
                return DayTime.afternoon3;
            case afternoon3:
                return DayTime.afternoon4;
            default:
                return null;
        }
    }

}
