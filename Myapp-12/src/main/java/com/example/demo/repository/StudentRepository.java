package com.example.demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.StudentModel;

public interface StudentRepository extends CrudRepository<StudentModel, Integer> {

    List<StudentModel> findByNameContaining(String name);

}