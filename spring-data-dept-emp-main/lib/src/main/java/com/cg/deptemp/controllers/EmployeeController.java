package com.cg.deptemp.controllers;

import java.util.List;
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

import com.cg.deptemp.dto.EmployeeDto;
import com.cg.deptemp.dto.EmployeeDtoAdd;
import com.cg.deptemp.service.EmployeeServiceImpl;

@RestController
@RequestMapping("/emp")
public class EmployeeController {
	@Autowired
	EmployeeServiceImpl empservice;
	
	@PostMapping
	public ResponseEntity<String> addEmployee(@RequestBody EmployeeDtoAdd empdtoAdd){
		int empno=empservice.addEmployee(empdtoAdd);
		return new ResponseEntity<String>("inserted empcode = "+empno, HttpStatus.OK);
	}
	@GetMapping
	public ResponseEntity<List<EmployeeDto>> getEmployees(){
		List<EmployeeDto> empdtoList=empservice.viewAllEmployees();
		return new ResponseEntity<List<EmployeeDto>>(empdtoList, HttpStatus.OK);
	}
	@GetMapping("/id/{empno}")
	public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable int empno){
		EmployeeDto empdto = empservice.getEmployeeById(empno);
		return new ResponseEntity<EmployeeDto>(empdto,HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<String> editEmployee(@RequestBody EmployeeDto empdto){
		empservice.updateEmployee(empdto);
		return new ResponseEntity<String>("updated",HttpStatus.OK);
	}
	@DeleteMapping("/id/{empno}")
	public ResponseEntity<String> deleteEmployee(@PathVariable int empno){
		empservice.deleteEmployee(empno);
		return new ResponseEntity<String>("deleted",HttpStatus.OK);
	}
}
