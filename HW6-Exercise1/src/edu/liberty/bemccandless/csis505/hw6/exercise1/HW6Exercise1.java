package edu.liberty.bemccandless.csis505.hw6.exercise1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author bemccandless
 */
public class HW6Exercise1 {
    private static final String username = "deitel";
    private static final String password = "deitel";
    private static final String DATABASE_URL = "jdbc:derby://localhost:1527/books";
    
    public static void main(String[] args) {
        // Select all authors
        try (ResultSet allAuthors = selectAllAuthors()) {
            printResults("Select all authors", allAuthors);
        } catch(SQLException e) {
            e.printStackTrace();
        }
        
        // Select all book titles for a specified author ordered by year
        String author = "Deitel";
        try (ResultSet resultSet = selectBooksByAuthor(author)) {
            printResults("Select all book titles for a specified author ordered by year", resultSet);
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
        
    }
    
    public static ResultSet selectAllAuthors() throws SQLException {
        final String SELECT_ALL_AUTHORS = "SELECT authorID, firstName, lastName FROM authors";
        return runQuery(SELECT_ALL_AUTHORS);
    }
    
    public static ResultSet selectBooksByAuthor(String author) throws SQLException {
        final String SELECT_AUTHORS_BOOKS = 
                " SELECT DISTINCT title, titles.isbn, copyright FROM titles"
                + " INNER JOIN authorISBN ON authorISBN.isbn = titles.isbn"
                + " INNER JOIN authors ON authors.authorId = authorISBN.authorID"
                + " WHERE authors.firstName LIKE '" + author + "'"
                + "   OR authors.lastName LIKE '" + author + "'"
                + " ORDER BY copyright";
        return runQuery(SELECT_AUTHORS_BOOKS);
    }
    
    public static ResultSet selectAuthorsByTitle(String title) throws SQLException {
        final String SELECT_TITLE_AUTHORS = 
                " SELECT authors.firstName, authors.lastName FROM authors"
                + " INNER JOIN authorISBN ON authorISBN.authorId = authors.authorId"
                + " INNER JOIN titles ON titles.isbn = authorISBN.isbn"
                + " WHERE title LIKE '" + title + "'"
                + " ORDER BY lastName, firstName";
        return runQuery(SELECT_TITLE_AUTHORS);
    }
    
    private static void printResults(String header, ResultSet resultSet) throws SQLException {
        ResultSetMetaData metaData = resultSet.getMetaData();
        int numberOfColumns = metaData.getColumnCount();

        System.out.printf("%s%n%n", header);

        for (int i = 1; i <= numberOfColumns; i++) {
            System.out.printf("%-" + metaData.getColumnDisplaySize(i) + "s\t", metaData.getColumnName(i));
        }
        System.out.println();

        while (resultSet.next()) {
            for (int i = 1; i <= numberOfColumns; i++) {
                System.out.printf("%-" + metaData.getColumnDisplaySize(i) + "s\t", resultSet.getObject(i));
            }
            System.out.println();
        }
        
        System.out.println("---------------------------------------------------------------------");
        System.out.println();
    }
    
    private static ResultSet runQuery(String query) throws SQLException {
        Connection connection = DriverManager.getConnection(DATABASE_URL, username, password);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        
        return resultSet;
    }

}
