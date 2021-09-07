package Book;

public class Book {
	int Bookid;
	String Bookname;
	String Bookauthor;
	int Bookcost;
	String Booktype;
	int Bookedition;
	public int getBookid() {
		return Bookid;
	}
	public void setBookid(int bookid) {
		Bookid = bookid;
	}
	public String getBookname() {
		return Bookname;
	}
	public void setBookname(String bookname) {
		Bookname = bookname;
	}
	public String getBookauthor() {
		return Bookauthor;
	}
	public void setBookauthor(String bookauthor) {
		Bookauthor = bookauthor;
	}
	public int getBookcost() {
		return Bookcost;
	}
	public void setBookcost(int bookcost) {
		Bookcost = bookcost;
	}
	public String getBooktype() {
		return Booktype;
	}
	public void setBooktype(String booktype) {
		Booktype = booktype;
	}
	public int getBookedition() {
		return Bookedition;
	}
	public void setBookedition(int bookedition) {
		Bookedition = bookedition;
	}
	@Override
	public String toString() {
		return "Book [Bookid=" + Bookid + ", Bookname=" + Bookname + ", Bookauthor=" + Bookauthor + ", Bookcost="
				+ Bookcost + ", Booktype=" + Booktype + ", Bookedition=" + Bookedition + "]";
	}


}