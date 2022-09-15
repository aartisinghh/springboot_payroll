package com.springboot_payroll.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.springboot_payroll.model.employee;
import com.springboot_payroll.repo.employeeRepo;
import com.springboot_payroll.service.employeeService;
import com.springboot_payroll.exception.ResourceNotFoundException;

//Spring automatically creates auto and transaction annotations

@Service
public class employeeServiceImpl implements employeeService{

	//using constructor-based dependency since employee repo is mandatory
	private employeeRepo employeeRepo;
	
	
	public employeeServiceImpl(employeeRepo employeeRepo) {
		super();
		this.employeeRepo = employeeRepo;
	}

	@Override
	public employee saveEmployee(employee employee) {
		System.out.println(employee);
		return employeeRepo.save(employee);
	}

	@Override
	public List<employee> getAllEmployees() {
		return employeeRepo.findAll();
	}

	@Override
	public employee findEmployeeById(long id) {
		Optional<employee> employee = employeeRepo.findById(id);
		if(employee.isPresent()) {
			return employee.get();
		}
		else 
		{
			throw new ResourceNotFoundException("Employee", "Id", id);
		}
		
	}

	@Override
	public employee updateEmployee(employee employee, long id) {
		
		//check if employee with id exists
		// we need to check whether employee with given id is exist in DB or not
				employee employeeExists = employeeRepo.findById(id).orElseThrow(
						() -> new ResourceNotFoundException("Employee", "Id", id)); 
				
				employeeExists.setF_name(employee.getF_name());
				employeeExists.setL_name(employee.getL_name());
				employeeExists.setRole(employee.getRole());
				// save existing employee to DB
				employeeRepo.save(employeeExists);
				return employeeExists;
	}
}
