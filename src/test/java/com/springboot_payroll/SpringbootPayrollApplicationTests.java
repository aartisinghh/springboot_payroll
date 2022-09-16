package com.springboot_payroll;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import com.springboot_payroll.model.employee;
import com.springboot_payroll.controller.employeeController;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class SpringbootPayrollApplicationTests {
	
	@Autowired
	employeeController employeeController;
	
	@Test
	public void contextLoads()
	{
		Assertions.assertThat(employeeController).isNotNull();
	}
	
}

