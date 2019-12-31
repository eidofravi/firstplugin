package com.test.model;

import lombok.Getter;
import lombok.Setter;

public class Employee {
    @Getter @Setter
    private String firstName;

    @Getter @Setter
    private Long employeeId;

    public Employee(String firstName, Long employeeId) {
        this.firstName = firstName;
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }
}
