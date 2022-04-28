package com.example.kefx.controller;

import com.example.kefx.entity.DepartmentEntity;
import com.example.kefx.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    private final DepartmentService service;
    @Autowired
    public DepartmentController(DepartmentService service) {
        this.service = service;
    }

    @GetMapping("/get")
        public ResponseEntity getById(@RequestParam Long id){
           return service.getById(id);
        }

    @PostMapping("/post")
    public ResponseEntity saveDepartment(@RequestBody DepartmentEntity departmentEntity,
                                         @RequestParam Long id){
             return service.registration(departmentEntity, id);
    }

    @DeleteMapping("/delete")
    public ResponseEntity deleteDepartment(@RequestParam Long id){
              return service.deleteById(id);
    }
}
