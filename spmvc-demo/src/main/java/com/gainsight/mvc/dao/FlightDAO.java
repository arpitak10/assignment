package com.gainsight.mvc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.gainsight.mvc.entity.Flight;

@Repository
public class FlightDAO {
	private static String url = "jdbc:mysql://localhost:3306/gain"; 
	public ArrayList<Flight> searchFlight(String src,String dest) {
		ArrayList<Flight> flist = new ArrayList<>();
		
		Connection con = null ;
		PreparedStatement pst = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url,"root","Arpitak@10");
			pst = con.prepareStatement("select * from Flight where source = ? and destination = ?");
			pst.setString(1,src);
			pst.setString(2, dest);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) 
				flist.add(new Flight(rs.getString(1),rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getInt(5)));

		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		finally {
			try {
				if(pst!=null) pst.close(); 
				if(con!=null) con.close();  
			}
			catch(Exception ex) {
				ex.printStackTrace();
			}
		}
		return flist;
	}
	
}
