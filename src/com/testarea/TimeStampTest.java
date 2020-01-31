package com.testarea;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class TimeStampTest {

    public static void main(String[] args) {
        
        LocalDate localDate = LocalDate.now();
        System.out.println("LocalDate localDate = LocalDate.now(); = \t\t" + localDate);
        
        System.out.println("LocalDate.of(2015, 02, 20) = \t\t" + LocalDate.of(2015, 02, 20));
        System.out.println("LocalDate.parse(\"2015-02-20\") = \t\t" + LocalDate.parse("2015-02-20"));
        
        LocalDate tomorrow = LocalDate.now().plusDays(1);
        System.out.println("Tomorrow ....LocalDate.now().plusDays(1) = \t\t" + tomorrow);
        
        ///////////////////////////// LocalTime
        System.out.println("\n####################\n\n");
        
        // An instance of current LocalTime can be created from the system clock as below:
        LocalTime now = LocalTime.now();        
        System.out.println("Time now = \t\t" + now);
        
        // In the below code sample, we create a LocalTime representing 06:30 AM by parsing a string representation:
        LocalTime sixThirty = LocalTime.parse("06:30");
        System.out.println(sixThirty);
        
        // The below example creates a LocalTime by parsing a string and adds an hour 
        // to it by using the “plus” API. The result would be LocalTime representing 07:30 AM:
        LocalTime sevenThirty = LocalTime.parse("06:30").plus(1, ChronoUnit.HOURS);
        
        // Various getter methods are available which can be used to get specific units of time like hour, min and secs like below:
        int six = LocalTime.parse("06:30").getHour();
        System.out.println(six);
        
        
    }

}
