package com.cg.deptemp.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.deptemp.entities.Department;
import com.cg.deptemp.repository.DepartmentRepository;
import com.cg.deptemp.service.DepartmentService;

@SpringBootTest
class DepartmentDaoTest {

	@Autowired
	DepartmentRepository deptrepo;
	
	@Autowired
	DepartmentService service;
	
	@Test
	void testGetDeptById() {
		Department dept = deptrepo.getDeptById(30);
		assertEquals(30,dept.getDeptno()); 
	}
	
	@Test
	void testGetAllItemsNotNull() {
		List<Department> deptlist = deptrepo.findAll();
		assertNotNull(deptlist);
	}
	@Test
	void testAddDepartment() {
		Department dept=new Department();
		dept.setDeptno(70);
		dept.setDeptname("LND");
		dept.setLocation("Noida");
		service.addDepartment(dept);
		assertEquals(dept.getDeptname(), deptrepo.getDeptById(70).getDeptname());
		assertEquals(dept.getDeptname(), deptrepo.getDeptById(70).getDeptname());
	}
	
	@Test
	void testUpdateDepartment() {
		Department dept=new Department();
		dept.setDeptno(70);
		dept.setDeptname("LND");
		dept.setLocation("Madurai");
		service.updateDepartment(dept);
		assertEquals(dept.getDeptno(), deptrepo.getDeptById(70).getDeptno());
		assertEquals(dept.getLocation(), deptrepo.getDeptById(70).getLocation());
		
		assertEquals(dept.getDeptname(), deptrepo.getDeptById(70).getDeptname());
	}
	@Test
	void testDeleteDepartment() {
		
		service.deleteDepartment(70);
		Department dept = deptrepo.getDeptById(70);
		assertNull(dept);
	}
}
