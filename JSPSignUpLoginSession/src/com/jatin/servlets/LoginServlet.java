package com.jatin.servlets;

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
		resp.setContentType("text/html");
		
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		if(isValid(email, password)) {
			// Create a session
			HttpSession session = req.getSession();
			session.setAttribute("email", email);
			// It is a valid user
			RequestDispatcher rd = req.getRequestDispatcher("welcome.jsp");
			rd.forward(req, resp);
		}
		else {
			//It is invalid user
			RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
			rd.include(req, resp);
			out.append("<b>Invalid email or password</b>");
		}
		
		
	}
	
	private boolean isValid(String email, String password) {
		boolean result = false;
		final String q = "select * from student where email=? and password=?";
		
		// check from db user is valid or not
		try {	
			Class.forName("com.mysql.jdbc.Driver");
			
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jvdb?useSSL=false"
													,"root","1234");

			PreparedStatement pst = con.prepareStatement(q);
			pst.setString(1, email);
			pst.setString(2, password);
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
