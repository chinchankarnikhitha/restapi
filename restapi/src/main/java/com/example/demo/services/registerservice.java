package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.models.register;
import com.example.demo.repository.registerrepository;

@Service
public class registerservice  {

	
	@Autowired  //to override the repository
	registerrepository repo;//repo is a name given for registerrepository
	
	public register insert(register reg) { //insert the data which u want to //insert(model name and name for model)(register reg)
		return repo.save(reg);//save for single detail// repo is repository detail which we want to send
	}
	
	public Iterable<register> insertall( @RequestBody List<register> reg) {//list=>java.util<model name> insertall=> name given 
		
		return repo.saveAll(reg);
	}
	@GetMapping("/getall")
	public List<register> getall(){
		
		return (List<register>) repo.findAll();
	}
	public Optional<register> getbyId(int id) {//optional ehile error 
		return repo.findById(id);
		}
	public register getbyEmail(String email) {
		return repo.findByEmail(email);//curd operation
	}
	//deletebyid
	public String deletebyId(int id) {
		 repo.deleteById(id );
		 return "successfully Deleted" + id ;
	}
	//update
	
	public register updateAll(register reg) { //
		int id = reg.getId();
		register regs = repo.findById(id).get();//object creation 
		regs.setId(reg.getId());//set-post get-fetch
		regs.setUsername(reg.getUsername());
		regs.setEmail(reg.getEmail());
		regs.setCreatepassword(reg.getCreatepassword());
		return repo.save(regs);//post
	}
}
