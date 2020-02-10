package com.testarea;

import java.util.HashMap;

public class LoggingStopWatch implements StopClock {

    private HashMap<String, Long> startingTimes;

    private HashMap<String, Long> measures;

    public static StopClock lastCreated = new LoggingStopWatch();

    public LoggingStopWatch() {

        this.startingTimes = new HashMap<String,Long>();

        this.measures = new HashMap<String,Long>();

        lastCreated = this;

    }

    @Override

    public StopClock start(String label) {

        startingTimes.put(label, System.currentTimeMillis());

        if (measures.get(label) == null) {

            measures.put(label, 0L);

        }

        return this;

    }

    @Override

    public StopClock pause(String label) {

        Long start = startingTimes.get(label);

        if (start == null) {

            throw new RuntimeException("Calling pause(\"" + label + "\" without calling start() at least once.");

        }

        long newMeasure = System.currentTimeMillis() - startingTimes.get(label);

        measures.put(label, measures.get(label) + newMeasure);

        startingTimes.remove(label);

        return this;

    }

    @Override

    public StopClock measure(String label) {

        if (startingTimes.containsKey(label)) {

            pause(label);

        }

        System.out.println("STOPWATCH " + label + ": " + measures.get(label));

        return this;

    }

    @Override

    public StopClock reset(String label) {

        measures.remove(label);

        return this;

    }
    
    public final class SilentStopWatch implements StopClock {

        @Override
        public StopClock start(String label) {
            return this;
        }

        @Override
        public StopClock pause(String label) {
            return this;
        }

        @Override
        public StopClock measure(String label) {
            return this;
        }

        @Override
        public StopClock reset(String label) {
            return this;
        }
    }
}
