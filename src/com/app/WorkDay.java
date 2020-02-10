package com.app;

import static com.app.Controller.timeElapsed;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

public class WorkDay {
    
    static DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
    static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
    static Date date;
    static LocalTime timeNow;
    
    
    
    public static String getNowDateTime(){
        
        date = new Date();
        timeNow = LocalTime.now();
        
        String datum = dateFormat.format(date);
        String timeJetzt = formatter.format(timeNow);
        
        return datum + " | " + timeJetzt;
        
    }
    
    public static String getFeierAbend(){
        timeNow = LocalTime.now().plusHours(8).plusMinutes(30);
        
        String feierAbend = formatter.format(timeNow);
        
        return feierAbend;
        
    }
    
    public static String timeStamp(){
        timeNow = LocalTime.now();

        return formatter.format(timeNow);
    }
    
    public static String elapsedTime(String startTime) throws ParseException{
        
//        Instant finish = Instant.now();
//
//        timeElapsed = Duration.between(startTime, finish).toMillis();
//
//        String s = String.format("%02d:%02d:%02d",
//                TimeUnit.MILLISECONDS.toHours(timeElapsed),
//                TimeUnit.MILLISECONDS.toMinutes(timeElapsed),
//                TimeUnit.MILLISECONDS.toSeconds(timeElapsed)
//                - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(timeElapsed)));
//
////                System.out.println(s);
//        return s;
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        sdf.setTimeZone(TimeZone.getTimeZone("UTC"));

//        String inputString = "00:01:30.500";

        Date date = sdf.parse("1970-01-01 " + startTime);
//        System.out.println("in milliseconds: " + date.getTime()); 
        
        long milliseconds = date.getTime();
        
        long finish = System.currentTimeMillis();
        
        long timeElapsed = finish - milliseconds;
        
        String test = Long.toString(timeElapsed);
        
        String formattedTimer = convertMilliToFormat(timeElapsed);
        
        return formattedTimer;
        
    }
    
    public static String convertMilliToFormat(long timeInMilli){
        
        String s = String.format("%02d:%02d:%02d",
                TimeUnit.MILLISECONDS.toHours(timeInMilli),
                TimeUnit.MILLISECONDS.toMinutes(timeInMilli),
                TimeUnit.MILLISECONDS.toSeconds(timeInMilli)
                - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(timeInMilli)));

//                System.out.println(s);
        return s;
        
    }

}
