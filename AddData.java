package jdbcDemo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class AddData {
	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Connection connection=null;
		Statement statement=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			connection =DriverManager.getConnection("jdbc:mysql://localhost:3307/school_information_system","root","");
			
			 statement=connection.createStatement();
			
			 String sql="INSERT INTO employee (full_name, address, contact_number,age) VALUES ('Arushi Bashyal','Palpa','0123456','21')";

			int isInserted=statement.executeUpdate(sql);
			if(isInserted==1) {
				System.out.println("Record Added Successfully");
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
