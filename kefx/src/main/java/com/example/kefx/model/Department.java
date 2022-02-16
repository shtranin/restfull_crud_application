package com.example.kefx.model;

import java.util.List;

public class Department {

    private long id;
    private String name;
    private Company company;
    private List<Employee> employees;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public Department(long id, String name, Company company, List<Employee> employees) {
        this.id = id;
        this.name = name;
        this.company = company;
        this.employees = employees;
    }

    public Department() {
    }
}
