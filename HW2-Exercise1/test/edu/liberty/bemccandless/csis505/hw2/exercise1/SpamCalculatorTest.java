package edu.liberty.bemccandless.csis505.hw2.exercise1;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author bemccandless
 */
public class SpamCalculatorTest {
    
    private SpamCalculator instance;

    @Before
    public void setUp() {
        instance = new SpamCalculator();
    }

    @Test
    public void testCalculateSpamCount() {
        int result = instance.calculateSpamCount("miracle");
        assertEquals(1, result);
    }

    @Test
    public void testCalculateSpamCount_Uppercase() {
        int result = instance.calculateSpamCount("MIRACLE");
        assertEquals(1, result);
    }
    
    @Test
    public void testCalculateSpamCount_MultipleMatches() {
        int result = instance.calculateSpamCount("You're A wiNNer! Collect your miLLion dollars in this RISK free oFFer.");
        assertEquals(4, result);
    }

    @Test
    public void testCalculateSpamCount_MultipleMatchesSameWord() {
        int result = instance.calculateSpamCount("buy BUY");
        assertEquals(2, result);
    }

    @Test
    public void testCalculateSpamCount_NoMatch() {
        int result = instance.calculateSpamCount("not a match");
        assertEquals(0, result);
    }

}