package com.example.kefx.controller;

import com.example.kefx.entity.CompanyEntity;
import com.example.kefx.services.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/companies")
public class CompanyController {
    private final CompanyService service;
    @Autowired
    public CompanyController(CompanyService service) {
        this.service = service;
    }
    @GetMapping("/get")
    public ResponseEntity getById(@RequestParam Long id){
        return service.getById(id);
    }

    @PostMapping("/post")
    public ResponseEntity saveDepartment(@RequestBody CompanyEntity companyEntity){
        return service.registration(companyEntity);
    }

    @DeleteMapping("/delete")
    public ResponseEntity deleteDepartment(@RequestParam Long id){
        return service.deleteById(id);
    }


}
