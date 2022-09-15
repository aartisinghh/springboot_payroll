package com.springboot_payroll.service;

import com.springboot_payroll.model.employee;

import java.util.List;

public interface employeeService {
	employee saveEmployee(employee employee);
	List<employee> getAllEmployees();
	employee findEmployeeById(long id);
	employee updateEmployee(employee employee, long id);

}
