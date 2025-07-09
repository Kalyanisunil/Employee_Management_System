<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Add Employee</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

    <div class="container d-flex justify-content-center align-items-center" style="height: 100vh;">
        <div class="card shadow p-4" style="width: 100%; max-width: 500px;">
            <h3 class="text-center mb-4">Add New Employee</h3>
            
            <form action="add" method="post">
                <div class="mb-3">
                    <label class="form-label">Name</label>
                    <input type="text" name="name" class="form-control" required />
                </div>

                <div class="mb-3">
                    <label class="form-label">Email</label>
                    <input type="email" name="email" class="form-control" required />
                </div>

                <div class="mb-3">
                    <label class="form-label">Department</label>
                    <input type="text" name="department" class="form-control" required />
                </div>

                <div class="mb-3">
                    <label class="form-label">Role</label>
                    <input type="text" name="role" class="form-control" required />
                </div>

                <div class="mb-3">
                    <label class="form-label">Salary</label>
                    <input type="number" name="salary" class="form-control" required />
                </div>

                <div class="d-grid gap-2">
                    <button type="submit" class="btn btn-primary">Add Employee</button>
                    <a href="home.jsp" class="btn btn-danger">Cancel</a>
                    <a href="home.jsp" class="btn btn-secondary">Back</a>
                </div>
            </form>
        </div>
    </div>

</body>
</html>
