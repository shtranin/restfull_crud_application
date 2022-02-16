package com.example.kefx.services;

import com.example.kefx.entity.CompanyEntity;
import com.example.kefx.repository.CompanyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CompanyService {
    private final CompanyRepo repo;
    @Autowired
    public CompanyService(CompanyRepo repo) {
        this.repo = repo;
    }
    public ResponseEntity getById(Long id) {
        if(id == null){
            return ResponseEntity.badRequest().body("Invalid id");
        }
        if(repo.existsById(id)){
            return ResponseEntity.ok().body(repo.findById(id).get());
        }
        return ResponseEntity.badRequest().body("No such company exist");
    }

    public ResponseEntity registration(CompanyEntity companyEntity)  {
        if(repo.findByName(companyEntity.getName()) != null){
            return ResponseEntity.badRequest().body("Company already exist");
        }
        repo.save(companyEntity);
        return ResponseEntity.ok().body("Company successfully saved");
    }

    public ResponseEntity deleteById(Long id){
        if(id == null){
            return ResponseEntity.badRequest().body("Invalid id");
        }
        if(repo.existsById(id)){
            repo.deleteById(id);
            return ResponseEntity.ok().body("Company deleted");
        }
        return ResponseEntity.badRequest().body("No such company exist");
    }
}
