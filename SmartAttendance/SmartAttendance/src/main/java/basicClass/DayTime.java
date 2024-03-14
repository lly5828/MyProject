package basicClass;

import java.time.LocalTime;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

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

    public static DayTime getNowDayTime(){
        LocalTime localTime=LocalTime.now();
        int hour=localTime.getHour();
        int minute= localTime.getMinute();
        switch (hour){
            case 7:return minute<40?other:mRest0_1;
            case 8:return minute<40?morning1:mRest1_2;
            case 9:return minute<40?morning2:mRest2_3;
            case 10:return minute<40?morning3:mRest3_4;
            case 11:return minute<40?morning1:other;
            case 13:return minute<40?other:aRest0_1;
            case 14:return minute<40?afternoon1:aRest1_2;
            case 15:return minute<40?afternoon2:aRest2_3;
            case 16:return minute<40?afternoon3:aRest3_4;
            case 17:return minute<40?afternoon4:other;
            default:return other;
        }
    }
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

