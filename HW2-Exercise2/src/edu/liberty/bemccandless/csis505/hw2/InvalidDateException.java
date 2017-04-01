package edu.liberty.bemccandless.csis505.hw2;

/**
 * Thrown when an invalid date format has been entered
 * 
 * @author bemccandless
 */
public class InvalidDateException extends Exception {

    /**
     * Creates a new instance of <code>InvalidDateException</code> without
     * detail message.
     */
    public InvalidDateException() {
    }

    /**
     * Constructs an instance of <code>InvalidDateException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public InvalidDateException(String msg) {
        super(msg);
    }

    /**
     * 
     * @param message
     * @param cause 
     */
    public InvalidDateException(String message, Throwable cause) {
        super(message, cause);
    }
    
    /**
     * 
     * @param cause 
     */
    public InvalidDateException(Throwable cause) {
        super(cause);
    }
    
}
