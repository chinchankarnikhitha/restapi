package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.register;
@Repository
public interface registerrepository extends CrudRepository<register, Integer>{

	register findByEmail(String email);



}