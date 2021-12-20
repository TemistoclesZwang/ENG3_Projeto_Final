package br.com.eng3.springbootfirebase.Fbase.Utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import br.com.eng3.springbootfirebase.Fbase.model.Booking;


public class DateUtils {

    public static Date stringToDate(String date) throws ParseException { 
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date ndate = df.parse(date);
		return ndate;
    }

    public static Boolean inDateRange(Booking booking, Date reqstartdate, Date reqenddate) {
        Boolean res = false;

        Date bkstartdate = booking.getStartDate();
        Date bkenddate = booking.getEndDate();

        int result1 = compareDates(bkstartdate, reqstartdate);
        int result2 = compareDates(bkenddate, reqstartdate);

        int result3 = compareDates(bkstartdate, reqenddate);
        int result4 = compareDates(bkenddate, reqenddate);

        int result5 = compareDates(bkstartdate, reqstartdate);
        int result6 = compareDates(bkenddate, reqenddate);

        if(result1 <= 0 && result2 >= 0) {
            res = true;
        } else if (result3 <= 0 && result4 >= 0) {
            res = true;
        } else if (result5 == 1 && result6 == -1) {
            res = true;
        }
        return res;
    }
    
    private static int compareDates(Date date1, Date date2) {
        int result = date1.compareTo(date2);
        return result;
    }
}
