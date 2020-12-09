package com.jatin.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Register")
public class RegisterServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		PrintWriter out = resp.getWriter();
		resp.setContentType("text/html");
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		registerUser(name,email,password);
		
		RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
		rd.include(req, resp);
		out.append("<b>Register Successfully</b>");
		
	}
	
	private void registerUser(String name, String email, String password) {

		final String q = "insert into student values(?,?,?)";
		// Register into db a user 
		try {	
			Class.forName("com.mysql.jdbc.Driver");
			
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jvdb?useSSL=false"
													,"root","1234");

		PreparedStatement pst = con.prepareStatement(q);
		pst.setString(1, name);
		pst.setString(2, email);
		pst.setString(3, password);
		
		pst.executeUpdate();
	
		con.close();
		}
		catch (ClassNotFoundException e) {
			System.out.println("Class not found error: "+e.getMessage());
		}
		catch (SQLException e) {
			System.out.println("SQL error: "+e.getMessage());
		}
		
			
	}

}
