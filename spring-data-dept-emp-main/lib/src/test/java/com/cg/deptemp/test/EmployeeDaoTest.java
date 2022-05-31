package com.cg.deptemp.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.deptemp.dto.EmployeeDto;
import com.cg.deptemp.dto.EmployeeDtoAdd;
import com.cg.deptemp.entities.Employee;
import com.cg.deptemp.repository.EmployeeRepository;
import com.cg.deptemp.service.EmployeeService;

@SpringBootTest
class EmployeeDaoTest {
	@Autowired
	EmployeeRepository emprepo;
	
	@Autowired
	EmployeeService service;
	
	@Test
	void testGetEmployeeById() {
		Employee emp =emprepo.getEmployeeById(4);
		assertEquals(4,emp.getEmpno()); 
	}
	
	@Test
	void testGetAllItemsNotNull() {
		List<Employee> emplist = emprepo.findAll();
		assertNotNull(emplist);
	}
	@Test
	void testAddEmployee() {
		EmployeeDtoAdd empdtoAdd=new EmployeeDtoAdd();
		empdtoAdd.setDeptno(20);
		empdtoAdd.setDoj(new Date());
		empdtoAdd.setEmpname("ABC");
		empdtoAdd.setJob("analyst");
		empdtoAdd.setSalary(10000);
		int id=service.addEmployee(empdtoAdd);
		assertEquals(empdtoAdd.getEmpname(),emprepo.getEmployeeById(id).getEmpname());
		assertEquals(empdtoAdd.getJob(), emprepo.getEmployeeById(id).getJob());
	}
	
	@Test
	void testUpdateDepartment() {
		
		EmployeeDto empdto=new EmployeeDto();
		empdto.setEmpno(9);
		empdto.setDeptno(20);
		empdto.setDoj(new Date());
		empdto.setEmpname("ABC");
		empdto.setJob("manager");
		empdto.setSalary(1000);
		service.updateEmployee(empdto);
		assertEquals(empdto.getEmpname(),emprepo.getEmployeeById(9).getEmpname());
		assertEquals(empdto.getJob(), emprepo.getEmployeeById(9).getJob());
	}
	@Test
	void testDeleteDepartment() {
		
		service.deleteEmployee(10);
		Employee emp=emprepo.getEmployeeById(13);
		assertNull(emp);
	}
}
