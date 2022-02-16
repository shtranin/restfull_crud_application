package com.example.kefx.services;

import com.example.kefx.entity.CompanyEntity;
import com.example.kefx.entity.DepartmentEntity;

import com.example.kefx.repository.CompanyRepo;
import com.example.kefx.repository.DepartmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {
    private final DepartmentRepo repo;
    private final CompanyRepo companyRepo;
    @Autowired
    public DepartmentService(DepartmentRepo repo, CompanyRepo companyRepo) {
        this.repo = repo;
        this.companyRepo = companyRepo;
    }

    public ResponseEntity registration(DepartmentEntity departmentEntity,Long id)  {
        if(repo.findByName(departmentEntity.getName()) != null){
            return ResponseEntity.badRequest().body("Department already exist");
        }
        departmentEntity.setCompany(companyRepo.findById(id).get());
        repo.save(departmentEntity);
        return ResponseEntity.ok().body("Department successfully saved");
    }

    public ResponseEntity getById(Long id) {
        if(id == null){
            return ResponseEntity.badRequest().body("Invalid id");
        }
        if(repo.existsById(id)){
                return ResponseEntity.ok().body(repo.findById(id).get());
        }
                return ResponseEntity.badRequest().body("No such department exist");
    }

    public ResponseEntity deleteById(Long id){
        if(id == null){
            return ResponseEntity.badRequest().body("Invalid id");
        }
        if(repo.existsById(id)){
            repo.deleteById(id);
            return ResponseEntity.ok().body("Department deleted");
        }
        return ResponseEntity.badRequest().body("No such department exist");
    }

}
