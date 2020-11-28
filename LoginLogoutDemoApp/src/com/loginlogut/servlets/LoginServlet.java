package com.loginlogut.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Login")
public class LoginServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		
		String un = req.getParameter("username");
		String up = req.getParameter("userpassword");
		
		if(isValid(un, up)) {
			// If user is valid
			// create a session
			HttpSession session = req.getSession();
			session.setAttribute("un", un);
			RequestDispatcher rd = req.getRequestDispatcher("profile.jsp");
			rd.forward(req, resp);
		}
		else{
			// Invalid User
			RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
			rd.include(req, resp);
			out.append("<b>Invalid Username or Password..</b>");
		}
		
		
	}
	
	
	private boolean isValid(String un, String up) {
		
		boolean result = false;
		
			// Check from db and set the result
		try {	
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jvdb?useSSL=false"
													,"root","1234");
			
			PreparedStatement pst = con.prepareStatement("select * from users where uname=? and upass=?");
			
			pst.setString(1,un);
			pst.setString(2,up);
			ResultSet rs = pst.executeQuery();
			if(rs.next())
				result = true;
			con.close();
		}
		catch (ClassNotFoundException e) {
			System.out.println("Class not found error: "+e.getMessage());
		}
		catch (SQLException e) {
			System.out.println("SQL error: "+e.getMessage());
		}
		
		return result;
		
	}
	
	
}
