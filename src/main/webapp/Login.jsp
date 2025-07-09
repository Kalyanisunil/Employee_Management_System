<!-- Login.jsp -->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login - EMS</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="container mt-5">

    <h2 class="text-center mb-4">Employee Management System - Login</h2>

    <form action="LoginServlet" method="post" class="mx-auto" style="max-width: 400px;">
        <div class="mb-3">
            <label for="email" class="form-label">Email address</label>
            <input type="email" name="email" class="form-control" id="email" required>
        </div>

        <div class="mb-3">
            <label for="password" class="form-label">Password</label>
            <input type="password" name="password" class="form-control" id="password" required>
        </div>

        <button type="submit" class="btn btn-primary w-100">Login</button>
    </form>

    <% 
        String error = (String) request.getAttribute("error");
        if (error != null) {
    %>
        <div class="alert alert-danger mt-3 text-center"><%= error %></div>
    <% } %>

</body>
</html>
