package com.kmit;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: GET");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		
		String dbdriver=getServletContext().getInitParameter("JDBCDriver");
		String dburl=getServletContext().getInitParameter("JDBCUrl");
		String dbuser=getServletContext().getInitParameter("JDBCUser");
		String dbpass=getServletContext().getInitParameter("JDBCPassword");
			
		User u=new User();
		String dbResult=DBConnection.myLogin(dbdriver,dburl,dbuser,dbpass,username, password,u);
		
		
		PrintWriter out=response.getWriter();
		out.println("<html><head></head><body>");
		out.println("<h1>"+dbResult+"</h1");
		out.print("<p>"+u.getEmail()+"</p");
		out.print("</body></html>");
			

	}

}
