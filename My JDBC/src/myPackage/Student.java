package myPackage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Student {
	
	public void createDatabase() {

	try {
		
//		1. Connection establishing
		String url = "jdbc:mysql://localhost:3306/my_database";
		String username = "root";
		String password = "mysql@123";
		Connection conn = DriverManager.getConnection(url, username, password);
		
//		2. Creating statement
		Statement st = conn.createStatement();
		
//		3. Execute query
		String query = "create database newDb";
		st.execute(query);
		
		System.out.print("Database created ");
		
		
//      4. Connection close
		conn.close();
		
	}catch(Exception e) {
		e.printStackTrace();
		
	}
	}
	
	
	public void createTable() {
		try {
			String url = "jdbc:mysql://localhost:3306/newDb";
			Connection conn = DriverManager.getConnection(url, "root", "mysql@123");
			
			Statement st = conn.createStatement();
			
			String query = "create table student(sid int(5), name varchar(100), email varchar(100))";
			
			st.execute(query);
			System.out.print("Table created ");
			
			conn.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}


public void createData() {
	
	try {
		String url = "jdbc:mysql://localhost:3306/newDb";
		Connection conn = DriverManager.getConnection(url, "root", "mysql@123");
		
		Statement st = conn.createStatement();
		
		String query = "insert into student VALUES(2, 'Apple', 'apple@gmail.com')";
		
		st.execute(query);
		System.out.print("Data inserted ");
		
		conn.close();
		
	}catch(Exception e) {
		e.printStackTrace();
	}
	
	
}


public void readData() {
	
	try {
	String url = "jdbc:mysql://localhost:3306/newDb";
	Connection conn = DriverManager.getConnection(url, "root", "mysql@123");
	
	String query = "select * from student";

	Statement st = conn.createStatement();
	ResultSet rs = st.executeQuery(query);
//	st.execute(query);
	
	while(rs.next()) {
		System.out.println("Sid = " + rs.getInt(1));
		System.out.println("Name = " + rs.getString(2));
		System.out.println("Email = " + rs.getString(3));
		
	}
	
	System.out.print("Showing successfully");
	
	conn.close();
	
}catch(Exception e) {
	e.printStackTrace();
}
	
}


public void updateData() {
	
	try {
		String url = "jdbc:mysql://localhost:3306/newDb";
		Connection conn = DriverManager.getConnection(url, "root", "mysql@123");
		
		Statement st = conn.createStatement();
		
		String query = "update student set name = 'Apple Macbook air' where sid = '2' ";
		
		st.execute(query);
		System.out.print("Data updated ");
		
		conn.close();
		
	}catch(Exception e) {
		e.printStackTrace();
	}
	
}


public void deleteData() {
	try {
		String url = "jdbc:mysql://localhost:3306/newDb";
		Connection conn = DriverManager.getConnection(url, "root", "mysql@123");
		
		Statement st = conn.createStatement();
		
		String query = "DELETE FROM student where sid = '2' ";
		
		st.execute(query);
		System.out.print("Data deleted ");
		
		conn.close();
		
	}catch(Exception e) {
		e.printStackTrace();
	}
	
}


}
