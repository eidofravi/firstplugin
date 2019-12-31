package com.test.controller;

import com.google.common.collect.Lists;
import com.test.model.Employee;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class SampleRestController {
    private static List<Employee> employeeList = Lists.newArrayList(new Employee("ravi", 111L),
            new Employee("toni", 222L),
            new Employee("mona", 333L)
    );

    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        System.out.println("Get all Employees...");
        return employeeList;
    }

    @GetMapping(value = "employee/{name}")
    public Employee findByName(@PathVariable String name) {
        Employee employee1 = employeeList.stream().filter(employee -> employee.getFirstName().equals(name)).findAny().orElse(null);
        return employee1;
    }

    @GetMapping(value = "employee")
    public Employee findById(@RequestParam(name = "id")  Long employeeId) {
        Employee employee1 = employeeList.stream().filter(employee -> employee.getEmployeeId().equals(employeeId)).findAny().orElse(null);
        return employee1;
    }

    @PostMapping(value = "/employee/create")
    public List<Employee> createNewEmployee(@RequestBody Employee employee) {
        employeeList.add(employee);
        return employeeList;
    }

    @DeleteMapping("/employee/delete/{employeeId}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("employeeId") Long employeeId) {
        System.out.println("Delete Employee with ID = " + employeeId + "...");
        employeeList.removeIf(item -> item.getEmployeeId().equals(employeeId));
        return new ResponseEntity<>("Employee has been deleted!", HttpStatus.OK);
    }

    @DeleteMapping("/employee/delete")
    public ResponseEntity<String> deleteAllCustomers() {
        System.out.println("Delete All Employee...");
        employeeList.clear();
        return new ResponseEntity<>("All Employee have been deleted!", HttpStatus.OK);
    }

    @PutMapping("/employee/{employeeId}")
    public ResponseEntity<Employee> updateCustomer(@PathVariable("employeeId") Long employeeId, @RequestBody Employee employee) {
        System.out.println("Update Employee with ID = " + employeeId + "...");
        Optional<Employee> employee1 = employeeList.stream().filter(item -> item.getEmployeeId().equals(employeeId)).findAny();

        if (employee1.isPresent()) {
            employee1.get().setFirstName(employee.getFirstName());
            return new ResponseEntity(employee1, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
