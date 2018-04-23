package telegram.fit;

import java.util.Calendar;

class Shedule {


    static String printClasses(int k)
    {
        String[][] odd = new String[][]{
                {"","","","Управление проектами(Малахов) 39"},
                {"","","","","Маркетинг программного продукта(Борисов) 97", "Маркетинг программного продукта(Борисов) 97"},
                {"","","","","Управление проектами(Малахов) 46", "Маркетинг программного продукта(Борисов)"},
                {},
                {}};
        String[][] even = new String[][]{
                {"","","","Управление проектами(Малахов) 39"},
                {"","","","","Маркетинг программного продукта(Борисов) 97", "Маркетинг программного продукта(Борисов) 97"},
                {"","","","","Управление проектами(Малахов) 46", "Управление проектами(Малахов)"},
                {},
                {}};
        String msg = new String("Сегодня");
        Calendar today = Calendar.getInstance();
        int dayOfWeek = today.get(Calendar.DAY_OF_WEEK);
        if(k==1)
        {
            dayOfWeek=(dayOfWeek%7)+k;
            msg="Завтра";
        }
        if(dayOfWeek==1 || dayOfWeek==7)
            return msg+" выходной!";

        int dayOfWeekInMass = dayOfWeek-2;



        if((WeekParity.numberOfWeeks(k))%2==1) {
            if(odd[dayOfWeekInMass].length==0)
                return msg+" пар нет!";
            for (int i = 0; i < odd[dayOfWeekInMass].length; i++) {
                if (odd[dayOfWeekInMass][i] != "")
                    msg = msg + "\n" + (i + 1) + ". " + odd[dayOfWeekInMass][i];
            }
            return msg;
        }

        else {
            if(even[dayOfWeekInMass].length==0)
                return msg+" пар нет!";
            for (int i = 0; i < even[dayOfWeekInMass].length; i++) {
                if (even[dayOfWeekInMass][i] != "")
                    msg = msg+ "\n" + (i + 1) + ". " + even[dayOfWeekInMass][i] ;
            }
            return msg;

        }

    }
}