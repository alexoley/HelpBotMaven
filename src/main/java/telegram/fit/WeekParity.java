package telegram.fit;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;

class WeekParity {

    static int numberOfWeeks(int k)
    {
        Calendar cal = Calendar.getInstance();
        cal.set(2018,Calendar.FEBRUARY,26);
        Calendar cal1 = Calendar.getInstance();
        long end = cal1.getTimeInMillis();
        long start = cal.getTimeInMillis();
        long i = TimeUnit.MILLISECONDS.toDays(Math.abs(end - start))+k;
        return ((int)i+6)/7;
    }

    static String isOdd(int number)
    {
        if(number%2==1)
            return "нечетная";
        return "четная";
    }

}