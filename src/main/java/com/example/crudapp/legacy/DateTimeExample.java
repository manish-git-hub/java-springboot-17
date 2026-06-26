package com.example.crudapp.legacy;

import java.util.Date;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.text.ParseException;

/**
 * This class uses legacy Date/Calendar APIs that should be migrated
 * to java.time API (introduced in Java 8 but still commonly needs migration)
 */
public class DateTimeExample {
    
    @SuppressWarnings("deprecation")
    public Date createDate(int year, int month, int day) {
        // Date constructor is deprecated
        return new Date(year - 1900, month - 1, day);
    }
    
    @SuppressWarnings("deprecation")
    public int getYear(Date date) {
        // getYear() is deprecated
        return date.getYear() + 1900;
    }
    
    @SuppressWarnings("deprecation")
    public int getMonth(Date date) {
        // getMonth() is deprecated
        return date.getMonth() + 1;
    }
    
    @SuppressWarnings("deprecation")
    public void setYear(Date date, int year) {
        // setYear() is deprecated
        date.setYear(year - 1900);
    }
    
    // Using Calendar which is verbose and error-prone
    public Date addDays(Date date, int days) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, days);
        return calendar.getTime();
    }
    
    // SimpleDateFormat is not thread-safe
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    
    public String formatDate(Date date) {
        return dateFormat.format(date);
    }
    
    public Date parseDate(String dateStr) throws ParseException {
        return dateFormat.parse(dateStr);
    }
    
    // Complex date manipulation that needs migration
    @SuppressWarnings("deprecation")
    public boolean isWeekend(Date date) {
        int day = date.getDay();
        return day == 0 || day == 6;
    }
    
    // Using deprecated Date.parse()
    @SuppressWarnings("deprecation")
    public Date parseDeprecated(String dateStr) {
        return new Date(Date.parse(dateStr));
    }
    
    // Complex business logic with legacy date handling
    public long calculateDaysBetween(Date start, Date end) {
        long diff = end.getTime() - start.getTime();
        return diff / (1000 * 60 * 60 * 24);
    }
    
    @SuppressWarnings("deprecation")
    public Date getStartOfDay(Date date) {
        Date result = new Date(date.getTime());
        result.setHours(0);
        result.setMinutes(0);
        result.setSeconds(0);
        return result;
    }
}

// Made with Bob
