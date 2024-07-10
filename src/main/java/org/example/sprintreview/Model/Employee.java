package org.example.sprintreview.Model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Employee {
        private int id;
        private String name;
        private String surname;
        private String department;
        private double salary;
        private boolean isPermanent;

}




