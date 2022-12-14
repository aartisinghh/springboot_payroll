package com.springboot_payroll.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name="employees")
public class employee {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="f_name", nullable = false)
	private String f_name;
	
	@Column(name="l_name")
	private String l_name;
	
	@Column(name="role")
	private String role;

	public employee(String firstName, String lastName, String role) {
	    this.f_name = firstName;
	    this.l_name = lastName;
	    this.role = role;
	  }

	
	

}
