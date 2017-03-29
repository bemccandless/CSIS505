package edu.liberty.bemccandless.csis505.hw2.exercise1;

/**
 *
 * @author bemccandless
 */
public class SpamCalculator {
    
    private int spamCount;
    private final String[] spamWords = {"as seen on", "buy", "meet singles", "extra income", 
            "million dollars", "save big money", "opportunity", "cash", "no fees", 
            "online degree", "work at home", "additional income", "eliminate debt", 
            "lower interest rate", "pre-approved", "consolidate your debt", "avoid backruptcy", 
            "miracle", "satisfaction", "risk free", "free hosting", "you have been selected", 
            "weekend getaway", "you're a winner!", "offer", "unlimited", "no obligation", 
            "trial", "guarantee", "no purchase necessary"};

    public int calculateSpamCount(String message) {
        spamCount = 0;
        
        for (String word : spamWords) {
            spamCount += findNumberOfOccurences(message, word);
        }
        
        return spamCount;
    }
    
    private int findNumberOfOccurences(String message, String searchWord) {
        int lastIndex = 0;
        int numOfOccurences = 0;
        
        while (lastIndex != -1) {
            lastIndex = message.toLowerCase().indexOf(searchWord, lastIndex);

            if (lastIndex != -1) {
                lastIndex += searchWord.length();
                numOfOccurences++;
            }
        }
        
        return numOfOccurences;
    }
}
