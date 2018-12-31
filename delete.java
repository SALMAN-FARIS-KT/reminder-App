package reminder;
import java.net.ConnectException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;
import java.sql.Statement;

public class Delremind {
	public static void main(String[] args)
	{
		Scanner in= new Scanner(System.in);
		int id= 0;
		//String query= "insert into List values(?,?,?,?)";
		System.out.print("Enter the Id of the reminder to be deleted..:");
		id= in.nextInt();

		System.out.println("Entered ID to delete: "+id);
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3300/Delrem","root","");
			System.out.println("here");
			java.sql.Statement st= con.createStatement();
			java.sql.Statement st1= con.createStatement();
			String q= "delete from DelRem where e_id= "+id;
			int check= st1.executeUpdate(q);
			System.out.println("St1: "+check);
			if(check == 1)
			{
				System.out.println("Deletion was Succesfull: !!");
				
			}
			else
				System.out.println("Invalid Input..!!");
			ResultSet rs= st.executeQuery("select * from DelRem"); 
			while (rs.next()) {
				System.out.println("Done");
			    System.out.println(rs.getString(2)); 
			}
			
			con.close();
		}
		catch (Exception e) {
			// TODO: handle exception
		}
	}

}
