package edu.liberty.bemccandless.csis505.hw2;

/**
 *
 * @author bemccandless
 */
public class DateConverter {
    
    private final String[] months = {
        "January", "February", "March", "April", "May", "June", "July",
        "August", "September", "October", "November", "December"
    };
        
    public String convertDate(String date) throws InvalidDateException {
        if (!validDateFormat(date)) {
            throw new InvalidDateException("Invalid date format, must be 'mm/dd/yyyy'");
        }
        
        FormattedDate formattedDate = parseDate(date);
        
        return String.format("%s %d, %d", months[formattedDate.getMonth() - 1], formattedDate.getDay(), formattedDate.getYear());
    }
    
    private boolean validDateFormat(String date) {
        return date.matches("[0-1][0-9]\\/[0-3][0-9]\\/\\d\\d\\d\\d");
    }
    
    private FormattedDate parseDate(String date) {
        FormattedDate formattedDate = new FormattedDate();
        int index = 0;
        int firstSlash = date.indexOf("/");
        int secondSlash = date.indexOf("/", firstSlash + 1);
        
        formattedDate.setMonth(Integer.valueOf(date.substring(index, firstSlash)));
        formattedDate.setDay(Integer.valueOf(date.substring(firstSlash + 1, secondSlash)));
        formattedDate.setYear(Integer.valueOf(date.substring(secondSlash + 1)));
        
        return formattedDate;
    }
    
}
