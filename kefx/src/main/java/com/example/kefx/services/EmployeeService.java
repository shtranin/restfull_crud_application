package com.example.kefx.services;

import com.example.kefx.entity.DepartmentEntity;
import com.example.kefx.entity.EmployeeEntity;
import com.example.kefx.exceptions.EmployeeAlreadyExistException;
import com.example.kefx.exceptions.EmployeeNotFoundException;
import com.example.kefx.exceptions.InvalidIdException;
import com.example.kefx.repository.DepartmentRepo;
import com.example.kefx.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    private final EmployeeRepo repo;
    private final DepartmentRepo departmentRepo;
    @Autowired
    public EmployeeService(EmployeeRepo repo, DepartmentRepo departmentRepo) {
        this.repo = repo;
        this.departmentRepo = departmentRepo;
    }

    public ResponseEntity registration(EmployeeEntity employeeEntity,Long id) {
        if (repo.findByName(employeeEntity.getName()) != null) {
            return ResponseEntity.badRequest().body("Employee already exist");
        }
        if (departmentRepo.existsById(id)){
            employeeEntity.setDepartment(departmentRepo.findById(id).get());
        }
        repo.save(employeeEntity);
        return ResponseEntity.ok().body("employee saves");
    }

    public ResponseEntity getEmployee(Long id) {
        if(id == null){
            ResponseEntity.badRequest().body("Invalid id");
        }
        EmployeeEntity employeeEntity;
        if(repo.findById(id).isPresent()){
             employeeEntity = repo.findById(id).get();
        }else{
           return ResponseEntity.badRequest().body("Such employee is not found");
        }
        return ResponseEntity.ok().body(employeeEntity);
    }


    public ResponseEntity deleteEmployee(Long id) {
        if(id == null){
            return ResponseEntity.badRequest().body("Invalid id");
        }
        if(repo.findById(id).isPresent()){
            repo.deleteById(id);
            return ResponseEntity.ok("Employee deleted");
        }else{
            return ResponseEntity.badRequest().body("Such employee is not found");
        }
    }
}

