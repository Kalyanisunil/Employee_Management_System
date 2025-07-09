package com.Employee_Mgt_System.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Employee_Mgt_System.util.DBConnection;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 String username = request.getParameter("email");
	        String password = request.getParameter("password");
	        try(Connection conn = DBConnection.getConnection())
	        {
	        	String sql="select * from users where email=? and password=?";
	        	PreparedStatement ps = conn.prepareStatement(sql);
	        	ps.setString(1, username);
	        	ps.setString(2, password);
	        	ResultSet rs=ps.executeQuery();
	        	if (rs.next()) {
	        	    // Successful login
	        	    HttpSession session = request.getSession();
	        	    session.setAttribute("user", username);
	        	    response.sendRedirect("home.jsp");
	        	} else {
	        	    // Login failed
	        	    request.setAttribute("error", "Invalid username or password");
	        	    request.getRequestDispatcher("Login.jsp").forward(request, response);
	        	}
	        } catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	}

}
