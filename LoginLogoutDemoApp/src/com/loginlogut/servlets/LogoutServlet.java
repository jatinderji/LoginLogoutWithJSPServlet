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

@WebServlet("/Logout")
public class LogoutServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
	
		
		HttpSession session = req.getSession();
		if(session!=null && session.getAttribute("un")!=null ) {
			session.invalidate();
			RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
			rd.include(req, resp);
			out.append("<b>Logout Successfully..</b>");
		}
		else {
			RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
			rd.include(req, resp);
			out.append("<b>You are already Logged Out</b>");
		}
		
	}
	
	
	
	
}
