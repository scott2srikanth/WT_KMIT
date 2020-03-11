package com.kmit;

import java.sql.*;

public class DBConnection {
	
	
	
	public static String myConnection(String username, String password) {
		Connection con=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/wt2020", 
					"root", 
					"17121981");
			
			
			Statement st=con.createStatement();
			String sql="Select * from users where username='"+username+"' and password='"+password+"'";
			
			ResultSet rs=st.executeQuery(sql);
			if(rs!=null) {
				if(rs.next()) {
				  System.out.println(rs.getString("email"));
				  return "Login Successful"; 
				}else
					return "Login failed"; 
			}
			else {
				return "Login failed"; 
			}
		}catch(Exception e) {
			e.printStackTrace();
			return "Connection Failed";
		}
		finally {
			try {
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
