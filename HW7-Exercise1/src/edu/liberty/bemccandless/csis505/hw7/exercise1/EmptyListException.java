package edu.liberty.bemccandless.csis505.hw7.exercise1;

/**
 * Exception to through if the list is found to be empty
 * 
 * @author bemccandless
 */
public class EmptyListException extends RuntimeException {

    public EmptyListException() {
        this("List");
    } 

    public EmptyListException(String name) {
        super(name + " is empty");
    } 
}