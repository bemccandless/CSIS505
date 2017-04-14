package edu.liberty.bemccandless.csis505.hw4.exercise2;

import java.time.Duration;

/**
 *
 * @author bemccandless
 */
public class TimingResult {

    private long min;
    private long max;
    private long average;

    public TimingResult(long min, long max, long average) {
        this.min = min;
        this.max = max;
        this.average = average;
    }
    
    public long getMin() {
        return min;
    }

    public void setMin(long min) {
        this.min = min;
    }

    public long getMax() {
        return max;
    }

    public void setMax(long max) {
        this.max = max;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(long average) {
        this.average = average;
    }

    @Override
    public String toString() {
        return String.format("%12s | %12s | %12s", 
                String.format("%d.%d", Duration.ofNanos(min).getSeconds(), Duration.ofNanos(min).getNano()),
                String.format("%d.%d", Duration.ofNanos(max).getSeconds(), Duration.ofNanos(max).getNano()),
                String.format("%d.%d", Duration.ofNanos(average).getSeconds(), Duration.ofNanos(average).getNano()));
                
    }
    
}