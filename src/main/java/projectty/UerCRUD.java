package projectty;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UerCRUD 

{
	
	public void Signup(User u) throws Exception
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3307/testyantra","root","root");
		PreparedStatement ps=conn.prepareStatement("Insert into signup values(?,?,?,?,?,?,?,?)");
		
		ps.setInt(1, u.getSlno());
		ps.setString(2, u.getFirst_name());
		ps.setString(3, u.getLast_name());
		ps.setString(4, u.getGender());
		ps.setLong(5, u.getPhone());
		ps.setString(6, u.getDOB());
		ps.setString(7, u.getEmail());
		ps.setString(8, u.getPassword());
		
		ps.execute();
		conn.close();
		
		System.out.println("Data inserted");	
	}
	
	public boolean Login(String email,String password) throws Exception
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3307/testyantra","root","root");
		
		PreparedStatement ps=connection.prepareStatement("select * from signup where email=?");
		ps.setString(1, email);
		
		
		ResultSet rs=ps.executeQuery();
		
		while(rs.next())
		{	

			
			if(rs.getString(7).equals(email))
			{
				if(rs.getString(8).equals(password))
				{
					
					
					System.out.println(rs.getInt(1)+"   \n"+rs.getString(2)+"    \n"+rs.getString(3)+"    \n"+rs.getString(4)+"   \n"+rs.getLong(5)+"    \n"+rs.getString(6)+"     \n"+rs.getString(7)+"     \n"+rs.getString(8));

					return true;

				}
				else
				{
						return false;
				}
			}
			


		}
		

		connection.close();
		return false;
		
		
		
	}
	
		public void Status(String email) throws Exception
		{	
			
			Feedback f=new Feedback();
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3307/testyantra","root","root");
			
			PreparedStatement ps1=connection.prepareStatement("Select * from signup where email=?");
			ps1.setString(1, email);
			ResultSet rs=ps1.executeQuery();
			while(rs.next())
			{
				
		PreparedStatement	ps=connection.prepareStatement("Insert into status value(?,?,?)");
			ps.setInt(1, rs.getInt(1));
			ps.setString(2, rs.getString(7));
			ps.setString(3,f.getFeedback());
			
			ps.execute();
			}
			connection.close();

		}

}
