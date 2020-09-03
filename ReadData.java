package jdbcDemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ReadData {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection connection=null;
		Statement statement=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
				connection =DriverManager.getConnection("jdbc:mysql://localhost:3307/school_information_system","root","");
			
			 statement=connection.createStatement();
			
			String sql="SELECT * from employee";
			ResultSet resultSet=statement.executeQuery(sql);
			while(resultSet.next()) {
				System.out.println("Row ID:"+resultSet.getInt("id"));
				System.out.println("Full Name:"+resultSet.getString("full_name"));
				System.out.println("Address:"+resultSet.getString("address"));
				System.out.println("Contact Number:"+resultSet.getString("contact_number"));
				System.out.println("Age:"+resultSet.getInt("age"));

			}
			
		}catch(ClassNotFoundException ex){
			System.out.println("Class not found exception occured:"+ex.getMessage());

		}catch(SQLException sqlEx) {
			System.out.println("SQL exception occured:"+sqlEx.getMessage());

		}

	}

}
