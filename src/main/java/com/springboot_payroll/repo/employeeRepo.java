package com.springboot_payroll.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot_payroll.model.employee;

// created repository as I'm following the CRUD format

public interface employeeRepo extends JpaRepository<employee, Long>{

}
