package com.gainsight.mvc.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import org.springframework.stereotype.Repository;
@Repository
public class PassengerDAO {
	
	private static String url="jdbc:mysql://localhost:3306/gain";
	public boolean addPassenegrDetails(String passengerId,String firstName,String lastName,long mobile,String email)
	{
		
	int count=0;
		Connection con=null;
		PreparedStatement pst=null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection(url,"root","Arpitak@10");
			pst=con.prepareStatement("insert into passengers values(?,?,?,?,?)");
			pst.setString(1, passengerId);
			pst.setString(2, firstName);
			pst.setString(3, lastName);
			pst.setLong(4, mobile);
			pst.setString(5, email);
			count=pst.executeUpdate();
	}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			try
			{
				if(pst!=null) pst.close();
				if(con!=null) con.close();
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
		}
		return count==1;
	}
}