package com.Employee_Mgt_System.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Employee_Mgt_System.util.DBConnection;

/**
 * Servlet implementation class DeleteEmployeeServlet
 */
@WebServlet("/DeleteEmployeeServlet")
public class DeleteEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteEmployeeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String idStr = request.getParameter("id");
	        
	        // 2. Convert to int
	        int id = Integer.parseInt(idStr);

	        try (Connection conn = DBConnection.getConnection()) {
	            String sql = "DELETE FROM employee WHERE id = ?";
	            PreparedStatement ps = conn.prepareStatement(sql);

	            // 3. Set the ID parameter
	            ps.setInt(1,id);

	            // 4. Execute update
	            ps.executeUpdate();

	            // 5. Redirect back to view page
	            response.sendRedirect("ViewEmployeeServlet");
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
