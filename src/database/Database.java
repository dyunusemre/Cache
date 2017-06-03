package database;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class Database {
	
	private Connection connection = null;
	private String databaseName = "bookdatabase";
	private String password = "";
	
	public Database(){
		
		try {			
			this.connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/"+databaseName,"root", password);			
		} catch (SQLException e) {			
			System.out.println("Connection Failed!");
			e.printStackTrace();				
		}
		if(connection != null){			
			System.out.println("Connection successfull");			
		}
		
	}

	public String getBookName(String key){
		
		String bookName = null;		
		String sql = "SELECT book_name FROM books WHERE id = " + key;
		try {
			
			Statement statement = (Statement) this.connection.createStatement();
			ResultSet result = statement.executeQuery(sql);			
			while(result.next()){				
				bookName = result.getString("book_name");				
			}
			
		} catch (SQLException e) {			
			System.out.println("Query problem!");
			e.printStackTrace();			
		}		 		
		return bookName;		
	}	
}
