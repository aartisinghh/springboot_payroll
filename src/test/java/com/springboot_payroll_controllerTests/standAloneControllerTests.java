package com.springboot_payroll_controllerTests;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.springboot_payroll.controller.employeeController;
import com.springboot_payroll.model.employee;
import com.springboot_payroll.service.employeeService;


@ExtendWith(SpringExtension.class)
@WebMvcTest(employeeController.class)
public class standAloneControllerTests {
	
	@MockBean
	employeeService employeeService;

	@Autowired
	MockMvc mockMvc;

	//not working 
	
	@Test
	public void testfindAll() throws Exception {
		employee employee = new employee("aarti", "singh", "dev");
		List<employee> employees = Arrays.asList(employee);

		Mockito.when(employeeService.getAllEmployees()).thenReturn(employees);

		mockMvc.perform(get("/employee"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$", Matchers.hasSize(1)))
				.andExpect(jsonPath("$[0].firstNname", Matchers.is("aarti")));
	}

}
