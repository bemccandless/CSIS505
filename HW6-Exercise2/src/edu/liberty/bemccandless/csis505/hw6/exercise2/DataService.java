package edu.liberty.bemccandless.csis505.hw6.exercise2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * This class interacts with the database to retrieve and modify data.
 * 
 * @author bemccandless
 */
public class DataService {
    
    private static final String USERNAME = "deitel";
    private static final String PASSWORD = "deitel";
    private static final String DATABASE_URL = "jdbc:derby://localhost:1527/books";
    private final Connection connection;

    /**
     * Empty constructor that sets up the database connection.
     * 
     * @throws SQLException 
     */
    public DataService() throws SQLException {
        this.connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
    }
    
    /**
     * @return all records in the authors table
     * @throws SQLException 
     */
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
    
    /**
     * Modify a specific book record with the updated information.
     * 
     * @param book
     * @throws SQLException 
     */
    public void updateBook(Book book) throws SQLException {
        final String UPDATE_BOOK = String.format(
                "UPDATE titles SET title='%s', isbn='%s', copyright='%s', editionNumber=%d"
                + " WHERE titles.isbn='%s'", 
                book.getTitle(), book.getIsbn(), book.getCopyright(), 
                book.getEditionNumber(), book.getIsbn());
        
        connection.createStatement().executeUpdate(UPDATE_BOOK);
    }
    
    /**
     * Add a book for a specific author.
     * 
     * @param book
     * @param authorId
     * @throws SQLException 
     */
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
    
    /**
     * Delete a book for a specific author.
     * 
     * @param isbn
     * @param authorId
     * @throws SQLException 
     */
    public void deleteBookForAuthor(String isbn, int authorId) throws SQLException {
        final String DELETE_AUTHOR_ISBN = String.format(
                "DELETE FROM authorISBN"
                + " WHERE authorISBN.isbn='%s' and authorISBN.authorID=%d", isbn, authorId);
        
        connection.createStatement().executeUpdate(DELETE_AUTHOR_ISBN);
    }
    
    /**
     * Modify a specific author record with the updated information.
     * 
     * @param author
     * @throws SQLException 
     */
    public void updateAuthor(Author author) throws SQLException {
        final String UPDATE_AUTHOR = String.format(
                "UPDATE authors SET firstName='%s', lastName='%s'"
                + " WHERE authors.authorID=%d", author.getFirstName(), author.getLastName(), author.getAuthorID());
        
        connection.createStatement().executeUpdate(UPDATE_AUTHOR);
    }
    
    /**
     * Add a author to the authors table.
     * 
     * @param author
     * @return
     * @throws SQLException 
     */
    public int addAuthor(Author author) throws SQLException {
        final String INSERT_AUTHOR = String.format(
                "INSERT INTO authors (firstName, lastName)"
                + " VALUES ('%s', '%s')", author.getFirstName(), author.getLastName());
        
        Statement insertStatement = connection.createStatement();
        insertStatement.executeUpdate(INSERT_AUTHOR, Statement.RETURN_GENERATED_KEYS);
        ResultSet generatedKeys = insertStatement.getGeneratedKeys();
        
        while (generatedKeys.next()) {
            return generatedKeys.getInt(1);
        }
        
        return -1;
    }
    
    /**
     * Delete a author from the authors table
     * 
     * @param author
     * @throws SQLException 
     */
    public void deleteAuthor(Author author) throws SQLException {
        final String DELETE_AUTHOR = String.format(
                "DELETE FROM authors"
                + " WHERE authors.authorID=%d", author.getAuthorID());
        final String DELETE_AUTHOR_ISBN = String.format(
                "DELETE FROM authorISBN"
                + " WHERE authorISBN.authorID=%d", author.getAuthorID());
        
        connection.createStatement().executeUpdate(DELETE_AUTHOR_ISBN);
        connection.createStatement().executeUpdate(DELETE_AUTHOR);
    }
}
