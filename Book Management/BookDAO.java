package Book;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Book.Book;

public class BookDAO implements BookImplement{

	@Override
	public Connection getConnection() {
		Connection con=null;
			try {
				Class.forName(driverclass);
				con=DriverManager.getConnection(jdbcurl,username,password);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return con;
	}

	@Override
	public void insertBook(Book e) {
		// TODO Auto-generated method stub
		
		String query="insert into Book values(?,?,?,?,?,?)";
		try(Connection con=getConnection())
		{
			PreparedStatement ps=con.prepareStatement(query);
			ps.setInt(1, e.getBookid());
			ps.setString(2, e.getBookname());
			ps.setString(3, e.getBookauthor());
			ps.setInt(4, e.getBookcost());
			ps.setString(5, e.getBooktype());
			ps.setInt(6, e.getBookedition());
			ps.executeUpdate();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
				
		
	}

	@Override
	public Book selectBook(int id) {
		// TODO Auto-generated method stub
		Book e=null;
		String query="select * from Book where Bookid=?";
		try(Connection con=getConnection())
		{
			
			PreparedStatement ps=con.prepareStatement(query);
            ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				e=new Book();
				e.setBookid(id);
				e.setBookname(rs.getString(2));
				e.setBookauthor(rs.getString(3));
				e.setBookcost(rs.getInt(4));
				e.setBooktype(rs.getString(5));
				e.setBookedition(rs.getInt(6));
	
			}
		} catch (NullPointerException | SQLException e1) {
			e1.printStackTrace();
		}
		return e;
	}

	@Override
	public List<Book> selectAllBook() {
		 List<Book> list=new ArrayList();
		 String query="select * from Book";
		 try(Connection con=getConnection()){
			 PreparedStatement ps=con.prepareStatement(query);
			 ResultSet rs=ps.executeQuery();
			 while(rs.next())
				{
				    Book e=new Book();
					e.setBookid(rs.getInt(1));
					e.setBookname(rs.getString(2));
					e.setBookauthor(rs.getString(3));
					e.setBookcost(rs.getInt(4));
					e.setBooktype(rs.getString(5));
					e.setBookedition(rs.getInt(6));
					
					list.add(e);
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return list;
	}


@Override
	public boolean deleteBook(int id) {
		// TODO Auto-generated method stub
		boolean Result=false;
		String query="delete from Book where Bookid=?";
		try(Connection con=getConnection())
		{
			
			PreparedStatement ps=con.prepareStatement(query);
			ps.setInt(1, id);
			Result = ps.executeUpdate()>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Result;
	}

@Override
public boolean updateBook(Book e) {
	// TODO Auto-generated method stub
	boolean Result=false;
	String query="update Book set Bookname=?,Bookauthor=?,Bookcost=?,Booktype=?,Bookedition=? where Bookid=?" ;
	try(Connection con=getConnection())
	{
		
		PreparedStatement ps=con.prepareStatement(query);
		ps.setString(1, e.getBookname());
		ps.setString(2,e.getBookauthor());
		ps.setInt(3, e.getBookcost());
		ps.setString(4, e.getBooktype());
		ps.setInt(5, e.getBookedition());
		ps.setInt(6, e.getBookid());
		
		Result = ps.executeUpdate()>0;
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	return Result;
}


}