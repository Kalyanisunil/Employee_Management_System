package com.Employee_Mgt_System.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Employee_Mgt_System.model.Employee;
import com.Employee_Mgt_System.util.DBConnection;

/**
 * Servlet implementation class ViewEmployeeServlet
 */
@WebServlet("/ViewEmployeeServlet")
public class ViewEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewEmployeeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Employee> employeeList = new ArrayList<>();

        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT * FROM employee";
            PreparedStatement ps = conn.prepareStatement(sql);

            // Execute query
            ResultSet rs = ps.executeQuery();

            // Loop through results
            while (rs.next()) {
                // Create Employee object from result row
                Employee emp = new Employee(
                    rs.getInt("id"),           
                    rs.getString("name"),
                    rs.getString("email"),
                    rs.getString("department"),
                    rs.getString("role"),
                    rs.getDouble("salary")
                );
                employeeList.add(emp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Set employee list in request scope
        request.setAttribute("empList", employeeList);

        // Forward request to JSP page to display the employees
        RequestDispatcher rd = request.getRequestDispatcher("ViewEmployees.jsp");
        rd.forward(request, response);
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
