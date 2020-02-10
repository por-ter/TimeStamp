package com.testarea;

import java.time.LocalDateTime;

public class ThreadDemo implements Runnable {

    Thread t;

    public void run() {
        
        boolean buttonPressed = true;
        
        int hour = 0;
        int mins = 0;
        
        do {
            
            int secs = LocalDateTime.now().getSecond();
            
            
            // if secs < 10
            if(secs < 10){
                System.out.println("00:0" + mins + ":0" + secs);
            }            
            if(secs < 10 && mins >= 10){
                System.out.println("00:" + mins + ":0" + secs);
            }
            
            // if secs > 10
            if(secs >= 10){
                System.out.println("00:0" + mins + ":" + secs);
            }
            if(secs >= 10 && mins >= 10){
                System.out.println("00:" + mins + ":" + secs);
            }            
            // if secs 59 then mins++
            if(secs == 59){
                mins++;
            }            
            if(mins == 59){
                hour++;
            }
            
            // if mins < 10
            
            // if hours < 10
            
            

            try {
                // thread to sleep for 1000 milliseconds
                Thread.sleep(1000);
            } catch (Exception e) {
                System.out.println(e);
            }
            
        } while (buttonPressed);
        
    }

    public static void main(String[] args) throws Exception {
        Thread t = new Thread(new ThreadDemo());
        // this will call run() function
        t.start();

//      Thread t2 = new Thread(new ThreadDemo());
//      // this will call run() function
//      t2.start();
    }
}
