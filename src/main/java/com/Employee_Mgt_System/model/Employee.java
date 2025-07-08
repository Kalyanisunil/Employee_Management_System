package com.Employee_Mgt_System.model;

public class Employee {
    private int id;
    private String name;
    private String email;
    private String department;
    private String role;
    private double salary;

    public Employee( int id, String name, String email, String department, String role, double salary) {
    	this.id=id;
       
        this.name = name;
        this.email = email;
        this.department = department;
        this.role = role;
        this.salary = salary;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getDepartment() { return department; }
    public String getRole() { return role; }
    public double getSalary() { return salary; }


    public void setName(String name) { this.name = name; }
    public void setEmail(String email) { this.email = email; }
    public void setDepartment(String department) { this.department = department; }
    public void setRole(String role) { this.role = role; }
    public void setSalary(double salary) { this.salary = salary; }
}
