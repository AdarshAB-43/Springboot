package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import com.example.demo.model.PhoneModel;

public interface PhoneRepository
        extends CrudRepository<PhoneModel, Integer> {

}