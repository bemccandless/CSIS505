package edu.liberty.bemccandless.csis505.hw7.exercise1;

/**
 *
 * @author bemccandless
 */
public class EmptyListException extends Exception {

    /**
     * Creates a new instance of <code>EmptyListException</code> without detail message.
     */
    public EmptyListException() {
    }


    /**
     * Constructs an instance of <code>EmptyListException</code> with the specified detail message.
     * @param msg the detail message.
     */
    public EmptyListException(String msg) {
        super(msg);
    }
}
