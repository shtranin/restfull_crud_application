package com.example.kefx.repository;

import com.example.kefx.entity.CompanyEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CompanyRepo extends CrudRepository<CompanyEntity, Long> {
    CompanyEntity findByName(String name);
}
