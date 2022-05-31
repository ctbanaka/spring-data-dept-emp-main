package com.cg.deptemp.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.deptemp.entities.Department;
import com.cg.deptemp.service.DepartmentServiceImpl;

@RestController
@RequestMapping("/dept")
public class DepartmentController {
	@Autowired
	DepartmentServiceImpl service;
	
	@PostMapping
	public ResponseEntity<String> addDepartment(@RequestBody Department dept){
		service.addDepartment(dept);
		return new ResponseEntity<String>("inserted", HttpStatus.OK);
	}
	@GetMapping
	public ResponseEntity<List<Department>> getDepartments(){
		List<Department> deptList=service.viewAllDepts();
		return new ResponseEntity<List<Department>>(deptList, HttpStatus.OK);
	}
	@GetMapping("/id/{deptno}")
	public ResponseEntity<Optional<Department>> getDeptById(@PathVariable int deptno){
		Optional<Department> dept = service.getDeptById(deptno);
		return new ResponseEntity<Optional<Department>>(dept,HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<String> editDepartment(@RequestBody Department dept){
		service.updateDepartment(dept);
		return new ResponseEntity<String>("updated",HttpStatus.OK);
	}
	@DeleteMapping("/id/{deptno}")
	public ResponseEntity<String> deleteDepartment(@PathVariable int deptno){
		service.deleteDepartment(deptno);
		return new ResponseEntity<String>("deleted",HttpStatus.OK);
	}
}
