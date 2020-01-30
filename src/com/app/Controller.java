package com.app;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.TimeUnit;

public class Controller {

//    static Instant start;
    static long timeElapsed;
    static long pauseElapsed = 0;
    static long pauseTotal = 0;
    static long arbeitElapsed = 0;
    static long arbeitTotal = 0;

    public static String stopwatchPrinted(Instant start) {

        Instant finish = Instant.now();

        timeElapsed = Duration.between(start, finish).toMillis();

        String s = String.format("%02d:%02d:%02d",
                TimeUnit.MILLISECONDS.toHours(timeElapsed),
                TimeUnit.MILLISECONDS.toMinutes(timeElapsed),
                TimeUnit.MILLISECONDS.toSeconds(timeElapsed)
                - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(timeElapsed)));

//                System.out.println(s);
        return s;

    }

}
