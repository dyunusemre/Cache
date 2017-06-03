package cachableobject;

public class Book extends CachableObject{
	
	private String bookName;

	public Book(String bookName){
		
		setLastAccesed(System.currentTimeMillis());	
		this.bookName = bookName;	
		
	}
	public String getBookName() {
		
		setLastAccesed(System.currentTimeMillis());		
		return bookName;
		
	}
	
	public void setBookName(String bookName) {
		
		this.setLastAccesed(System.currentTimeMillis());
		this.bookName = bookName;
		
	}
	
}
