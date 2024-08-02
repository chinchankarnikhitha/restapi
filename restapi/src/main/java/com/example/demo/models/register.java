package com.example.demo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity   //To create table using hibernate.

public class register {
	
	@Id// to generate a table in my sql
	@GeneratedValue(strategy = GenerationType.AUTO)//auto generation of id 
	private int id;
	private String username;//@size(max = 35,min = 3)for branch
	@Email
	private String email;
	private String createpassword;

}
