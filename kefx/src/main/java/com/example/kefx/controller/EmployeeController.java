package com.example.kefx.controller;

import com.example.kefx.entity.EmployeeEntity;
import com.example.kefx.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
   private final EmployeeService employeeService;

   @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @PostMapping
    public ResponseEntity saveEmployee(@RequestBody EmployeeEntity person,
                                       @RequestParam Long id){
       return employeeService.registration(person,id);

    }

    @GetMapping
    public ResponseEntity getEmployeeById(@RequestParam Long id){
            return employeeService.getEmployee(id);
    }

    @DeleteMapping
    public ResponseEntity deleteEmployeeById(@RequestParam Long id){
           return employeeService.deleteEmployee(id);
    }
}
