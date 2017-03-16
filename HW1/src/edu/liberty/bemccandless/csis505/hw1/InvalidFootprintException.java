package edu.liberty.bemccandless.csis505.hw1;

/**
 *
 * @author bemccandless
 */
public class InvalidFootprintException extends Exception {

    /**
     * Creates a new instance of <code>InvalidFootprintException</code> without
     * detail message.
     */
    public InvalidFootprintException() {
    }

    /**
     * Constructs an instance of <code>InvalidFootprintException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public InvalidFootprintException(String msg) {
        super(msg);
    }
}
