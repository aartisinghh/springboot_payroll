package com.springboot_payroll.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot_payroll.model.employee;
import com.springboot_payroll.service.employeeService;

@RestController
@RequestMapping("/api/employees")
public class employeeController {
	
	private employeeService employeeService;

	public employeeController(employeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}

	//build add employee Rest API
	@PostMapping()
	public ResponseEntity<employee> saveEmployee(@RequestBody employee employee){
		
		return new ResponseEntity<employee>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
		  
	}
	
	// build get all employees REST API
	@GetMapping
	public List<employee> getAllEmployees(){
		return employeeService.getAllEmployees();
		}
	
	//build find employee by id
	//http://localhost:8080/api/employees/1 (1 is dynamic)
	@GetMapping("{id}")
	public ResponseEntity<employee> getEmployeeById(@PathVariable("id")long employeeID){
		return new ResponseEntity<employee>(employeeService.findEmployeeById(employeeID), HttpStatus.OK);
		
	}
	
	//build update employee
	@PutMapping("{id}")
	public ResponseEntity<employee> updateEmployee(@PathVariable("id") long id, @RequestBody employee employee)
	{
		return new ResponseEntity<employee>(employeeService.updateEmployee(employee, id), HttpStatus.OK);
	}
}
