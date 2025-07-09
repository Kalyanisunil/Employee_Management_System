<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>EMS - Home</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>


<nav class="navbar navbar-expand-lg navbar-dark bg-dark ">
    <div class="container-fluid">
        <a class="navbar-brand " href="#">🏢 EMS Dashboard</a>
    </div>
</nav>


<div class="container mt-5">

  
    <div class="text-center mb-4">
        <h1>Welcome to XYZ Solutions Pvt. Ltd.</h1>
        <p class="lead">Empowering HR management with efficiency</p>
    </div>

 
    <div class="row text-center">
        <div class="col-md-4">
            <div class="card text-bg-success mb-3">
                <div class="card-body">
                    <h5 class="card-title">Total Employees</h5>
                    <p class="card-text display-6">53</p>
                </div>
            </div>
        </div>

        <div class="col-md-4">
            <div class="card text-bg-info mb-3">
                <div class="card-body">
                    <h5 class="card-title">Departments</h5>
                    <p class="card-text display-6">4</p> 
                </div>
            </div>
        </div>
		 <div class="col-md-4">
            <div class="card text-bg-warning mb-3">
                <div class="card-body">
                    <h5 class="card-title">Gender Distribution</h5>
                   <p class="card-text display-6">👨 30 | 👩 23</p>
                </div>
            </div>
        </div>
		
      
    </div>


    <div class="text-center mt-4">
        <a href="ViewEmployeeServlet" class="btn btn-primary me-2">View Employees</a>
        <a href="AddEmployee.jsp" class="btn btn-success">Add Employee</a>
    </div>

</div>

</body>
</html>
