package com.testarea;

import java.time.LocalDateTime;

public class NewMain {

    public static void main(String[] args) {
        
        int secs = LocalDateTime.now().getSecond();
        
        System.out.println("00:00:" + secs);
        
        
        
    }

}
