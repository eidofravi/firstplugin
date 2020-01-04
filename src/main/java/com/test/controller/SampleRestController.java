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
    private static List<Employee> employeeList = Lists.newArrayList(
            new Employee("ravi", 111L),
            new Employee("toni", 222L),
            new Employee("mona", 333L)
    );
    //http://localhost:8081/api/employees
    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        System.out.println("Get all Employees...");
        return employeeList;
    }

    // http://localhost:8081/api/employee/ravi
    @GetMapping(value = "employee/{name}")
    public Employee findByName(@PathVariable String name) {
        Employee employee1 = employeeList.stream().filter(employee -> employee.getFirstName().equals(name)).findAny().orElse(null);
        return employee1;
    }

    //http://localhost:8081/api/employee?id=111
    @GetMapping(value = "employee")
    public Employee findById(@RequestParam(name = "id")  Long employeeId) {
        Employee employee1 = employeeList.stream().filter(employee -> employee.getEmployeeId().equals(employeeId)).findAny().orElse(null);
        return employee1;
    }

    //http://localhost:8081/api/employee/create
    //{"firstName":"supriya","employeeId":444}
    // method type = POST
    @PostMapping(value = "/employee/create")
    public List<Employee> createNewEmployee(@RequestBody Employee employee) {
        employeeList.add(employee);
        return employeeList;
    }

    //http://localhost:8081/api/employee/delete/111
    // method type = DELETE
    @DeleteMapping("/employee/delete/{employeeId}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("employeeId") Long employeeId) {
        System.out.println("Delete Employee with ID = " + employeeId + "...");
        employeeList.removeIf(item -> item.getEmployeeId().equals(employeeId));
        return new ResponseEntity<>("Employee has been deleted!", HttpStatus.OK);
    }

    //http://localhost:8081/api/employee/delete
    // method type = DELETE
    @DeleteMapping("/employee/delete")
    public ResponseEntity<String> deleteAllCustomers() {
        System.out.println("Delete All Employee...");
        employeeList.clear();
        return new ResponseEntity<>("All Employee have been deleted!", HttpStatus.OK);
    }

    //http://localhost:8081/api/employee/111
    //{"firstName":"supriya","employeeId":111}
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
