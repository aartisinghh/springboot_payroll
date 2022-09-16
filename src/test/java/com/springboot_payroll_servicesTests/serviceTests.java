package com.springboot_payroll_servicesTests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.springboot_payroll.model.employee;
import com.springboot_payroll.repo.employeeRepo;
import com.springboot_payroll.service.impl.employeeServiceImpl;

@ExtendWith(MockitoExtension.class)
public class serviceTests {

	@InjectMocks
    employeeServiceImpl service;
     
    @Mock
    employeeRepo repo;
    
    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }
        
    @Test
    void testFindAllEmployees()
    {
        List<employee> list = new ArrayList<employee>();
        employee empOne = new employee("Hannah", "Montana", "singer");
        employee empTwo = new employee("harry", "potter", "wizard");
        employee empThree = new employee("chico", "singh", "dog");
         
        list.add(empOne);
        list.add(empTwo);
        list.add(empThree);
         
        when(repo.findAll()).thenReturn(list);
         
        //test
        List<employee> empList = service.getAllEmployees();
         
        assertEquals(3, empList.size());
        verify(repo, times(1)).findAll();
    }
    
    @Test
    void testCreateOrSaveEmployee()
    {
        employee employee = new employee("aarti","singh", "dev");
         
        service.saveEmployee(employee);
         
        verify(repo, times(1)).save(employee);
    }
	
}
