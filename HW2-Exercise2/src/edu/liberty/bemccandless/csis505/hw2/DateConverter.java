package edu.liberty.bemccandless.csis505.hw2;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author bemccandless
 */
public class DateConverter {
    
    public String convertDate(String date) throws InvalidDateException {
        if (!validDateFormat(date)) {
            throw new InvalidDateException("Invalid date format, must be 'mm/dd/yyyy'");
        }
        
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        DateFormat longDateFormat = DateFormat.getDateInstance(DateFormat.LONG);
        dateFormat.setLenient(false);
        
        Date parsedDate;
        try {
            parsedDate = dateFormat.parse(date);
            Calendar cal = Calendar.getInstance();
            cal.setTime(parsedDate);
            
            return longDateFormat.format(parsedDate);
        } catch (ParseException ex) {
            throw new InvalidDateException("Invalid date format, must be 'mm/dd/yyyy'", ex);
        }
    }
    
    private boolean validDateFormat(String date) {
        return date.matches("[0-1][0-9]\\/[0-3][0-9]\\/\\d{4}");
    }
}
