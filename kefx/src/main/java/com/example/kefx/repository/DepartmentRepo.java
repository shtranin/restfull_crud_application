package com.example.kefx.repository;

import com.example.kefx.entity.DepartmentEntity;
import com.example.kefx.entity.EmployeeEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface DepartmentRepo extends CrudRepository<DepartmentEntity,Long> {

    DepartmentEntity findByName(String name);

}
