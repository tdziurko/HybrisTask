package hybris.blog.utils;

import org.apache.commons.lang.time.DateFormatUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateHelper {
	
	public static final String DATE_FORMAT = "yyyy.MM.dd";
	
	public enum ResetType{
		LastDay, FirstDay;
	}
	
	public static String parseDatewithPattern(String pattern,Date date) {
        return DateFormatUtils.format(date, pattern);
	}
	/*
	 * Helper methods that provide possibility to set day of date(String)
	 * to first or last, for example, 2014.05.12 => 2014.05.30
	 */
	public static String setDayToFirstOfMonth(String date) throws ParseException{
		return resetMonth(date, ResetType.FirstDay);
	}
	
	public static String setDayToLastOfMonth(String date) throws ParseException{
		return resetMonth(date, ResetType.LastDay);
	}
	
	private static String resetMonth(String date, ResetType flag) throws ParseException{

		SimpleDateFormat  formatter = new SimpleDateFormat(DATE_FORMAT);
		Date tempDate = formatter.parse(date);
			
		Calendar calendar = Calendar.getInstance();  
        calendar.setTime(tempDate);  

        calendar.add(Calendar.MONTH, 0);  
        
        switch (flag) {
	        case LastDay:
	        	calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
	            break;
	                
	        case FirstDay:
	        	calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
	            break;
        }
        
        return formatter.format(calendar.getTime()); 
	}
}
