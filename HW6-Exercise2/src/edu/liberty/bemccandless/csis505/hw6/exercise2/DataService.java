package edu.liberty.bemccandless.csis505.hw6.exercise2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author bemccandless
 */
public class DataService {
    private static final String username = "deitel";
    private static final String password = "deitel";
    private static final String DATABASE_URL = "jdbc:derby://localhost:1527/books";
    
    public ResultSet selectAllAuthors() throws SQLException {
        final String SELECT_ALL_AUTHORS = "SELECT authorID, lastName, firstName FROM authors ORDER BY lastName, firstName";
        return runQuery(SELECT_ALL_AUTHORS);
    }

    /**
     * @param authorId
     * @return ResultSet of selecting all book title, ISBN and copyright for a specific author id.
     * @throws SQLException 
     */
    public ResultSet selectBooksByAuthor(int authorId) throws SQLException {
        final String SELECT_AUTHORS_BOOKS = 
                " SELECT title, titles.isbn, copyright, editionNumber FROM titles"
                + " INNER JOIN authorISBN ON authorISBN.isbn = titles.isbn"
                + " INNER JOIN authors ON authors.authorId = authorISBN.authorID"
                + " WHERE authors.authorId = " + authorId
                + " ORDER BY title";
        return runQuery(SELECT_AUTHORS_BOOKS);
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
        ResultSet resultSet = statement.executeQuery(query);
        
        return resultSet;
    }
}
