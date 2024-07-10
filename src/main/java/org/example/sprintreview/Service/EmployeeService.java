package org.example.sprintreview.Service;


import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    public class EmployeeService implements EmployeeInterface {

        @Autowired
        private EmployeeRepository employeeRepository;

        @Override
        public List<Employee> getEmployees() {
            return employeeRepository.getEmployees();
        }

        @Override
        public int getSingleEmployee(int employeeId) {
            return employeeRepository.getSingleEmployee(employeeId);
        }

        @Override
        public Employee addNewEmployee(Employee employee) {
            return employeeRepository.addNewEmployee(employee);
        }

        @Override
        public List<Employee> deleteEmployee(int employeeId) {
            return employeeRepository.deleteEmployee(employeeId);
        }
    }



}
