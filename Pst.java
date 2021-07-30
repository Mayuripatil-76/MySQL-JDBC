// Prepared Statement
import java.sql.*;
public class Pst 
{

	public static void main(String[] args) throws Exception
	{
		/*
		 * how to create a connection to the database via jdbc driver
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
		String q = "INSERT INTO datax VALUES (?,?) " ; 
		int id = 89 ; 
		String name = "divya" ; 
		
		Connection con = DriverManager.getConnection(url, username , password ) ; // create connection
		
		// create a prepared statement 
		PreparedStatement st = con.prepareStatement(q) ; 
		st.setInt(1, id);         // set first value 
		st.setString(2, name);    // set second value 
    
		// store the result of the query into resultset 
		int count = st.executeUpdate() ;// count is number of rows affected ; 
		System.out.println(count + "rows affected ");
		
		
		st.close();
		con.close(); 

	}

}
