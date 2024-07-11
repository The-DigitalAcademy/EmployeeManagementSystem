package com.shapersprint.CrudOperations.Repository;

import com.shapersprint.CrudOperations.Entity.EmployeeInterface;
import com.shapersprint.CrudOperations.Model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Repository
public class EmployeeRepository implements EmployeeInterface {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    //Get all the employees that are on the database

    @Override
    public List<Employee> getEmployees() {
        String sql = "SELECT * FROM employees";
        List<Employee> Employee = jdbcTemplate.query(sql,new BeanPropertyRowMapper<Employee>(Employee.class));
        return Employee;
    }


    // Get a single employee by ID
    @Override
    public int getSingleEmployee(int employeeId ) {

        String sql = "select * from employee where id = ?";


        return employeeId;


    }


    //Create a new employee
    @Override
    public Employee addNewEmployee(Employee employee) {

        Random random = new Random();
        int randomId = random.nextInt(1000);

        String sql = "INSERT INTO employees (id, name, surname, department, salary, isPermanent) VALUES (?,?,?,?,?,?)";
        int affectedRow = jdbcTemplate.update(sql, randomId, employee.getName(), employee.getSurname(), employee.getDepartment(), employee.getSalary(), employee.isPermanent());
        if(affectedRow > 0) {
            System.out.println("######### Employee added successfully");
            employee.setId(randomId);
            return employee;
        }
        System.out.println("######## Employee not added successfully");
        return null;
    }


    //Delete employee by ID
    @Override
    public List<Employee> deleteEmployee(int employeeId) {
        String sql = "DELETE FROM employees WHERE id = ?";
        int affectedRow = jdbcTemplate.update(sql, employeeId);
        if(affectedRow > 0) {

            System.out.println("######### Employee deleted successfully");
            return getEmployees();
        }
        System.out.println("######## Employee not added successfully");
        return null;
    }


    public Employee updateEmployee(Employee employee) {


        String sql = "UPDATE employees " +
                "SET name = 'Alfred' " +
                "WHERE id =" + employee.getId();

        int affectedRow = jdbcTemplate.update(sql);
        if (affectedRow > 0) {

            System.out.println("######### Employee updated successfully");
        }
        System.out.println("######### Employee not updated successfully");
        return employee;
    }
}
