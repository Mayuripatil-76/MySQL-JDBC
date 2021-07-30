import java.sql.*;
public class Democlass 
{

	public static void main(String[] args) throws Exception
	{
		/*
		 * This java program shows how to create a connection to the database via jdbc driver 
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
		String query = " SELECT sname FROM datax WHERE sid = 29" ; 
		
		
		Connection con = DriverManager.getConnection(url, username , password ) ; 
		
		// create a statement 
		Statement st = con.createStatement() ; 
		
		// store the result of the query into resultset 
		ResultSet rs = st.executeQuery(query) ;
		rs.next() ; 
		String name = rs.getString(1) ; 
		System.out.println(name);
		
		st.close();
		con.close(); 

	}

}
