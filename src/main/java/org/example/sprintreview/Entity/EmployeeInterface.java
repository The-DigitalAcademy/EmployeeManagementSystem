package org.example.sprintreview.Entity;


import org.example.sprintreview.Model.Employee;

import java.util.List;

public interface EmployeeInterface {
    public List<Employee> getEmployees( );
    public Employee getSingleEmployee(int employeeId);
    public Employee addNewEmployee(Employee employee);
    public List<Employee> deleteEmployee(int employeeId);
}

