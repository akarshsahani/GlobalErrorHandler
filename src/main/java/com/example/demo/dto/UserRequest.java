package com.example.demo.dto;

import java.math.BigDecimal;

import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.UniqueElements;

public class UserRequest {

	@NotBlank(message = "Name cannot be blank")
	@NotEmpty(message = "Name cannot be empty")
	@NotNull(message = "Name cannot be null")
	private String name;
	
	@Min(18)
	@Max(65)
	private int age;
	
	@NotBlank(message = "pNumber cannot be blank")
	@NotEmpty(message = "pNumber cannot be empty")
	@NotNull(message = "pNumber cannot be null")
	@Size(min = 10, max = 10, message = "please enter valid phone number")
	private String pNumber;
	
//	@Size(max = 999999999, min = 1000000000, message = "Invalid Mobile Number")
	private Long MobNumber;
	
	@NotBlank(message = "email cannot be blank")
	@NotEmpty(message = "email cannot be empty")
	@NotNull(message = "email cannot be null")
	@Email(message = "Invalid Email")
	private String email;
	
	
	private BigDecimal salary;
	
	@Size(max = 1, message = "Please Enter only m or f")
	private String gender;
	
	
	public UserRequest() {
		super();
		// TODO Auto-generated constructor stub
	}


	public UserRequest(String name, int age, String pNumber, Long mobNumber, String email, BigDecimal salary,
			String gender) {
		super();
		this.name = name;
		this.age = age;
		this.pNumber = pNumber;
		MobNumber = mobNumber;
		this.email = email;
		this.salary = salary;
		this.gender = gender;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public String getpNumber() {
		return pNumber;
	}


	public void setpNumber(String pNumber) {
		this.pNumber = pNumber;
	}


	public Long getMobNumber() {
		return MobNumber;
	}


	public void setMobNumber(Long mobNumber) {
		MobNumber = mobNumber;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public BigDecimal getSalary() {
		return salary;
	}


	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
}
