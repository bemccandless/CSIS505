package edu.liberty.bemccandless.csis505.hw1;

/**
 *
 * @author bemccandless
 */
public class InvalidFootprintException extends Exception {

    public InvalidFootprintException() {
    }

    public InvalidFootprintException(String msg) {
        super(msg);
    }

    public InvalidFootprintException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidFootprintException(Throwable cause) {
        super(cause);
    }
    
}
