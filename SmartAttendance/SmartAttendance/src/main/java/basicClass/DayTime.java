package basicClass;

import java.time.LocalTime;


//上课时间
public enum DayTime {

    mRest0_1,//课间-----7:40->8:00
    morning1,//早上第一节-----8:00->8:40
    mRest1_2,//课间-----8:40->9:00
    morning2,//早上第二节-----9:00->9:40
    mRest2_3,//课间-----9:40->10:00
    morning3,//早上第三节-----10:00->10:40
    mRest3_4,//课间-----10:40->11:00
    morning4,//早上第四节-----11:00->11:40
    aRest0_1,//下午-----13：40->14:00
    afternoon1,//下午第一节-----14:00->14:40
    aRest1_2,//下午-----14：40->15:00
    afternoon2,//下午第二节-----15:00->15:40
    aRest2_3,//下午-----15：40->16:00
    afternoon3,//下午第三节-----16:00->16:40
    aRest3_4,//下午-----16：40->17:00
    afternoon4,//下午第四节-----17:00->17:40
    other;

    public static DayTime getNowDayTime() {
        LocalTime localTime = LocalTime.now();
        int hour = localTime.getHour();
        int minute = localTime.getMinute();
        switch (hour) {
            case 7:
                return minute < 40 ? other : mRest0_1;
            case 8:
                return minute < 40 ? morning1 : mRest1_2;
            case 9:
                return minute < 40 ? morning2 : mRest2_3;
            case 10:
                return minute < 40 ? morning3 : mRest3_4;
            case 11:
                return minute < 40 ? morning1 : other;
            case 13:
                return minute < 40 ? other : aRest0_1;
            case 14:
                return minute < 40 ? afternoon1 : aRest1_2;
            case 15:
                return minute < 40 ? afternoon2 : aRest2_3;
            case 16:
                return minute < 40 ? afternoon3 : aRest3_4;
            case 17:
                return minute < 40 ? afternoon4 : other;
            default:
                return other;
        }
    }

    public DayTime nextCourseDayTime() {
        switch (this) {
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

    public int courseToNumber() {
        switch (this) {
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
            default:
                return 0;
        }
    }
    public static DayTime numberToCourseDaTime(int n) {
        switch (n) {
            case 1:
                return morning1;
            case 2:
                return morning2;
            case 3:
                return morning3;
            case 4:
                return morning4;
            case 5:
                return afternoon1;
            case 6:
                return afternoon2;
            case 7:
                return afternoon3;
            case 8:
                return afternoon4;
            default:
                return other;
        }
    }

    public int dayTimeToNumber() {
        switch (this) {
            case mRest0_1:
                return 0;
            case morning1:
                return 1;
            case mRest1_2:
                return 2;
            case morning2:
                return 3;
            case mRest2_3:
                return 4;
            case morning3:
                return 5;
            case mRest3_4:
                return 6;
            case morning4:
                return 7;
            case aRest0_1:
                return 8;
            case afternoon1:
                return 9;
            case aRest1_2:
                return 10;
            case afternoon2:
                return 11;
            case aRest2_3:
                return 12;
            case afternoon3:
                return 13;
            case aRest3_4:
                return 14;
            case afternoon4:
                return 15;
            default:
                return 16;
        }
    }


    public static DayTime numberToDayTime(int n) {
        switch (n) {
            case 0:
                return mRest0_1;
            case 1:
                return morning1;
            case 2:
                return mRest1_2;
            case 3:
                return morning2;
            case 4:
                return mRest2_3;
            case 5:
                return morning3;
            case 6:
                return mRest3_4;
            case 7:
                return morning4;
            case 8:
                return aRest0_1;
            case 9:
                return afternoon1;
            case 10:
                return aRest1_2;
            case 11:
                return afternoon2;
            case 12:
                return aRest2_3;
            case 13:
                return afternoon3;
            case 14:
                return aRest3_4;
            case 15:
                return afternoon4;
            default:
                return other;
        }
    }

    public String toString(){
        switch (this) {
            case morning1:
                return "早上第1节";
            case morning2:
                return "早上第2节";
            case morning3:
                return "早上第3节";
            case morning4:
                return "早上第4节";
            case afternoon1:
                return "下午第1节";
            case afternoon2:
                return "下午第2节";
            case afternoon3:
                return "下午第3节";
            case afternoon4:
                return "下午第4节";
            default:
                return "非上课时间";
        }
    }

}

