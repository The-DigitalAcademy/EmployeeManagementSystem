package org.example.sprintreview.Controller;


import org.example.sprintreview.Entity.EmployeeInterface;
import org.example.sprintreview.Model.Employee;
import org.example.sprintreview.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

    @RestController
    public class EmployeeController implements EmployeeInterface {

        @Autowired
        private EmployeeService employeeService;

        @GetMapping("/employees")
        public List<Employee> getEmployees(){
            return employeeService.getEmployees();
        }

        @GetMapping("/employees/{employeeId}")
        public Employee getSingleEmployee(@PathVariable int employeeId){
            return employeeService.getSingleEmployee(employeeId);
        }

        @PostMapping("/employees")
        public Employee addNewEmployee(@RequestBody Employee employee){
            return employeeService.addNewEmployee(employee);
        }

        @DeleteMapping("/employees/{employeeId}")
        public List<Employee> deleteEmployee(@PathVariable int employeeId){
            return employeeService.deleteEmployee(employeeId);
        }

    }

