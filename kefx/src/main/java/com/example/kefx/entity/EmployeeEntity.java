package com.example.kefx.entity;

import javax.persistence.*;
import java.util.Calendar;

@Entity
public class EmployeeEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private String name;
    private int salary;
    @ManyToOne
    @JoinColumn(name="department")
    private DepartmentEntity department;

    public EmployeeEntity() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public DepartmentEntity getDepartment() {
        return department;
    }

    public void setDepartment(DepartmentEntity department) {
        this.department = department;
    }
}


