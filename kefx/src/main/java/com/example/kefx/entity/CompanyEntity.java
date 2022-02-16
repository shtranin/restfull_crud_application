package com.example.kefx.entity;

import com.example.kefx.model.Company;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

@Entity
public class CompanyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private String name;
    @JsonIgnoreProperties({"company"})
    @OneToMany(mappedBy = "company",
            orphanRemoval = true,
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    private List<DepartmentEntity> departments;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<DepartmentEntity> getDepartments() {
        return departments;
    }

    public void setDepartments(List<DepartmentEntity> departments) {
        departments.forEach(a->a.setCompany(this));
        this.departments = departments;
    }

    public CompanyEntity(String name) {
        this.name = name;
    }

    public CompanyEntity() {
    }
    public Company toModel(){
        Company company = new Company();
        company.setId(this.id);
        company.setName(this.name);
        company.setDepartments(this.departments.stream().map(DepartmentEntity :: toModel).collect(Collectors.toList()));
        return company;
    }
}
