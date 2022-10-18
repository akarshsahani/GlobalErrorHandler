package com.example.demo.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private int age;
	private String pNumber;
	private Long MobNumber;
	@Column(unique = true)
	private String email;
	private BigDecimal salary;
	private String gender;
	
	
	public User() {
		super();
	}


	public User(Long id, String name, int age, String pNumber, Long mobNumber, String email, BigDecimal salary,
			String gender) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.pNumber = pNumber;
		MobNumber = mobNumber;
		this.email = email;
		this.salary = salary;
		this.gender = gender;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
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
