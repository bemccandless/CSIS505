package edu.liberty.bemccandless.csis505.hw6.exercise2;

/**
 *
 * @author bemccandless
 */
public class Author {
    
    private int authorID;
    private String firstName;
    private String lastName;

    public Author() {
    }

    public Author(int authorID, String firstName, String lastName) {
        this.authorID = authorID;
        this.firstName = firstName;
        this.lastName = lastName;
    }
    
    @Override
    public String toString() {
        return String.format("%s, %s", lastName, firstName);
    }
    
    public String getFirstName() {
        return firstName;
    }

    public int getAuthorID() {
        return authorID;
    }

    public void setAuthorID(int authorID) {
        this.authorID = authorID;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

}
