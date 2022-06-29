//Q3 Write a jdbc program to explain usage of transactions.
import java.sql.*;  
class FetchRecords{  
	public static void main(String args[])throws Exception{  
		Class.forName("oracle.jdbc.driver.OracleDriver");  
		Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");  

		try{
		   conn.setAutoCommit(false);
		   Statement stmt = conn.createStatement();
		   String SQL = "INSERT INTO Employees  " +
						"VALUES (162, 131, 'Alice', 'Bob')";
		   x=1;
		   stmt.executeUpdate(SQL);  
		   Savepoint savepoint = conn.setSavepoint();
		   String SQL = "INSERTED IN Employees  " +
						"VALUES (17, 223, 'Ram', 'Raja')";
		   x=2;
		   stmt.executeUpdate(SQL);
		   conn.commit();
		}catch(SQLException se){
		   if(x==2) {
			  conn.rollback();
		   } else {
			  conn.rollback(savepoint);
		   }
		
		}
	}
}