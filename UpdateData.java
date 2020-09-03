package jdbcDemo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateData {
	public static void main(String[] args) throws SQLException {
		Connection connection=null;
		Statement statement=null;
		
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		 connection =DriverManager.getConnection("jdbc:mysql://localhost:3307/school_information_system","root","");
		
		 statement=connection.createStatement();
		
	
		 String sql="UPDATE employee SET full_name=' Aalabhi Pandey',address='Butwal' ,contact_number='987654321',age='12' WHERE id=2";

		int isUpdated=statement.executeUpdate(sql);
		if(isUpdated==1) {
			System.out.println("Record updated Successfully");
		}

		
	}catch(ClassNotFoundException ex){
		System.out.println("Driver class could not be loaded");

	}catch(SQLException sqlEx) {
		System.out.println(" exception occured when carrying an SQL operation"+sqlEx.getMessage());

	}finally {
		if(connection!=null) {
			connection.close();
		}
	}

	}

}
