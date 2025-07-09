<%@ page import="com.Employee_Mgt_System.model.Employee" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Edit Employee</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body class="container mt-5 mx-auto">
    <h2>Edit Employee</h2>
    <form action="EditEmployeeServlet" method="post">
       <%
   			 Employee emp = (Employee) request.getAttribute("emp");
		%>
         <input type="hidden" name="id" value="<%= emp.getId() %>" />

<div class="mb-3">
    <label class="form-label">Name</label>
    <input type="text" name="name" class="form-control" value="<%= emp.getName() %>" required />
</div>

<div class="mb-3">
    <label class="form-label">Email</label>
    <input type="email" name="email" class="form-control" value="<%= emp.getEmail() %>" required />
</div>

<div class="mb-3">
    <label class="form-label">Department</label>
    <input type="text" name="department" class="form-control" value="<%= emp.getDepartment() %>" required />
</div>

<div class="mb-3">
    <label class="form-label">Role</label>
    <input type="text" name="role" class="form-control" value="<%= emp.getRole() %>" required />
</div>

<div class="mb-3">
    <label class="form-label">Salary</label>
    <input type="number" name="salary" class="form-control" value="<%= emp.getSalary() %>" required />
</div>

<button type="submit" class="btn btn-primary">Update Employee</button>
<a href="ViewEmployeeServlet" class="btn btn-danger">Cancel</a>

         
    </form>
</body>
</html>
