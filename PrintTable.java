// print the table from the database 
import java.sql.*;
public class PrintTable 
{

	public static void main(String[] args) throws Exception
	{
		/*
		 * This java program shows how to create a connection to the database via jdbc driver
		 *  
		 * 
		 * 1.load and register the driver 
		 * 2.create connection 
		 * 3.create a statement 
		 * 4.execute the statement
		 */
		
		
		// 1. load and register the driver 
		// driver is loaded by default , hence there is no need to load it 
		//Class.forName("com.mysql.jdbc.Driver") ; 
		
		// 2. Create connection 
		// getConnection is a method of class DriverManager with parameters url , username , password
		
		String url = "jdbc:mysql://localhost:3306/demo" ; // store the parameters into string 
		String username = "root" ; 
		String password = "" ; 
		String q = "SELECT * FROM datax" ; 
		
		Connection con = DriverManager.getConnection(url, username , password ) ; 
		
		// create a statement 
		Statement st = con.createStatement() ; 
		
		// store the result of the query into resultset 
		ResultSet rs = st.executeQuery(q) ;
		
		rs.next() ;
		
		while( rs.next())
		{
			System.out.println( rs.getInt(1) + " " + rs.getString(2));
		}
		
		st.close();
		con.close(); 

	}

}
