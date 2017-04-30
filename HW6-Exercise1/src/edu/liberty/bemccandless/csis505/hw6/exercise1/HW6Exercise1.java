package edu.liberty.bemccandless.csis505.hw6.exercise1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * This application interacts with a Java Database to select specific information
 * regarding the different tables associated with Books, Authors and ISBN.
 * 
 * @author bemccandless
 */
public class HW6Exercise1 {
    private static final String username = "deitel";
    private static final String password = "deitel";
    private static final String DATABASE_URL = "jdbc:derby://localhost:1527/books";
    
    /**
     * Runs predefined queries to retrieve data from the database
     * 
     * @param args 
     */
    public static void main(String[] args) {
        // Select all authors
        try (ResultSet allAuthors = selectAllAuthors()) {
            printResults("Select all authors", allAuthors);
        } catch(SQLException e) {
            e.printStackTrace();
        }
        
        // Select all book titles for a specified author ordered by year
        try (ResultSet booksByAuthor = selectBooksByAuthor("Abbey", "Deitel")) {
            printResults("Select all book titles for a specified author ordered by year", booksByAuthor);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        // Select all authors for a specifed book title ordered by last name then first name
        String title = "Android for Programmers: An App-Driven Approach";
        try (ResultSet resultSet = selectAuthorsByTitle(title)) {
            printResults("Select all authors for a specifed book title ordered by last name then first name", resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        // Add an author to the authors table
        try {
            ResultSet allAuthorsBefore = selectAllAuthors();
            printResults("Before adding another author", allAuthorsBefore);
            
            addAuthor("Brian", "McCandless");
            
            ResultSet allAuthorsAfter = selectAllAuthors();
            printResults("After adding another author", allAuthorsAfter);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        // Delete a book from am author
        try {
            ResultSet booksByAuthorBefore = selectBooksByAuthor("Michael", "Morgano");
            printResults("Before deleting book from author", booksByAuthorBefore);
            
            deleteBookForAuthor("0132121360", 5);
            
            ResultSet booksByAuthorAfter = selectBooksByAuthor("Michael", "Morgano");
            printResults("After deleting book from author", booksByAuthorAfter);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
    
    /**
     * @return ResultSet of selecting all authors in the Author table
     * @throws SQLException 
     */
    public static ResultSet selectAllAuthors() throws SQLException {
        final String SELECT_ALL_AUTHORS = "SELECT authorID, firstName, lastName FROM authors";
        return runQuery(SELECT_ALL_AUTHORS);
    }
    
    /**
     * @param firstName
     * @param lastName
     * @return ResultSet of selecting all book title, isbn and copyright for a specific author.
     * @throws SQLException 
     */
    public static ResultSet selectBooksByAuthor(String firstName, String lastName) throws SQLException {
        final String SELECT_AUTHORS_BOOKS = 
                " SELECT title, titles.isbn, copyright FROM titles"
                + " INNER JOIN authorISBN ON authorISBN.isbn = titles.isbn"
                + " INNER JOIN authors ON authors.authorId = authorISBN.authorID"
                + " WHERE authors.firstName='" + firstName + "'"
                + "   AND authors.lastName='" + lastName + "'"
                + " ORDER BY copyright";
        return runQuery(SELECT_AUTHORS_BOOKS);
    }
    
    /**
     * @param title
     * @return ResultSet of selecting all authors for a specified book title.
     * @throws SQLException 
     */
    public static ResultSet selectAuthorsByTitle(String title) throws SQLException {
        final String SELECT_TITLE_AUTHORS = 
                " SELECT authors.firstName, authors.lastName FROM authors"
                + " INNER JOIN authorISBN ON authorISBN.authorId = authors.authorId"
                + " INNER JOIN titles ON titles.isbn = authorISBN.isbn"
                + " WHERE title LIKE '" + title + "'"
                + " ORDER BY lastName, firstName";
        return runQuery(SELECT_TITLE_AUTHORS);
    }
    
    /**
     * Delete a book for a specific author.
     * 
     * @param isbn
     * @param authorId
     * @throws SQLException 
     */
    public static void deleteBookForAuthor(String isbn, int authorId) throws SQLException {
        final String DELETE_AUTHOR_ISBN = String.format(
                "DELETE FROM authorISBN"
                + " WHERE authorISBN.isbn='%s' and authorISBN.authorID=%d", isbn, authorId);
        
        runQuery(DELETE_AUTHOR_ISBN);
    }
    
    /**
     * Add a author to the authors table.
     * 
     * @param firstName
     * @param lastName
     * @throws SQLException 
     */
    public static void addAuthor(String firstName, String lastName) throws SQLException {
        final String INSERT_AUTHOR = String.format(
                "INSERT INTO authors (firstName, lastName)"
                + " VALUES ('%s', '%s')", firstName, lastName);
        
        runQuery(INSERT_AUTHOR);
    }
    
    /**
     * Prints the specified Header and ResultSet in a table format to the System.out stream.
     * 
     * @param header
     * @param resultSet
     * @throws SQLException 
     */
    private static void printResults(String header, ResultSet resultSet) throws SQLException {
        ResultSetMetaData metaData = resultSet.getMetaData();
        int numberOfColumns = metaData.getColumnCount();

        System.out.printf("%s%n%n", header);

        for (int i = 1; i <= numberOfColumns; i++) {
            System.out.printf("%-" + metaData.getColumnDisplaySize(i) + "s", metaData.getColumnName(i));
        }
        System.out.println();

        while (resultSet.next()) {
            for (int i = 1; i <= numberOfColumns; i++) {
                System.out.printf("%-" + metaData.getColumnDisplaySize(i) + "s", resultSet.getObject(i));
            }
            System.out.println();
        }
        
        System.out.println("---------------------------------------------------------------------");
        System.out.println();
    }
    
    /**
     * Connects to a specified database and runs the given query.
     * 
     * @param query
     * @return ResultSet
     * @throws SQLException 
     */
    private static ResultSet runQuery(String query) throws SQLException {
        Connection connection = DriverManager.getConnection(DATABASE_URL, username, password);
        Statement statement = connection.createStatement();
        
        statement.execute(query);
        
        return statement.getResultSet();
    }

}
