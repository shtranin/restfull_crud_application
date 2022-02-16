package com.example.kefx.entity;

import com.example.kefx.model.Department;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
public class DepartmentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private String name;
    @JsonIgnoreProperties({"department"})
    @OneToMany(mappedBy = "department",
            orphanRemoval = true,
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<EmployeeEntity> employees;

    @ManyToOne
    @JoinColumn(name = "company")
    private CompanyEntity company;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<EmployeeEntity> getEmployees() {
        return employees;
    }

    public void setEmployees(List<EmployeeEntity> employees) {
        employees.forEach(a-> a.setDepartment(this));
        this.employees = employees;
    }
    public CompanyEntity getCompany() {
        return company;
    }

    public void setCompany(CompanyEntity company) {
        this.company = company;
    }

    public DepartmentEntity() {
    }
    public Department toModel(){
        return null;
    }

}
