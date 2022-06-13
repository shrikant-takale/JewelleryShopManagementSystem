
import java.sql.*;  

public class DbConnection {
	   static Connection conn = null;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		getConnection();
	}
	
	public static Connection getConnection() {
	      if (conn != null) return conn;
	      String database = "jewelleryshopmanagement";
	      String Username = "root";
	      String password = "shrikant@123";
	      return getConnection(database, Username, password);
	   }
	public static Connection getConnection(String databaseName, String UserName, String password)
	{
		try{  
			Class.forName("com.mysql.cj.jdbc.Driver");  
			//mysql@localhost:3306
	         conn = DriverManager.getConnection("jdbc:mysql://localhost/" + databaseName + "?user=" + UserName + "&password=" + password);
	         System.out.println("connection Successful");
		}catch(Exception e)
		{
		         e.printStackTrace();
		}
		return conn;
	}

}
