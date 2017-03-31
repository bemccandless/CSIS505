package edu.liberty.bemccandless.csis505.hw2.exercise1;

/**
 * This class calculates the number of spam words found in a given String
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

    /**
     * 
     * @param message
     * @return the number of spam words found in <code>String message</code>
     */
    public int calculateSpamCount(String message) {
        spamCount = 0;
        
        for (String word : spamWords) {
            spamCount += findNumberOfOccurrences(message, word);
        }
        
        return spamCount;
    }
    
    /**
     * 
     * @param message
     * @param searchWord
     * @return the number of occurrences of the <code>String searchWord</code> 
     *         that are found in the <code>String message</code>
     */
    private int findNumberOfOccurrences(String message, String searchWord) {
        int index = 0;
        int numOfOccurences = 0;
        
        while (index != -1) {
            // find the first occurrence of the word
            index = message.toLowerCase().indexOf(searchWord, index);

            if (index != -1) {
                // move the starting position of the search to the end of the last occurrence
                index += searchWord.length();
                numOfOccurences++;
            }
        }
        
        return numOfOccurences;
    }
}
