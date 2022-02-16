package com.example.kefx.repository;

import com.example.kefx.entity.EmployeeEntity;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepo extends CrudRepository<EmployeeEntity,Long> {

    EmployeeEntity findByName(String name);
}
