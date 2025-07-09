package com.Employee_Mgt_System.servlets;

import com.Employee_Mgt_System.util.DBConnection;
import com.Employee_Mgt_System.model.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

@WebServlet("/add")
public class AddEmployeeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
        	
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String department = request.getParameter("department");
            String role = request.getParameter("role");
            double salary = Double.parseDouble(request.getParameter("salary"));

            Employee emp = new Employee( 0, name, email, department, role, salary);

            try (Connection conn = DBConnection.getConnection()) {
                String sql = "INSERT INTO employee ( name, email, department, role, salary) VALUES (?, ?, ?, ?, ?)";
                PreparedStatement ps = conn.prepareStatement(sql);
           
                ps.setString(1, emp.getName());
                ps.setString(2, emp.getEmail());
                ps.setString(3, emp.getDepartment());
                ps.setString(4, emp.getRole());
                ps.setDouble(5, emp.getSalary());

                int rows = ps.executeUpdate();

                response.setContentType("text/html");
                PrintWriter out = response.getWriter();

                if (rows > 0) {
                    out.println("<h2>Employee Added Successfully!</h2>");
                } else {
                    out.println("<h2>Failed to Add Employee</h2>");
                }

                out.println("<a href='AddEmployee.jsp' class='btn btn-success'>Add Another</a><br>");
                out.println("<a href='ViewEmployeeServlet'>View All Employees</a>");
            }
        } catch (NumberFormatException e) {
            response.getWriter().println("<h3>Invalid ID or Salary input. Please enter correct numeric values.</h3>");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
