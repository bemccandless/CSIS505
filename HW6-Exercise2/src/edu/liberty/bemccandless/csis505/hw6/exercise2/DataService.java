package edu.liberty.bemccandless.csis505.hw6.exercise2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author bemccandless
 */
public class DataService {
    private static final String USERNAME = "deitel";
    private static final String PASSWORD = "deitel";
    private static final String DATABASE_URL = "jdbc:derby://localhost:1527/books";
    private final Connection connection;

    public DataService() throws SQLException {
        this.connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
    }
    
    public ResultSet selectAllAuthors() throws SQLException {
        final String SELECT_ALL_AUTHORS = "SELECT authorID, lastName, firstName FROM authors ORDER BY lastName, firstName";
        return connection.createStatement().executeQuery(SELECT_ALL_AUTHORS);
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
        
        return connection.createStatement().executeQuery(SELECT_AUTHORS_BOOKS);
    }
    
    public void updateBook(Book book) throws SQLException {
        final String UPDATE_BOOK = String.format(
                "UPDATE titles SET title='%s', isbn='%s', copyright='%s', editionNumber=%d"
                + " WHERE titles.isbn='%s'", 
                book.getTitle(), book.getIsbn(), book.getCopyright(), 
                book.getEditionNumber(), book.getIsbn());
        
        connection.createStatement().executeUpdate(UPDATE_BOOK);
    }
    
    public void addBookForAuthor(Book book, int authorId) throws SQLException {
        final String INSERT_BOOK = String.format(
                "INSERT INTO titles (title, isbn, copyright, editionNumber)"
                + " VALUES ('%s', '%s', '%s', %d)", book.getTitle(), book.getIsbn(), book.getCopyright(), book.getEditionNumber());
        final String INSERT_AUTHOR_ISBN = String.format(
                "INSERT INTO authorISBN (authorID, isbn)"
                + " VALUES (%d, '%s')", authorId, book.getIsbn());
        
        connection.createStatement().executeUpdate(INSERT_BOOK);
        connection.createStatement().executeUpdate(INSERT_AUTHOR_ISBN);
    }
}
