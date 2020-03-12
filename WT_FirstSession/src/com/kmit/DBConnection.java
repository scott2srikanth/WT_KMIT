package com.kmit;

import java.sql.*;

public class DBConnection {
	
	
	
	public static String myLogin(String dbdriver, String dburl, String dbuser,String dbpass,String username, String password,User u) {
		Connection con=null;
		try {
			Class.forName(dbdriver);
			con=DriverManager.getConnection(dburl,dbuser, dbpass);
			
			Statement st=con.createStatement();
			String sql="Select * from users where username='"+username+"' and password='"+password+"'";
			
			ResultSet rs=st.executeQuery(sql);
			if(rs!=null) {
				if(rs.next()) {
				  u.setEmail(rs.getString("email"));
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
