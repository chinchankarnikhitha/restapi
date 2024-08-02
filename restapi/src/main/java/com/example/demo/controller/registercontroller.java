package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.register;
import com.example.demo.services.registerservice;


@RestController//connection for postman
@RequestMapping("/api/v1")//v1=>version
@CrossOrigin("http://localhost:4200")
public class registercontroller {

	
	@Autowired
	registerservice service;
	@PostMapping("/insert")
	public register insert(@RequestBody register reg) {//requestbody=>
		return service.insert(reg);
	}
	@PostMapping("/reginsert")
	public Iterable<register> reginsert(@RequestBody List<register> reg) {//reginsert is a name given 
		return service.insertall(reg);
	}
	@GetMapping("/getall")
	public List<register> getall(){
	  return service.getall();
	}
	@GetMapping("/getbyid/{id}")
	public Optional<register> getbyid(@PathVariable int id) {
		return service.getbyId(id);//change as optional
	}
	 @GetMapping("/findByemail/{email}")
	public register findByemail(@PathVariable String email) {
		return service.getbyEmail(email);
	}
	@DeleteMapping("/deletebyid/{id}")
	public String deletebyId(@PathVariable int id) {
		return service.deletebyId(id);
	}
	@PutMapping("/update")
	public register updateAll(@RequestBody register reg){
		return service.updateAll(reg);
	}
 }
