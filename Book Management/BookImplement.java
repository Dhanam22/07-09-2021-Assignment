package Book;

import java.sql.Connection;
import java.util.List;

import Book.Book;

public interface BookImplement {
	
	public static final String jdbcurl="jdbc:mysql://localhost:3306/Book";
	public static final String driverclass="com.mysql.cj.jdbc.Driver";
	public static final String username="Devi";
	public static final String password="Dhanam";
	
	Connection getConnection();
	void insertBook(Book e);
	Book selectBook(int id);
	List<Book> selectAllBook();
	boolean deleteBook(int Bookid);
	boolean updateBook(Book e);

}