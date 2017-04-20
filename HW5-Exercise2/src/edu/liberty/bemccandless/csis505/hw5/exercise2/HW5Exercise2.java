package edu.liberty.bemccandless.csis505.hw5.exercise2;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

/**
 * This application creates an <code>ArrayList</code> of 10 <code>Pair</code> objects
 * which holds two generic type elements. New <code>Pair</code> objects are created with random 
 * integers and dates, then the <code>ArrayList</code> of <code>Pair</code>s is 
 * printed to <code>System.out</code>.
 * 
 * @author bemccandless
 */
public class HW5Exercise2 {

    public static void main(String[] args) {
        List<Pair> pairs = new ArrayList();
        IntStream.iterate(0, (i) -> ++i)
                .limit(10)
                .forEach((i) -> pairs.add(createRandomPair()));
        
        pairs.stream()
                .forEach(System.out::println);
        
    }
    
    /**
     * Create a new <code>Pair</code> with a random integer for the first element
     * and a modified date for the second element;
     * 
     * @return a new <code>Pair</code> with random values
     */
    private static Pair createRandomPair() {
        int randomNum = new Random().nextInt(50);
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, randomNum);
        cal.add(Calendar.MONTH, randomNum);
        
        return new Pair(randomNum, cal.getTime());
    }    

}
