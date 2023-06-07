package cookmaster;

import java.util.Calendar;

public class CurrentTime {

    public Calendar getCurrentTime() {
        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        int second = calendar.get(Calendar.SECOND);

        return calendar;
    }
    
}
