package Book;

import java.util.List;
import java.util.Scanner;

import Book.Book;
import Book.BookDAO;

public class BookMain {

	public static void main(String[] args) {
		Book e=new Book();
		BookDAO eda=new BookDAO();
		int ch=0;
		Scanner sc=new Scanner(System.in);
		do
		{
			System.out.println("Welcome to Book Management");
			System.out.println("Choose From the Following Option");
			System.out.println("1. Add Book Details");
			System.out.println("2. Get Book Details");
			System.out.println("3. All Book Details");
			System.out.println("4. Delete Book");
			System.out.println("5. Update Book");
			System.out.println("6. Exit");
		    ch=sc.nextInt();
		switch(ch)
		{
		case 1:
			Book e1=new Book();
			System.out.println("Enter BookId");
			e1.setBookid(sc.nextInt());
			System.out.println("Enter BookName");
			e1.setBookname(sc.next());
			System.out.println("Enter BookAuthor");
			e1.setBookauthor(sc.next());
			System.out.println("Enter BookCost");
			e1.setBookcost(sc.nextInt());
			System.out.println("Enter BookType");
			e1.setBooktype(sc.next());
			System.out.println("Enter BookEdition");
			e1.setBookedition(sc.nextInt());
		
			eda.insertBook(e1);
			System.out.println("Data Inserted Successfully");
			break;
		case 2:
			System.out.println("Enter BookId");
			int id=sc.nextInt();
			
			e=eda.selectBook(id);
			if(e!=null)
			{
			System.out.println(e.getBookid()+" | "+e.getBookname()+" | "+e.getBookauthor()+" | "+e.getBookcost()+" | "+e.getBooktype()+" | "+e.getBookedition());
			}
			else
			{
				System.out.println("BookId Doesn't Exists");
			}
			break;
		case 3:
			List<Book> e2=eda.selectAllBook();
			for(Book b:e2)
			{
				System.out.println(b);
			}
			break;
		case 4 :
		{
			System.out.println("Enter BookId");
			int id1=sc.nextInt();
			boolean res=eda.deleteBook(id1);
			if(res)
			{
				System.out.println("Deleted Succesfully");
			}
			else
			{
				System.out.println("The ID is not Present");
			}
			break;
		}
		case 5 :
			boolean res1=false;
			Book e3=new Book();
			System.out.println("Enter BookId");
			e3.setBookid(sc.nextInt());
			System.out.println("Enter BookName");
			e3.setBookname(sc.next());
			System.out.println("Enter BookAuthor");
			e3.setBookauthor(sc.next());
			System.out.println("Enter BookCost");
			e3.setBookcost(sc.nextInt());
			System.out.println("Enter BookType");
			e3.setBooktype(sc.next());
			System.out.println("Enter BookEdition");
			e3.setBookedition(sc.nextInt());
			res1=eda.updateBook(e3);
			if(res1)
			{
				System.out.println("Updated Succesfully");
			}
			else
			{
				System.out.println("UserName Doesn't Exist");
			}
			break;
			
			case 6:
				System.out.println("Goodbyee");
				break;
			default:
				System.out.println("Enter a Correct Option");
				break;
		}
		
		}while(ch!=6);
			
		}
}