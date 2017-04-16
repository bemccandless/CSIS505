package edu.liberty.bemccandless.csis505.hw4.exercise2;

/**
 * <code>TimingResult</code> holds the minimum, maximum and average time it
 * takes for a sorting algorithm to compete sorting a data array.
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
                String.format("%d", min),
                String.format("%d", max),
                String.format("%d", average));
                
    }
    
}
