package test;

import java.util.ArrayList;

import cachableobject.Book;
import cache.MergeCache;
import cache.*;
import database.Database;

public class Librarian {

	private Database bookDatabase;
	public Cache<String,Book> bookCache; 
	public int HitRatio;
	private float miss;
	private float hit;
	public float setOperationTime;
	public float getOperationTime;
	
	
	public Librarian(Cache<String,Book> cacheStrategy){
		this.bookDatabase = new Database();
		this.bookCache = cacheStrategy;
	}
	
	
	public float getHitRatio() {
		return (hit/(miss+hit));
	}
	public float getAvgGetOperationTime() {
		return getOperationTime/miss+hit;
	}
	public float getAvgSetOperationTime() {
		return setOperationTime/miss+hit;
	}
	public String getBookFromDatabase(String bookId) throws InterruptedException{
		
		String bookName = this.checkCache(bookId);
		if(bookName == null){			
			long startTime;			
			bookName = this.bookDatabase.getBookName(bookId);								
			startTime = System.nanoTime();
			this.bookCache.put(bookId, new Book(bookName));
			this.setOperationTime += System.nanoTime() - startTime;			
			miss++;
			
		}		
		return bookName;		
	}
	public String checkCache(String key) throws InterruptedException{
		
		String bookName = null;				
		if(bookCache.contains(key)){			
			long startTime = System.nanoTime();		
			Book book = (Book) bookCache.get(key);		
			bookName = book.getBookName();	
			System.out.println("HIT!");
			this.getOperationTime += System.nanoTime() - startTime;
			hit++;
		}		
		return bookName;		
	}

}
