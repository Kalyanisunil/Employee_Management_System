<%@ page import="java.util.*, com.Employee_Mgt_System.model.Employee" %>
<!DOCTYPE html>
<html>
<head>
    <title>Employee List</title>
    
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

    <div class="container mt-4">
       <center> <h2 >All Employees</h2></center>

        <!-- Java code to get the list from request -->
        <%
            List<Employee> list = (List<Employee>) request.getAttribute("empList");
        %>

        <!-- Bootstrap table start -->
        <table class="table table-striped">
            <thead>
               		 <th>S.no</th>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Email</th>
                    <th>Department</th>
                    <th>Role</th>
                    <th>Salary</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                <!-- Start Java for-each loop -->
                <%
                	int serial=1;
                    for (Employee emp : list) {
                %>
                <tr>
                 <td><%= serial++ %></td>
                    <td><%= emp.getId() %></td>
                    <td><%= emp.getName() %></td>
                    <td><%= emp.getEmail() %></td>
                   <td><%= emp.getDepartment() %></td>
                    
                    <td><%= emp.getRole() %></td>
                    <td><%= emp.getSalary() %></td>
                    <td>
					    <a href="EditEmployeeServlet?id=<%= emp.getId() %>" class="btn btn-primary btn-sm">Update</a> |
					    <a href="DeleteEmployeeServlet?id=<%= emp.getId() %>" class="btn btn-danger btn-sm">Delete</a>
					
					</td>
					                   
					 
                </tr>
                <%
                    } // end for loop
                %>
            </tbody>
        </table>
    </div>

</body>
</html>
