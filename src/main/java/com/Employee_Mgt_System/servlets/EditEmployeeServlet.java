package com.Employee_Mgt_System.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Employee_Mgt_System.model.Employee;
import com.Employee_Mgt_System.util.DBConnection;

/**
 * Servlet implementation class EditEmployeeServlet
 */
@WebServlet("/EditEmployeeServlet")
public class EditEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditEmployeeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String idStr=request.getParameter("id");
		int id=Integer.parseInt(idStr);
		List<Employee> employeeList = new ArrayList<>();
	
		try(Connection conn=DBConnection.getConnection()) 
		{
			String sql="SELECT* FROM employee where id=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			 ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
           if(rs.next())
           {
        	   
        	   String name=rs.getString("name");
        	   String email=rs.getString("email");
        	   String department = rs.getString("department");
               String role = rs.getString("role");
               double salary = rs.getDouble("salary");
               Employee emp=new Employee(id,name,email,department,role,salary);
               request.setAttribute("emp",emp);
           
               
		}
           request.getRequestDispatcher("EditEmployee.jsp").forward(request, response);
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 int id = Integer.parseInt(request.getParameter("id"));
	        String name = request.getParameter("name");
	        String email = request.getParameter("email");
	        String department = request.getParameter("department");
	        String role = request.getParameter("role");
	        double salary = Double.parseDouble(request.getParameter("salary"));
	        
	        try(Connection conn=DBConnection.getConnection()) {
	        	String sql="UPDATE employee set name=?,email=?,department=?,role=?,salary=? where id=?";
	        	  PreparedStatement ps = conn.prepareStatement(sql);
	              ps.setString(1, name);
	              ps.setString(2, email);
	              ps.setString(3, department);
	              ps.setString(4, role);
	              ps.setDouble(5, salary);
	              ps.setInt(6, id);

	              int rowsUpdated = ps.executeUpdate();
	              if(rowsUpdated>0)
	              {
	            	  response.sendRedirect("ViewEmployeeServlet");
	              }
	              else {
	            	  response.getWriter().println("Update failed! Employee not found!");
	              }
	        } catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}

}
