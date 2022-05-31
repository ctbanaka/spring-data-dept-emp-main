package com.cg.deptemp.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.deptemp.dto.EmployeeDto;
import com.cg.deptemp.dto.EmployeeDtoAdd;
import com.cg.deptemp.entities.Department;
import com.cg.deptemp.entities.Employee;
import com.cg.deptemp.exceptions.DepartmentNotFoundException;
import com.cg.deptemp.exceptions.EmployeeNotFoundException;
import com.cg.deptemp.repository.DepartmentRepository;
import com.cg.deptemp.repository.EmployeeRepository;
@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	EmployeeRepository emprepo;
	@Autowired
	DepartmentRepository deptrepo;
	
	@Override
	public int addEmployee(EmployeeDtoAdd empdtoAdd) {
		 
		// Custom query -// Get Department object by passing deptno from empdto obj
		Department dept = deptrepo.getDeptById(empdtoAdd.getDeptno());
		if(dept==null)
			throw new DepartmentNotFoundException();
		Employee emp = new Employee();
		  emp.setEmpname(empdtoAdd.getEmpname());
		  emp.setJob(empdtoAdd.getJob());
		  emp.setDoj(empdtoAdd.getDoj());
		  emp.setSalary(empdtoAdd.getSalary());
		  emp.setDept(dept);
		  emprepo.save(emp);
		 return emp.getEmpno();
		
	}

	@Override
	public List<EmployeeDto> viewAllEmployees() {
		List<Employee> empList= emprepo.findAll();
		if(empList.isEmpty())
			throw new EmployeeNotFoundException();
		List<EmployeeDto> empdtoList= new ArrayList<EmployeeDto>();
		for (Employee emp : empList) {
			EmployeeDto empdto = new EmployeeDto();
			  empdto.setEmpno(emp.getEmpno());
			  empdto.setEmpname(emp.getEmpname());
			  empdto.setJob(emp.getJob());
			  empdto.setDoj(emp.getDoj());
			  empdto.setSalary(emp.getSalary());
			  empdto.setDeptno(emp.getDept().getDeptno());
			  empdtoList.add(empdto);
		}
		return empdtoList;
	}

	@Override
	public EmployeeDto getEmployeeById(int empno) {
		Employee emp = emprepo.getEmployeeById(empno); 
		if(emp==null)
			throw new EmployeeNotFoundException();
		EmployeeDto empdto = new EmployeeDto();
		  empdto.setEmpno(emp.getEmpno());
		  empdto.setEmpname(emp.getEmpname());
		  empdto.setJob(emp.getJob());
		  empdto.setDoj(emp.getDoj());
		  empdto.setSalary(emp.getSalary());
		  empdto.setDeptno(emp.getDept().getDeptno());
		
		return empdto;
	}

	@Override
	public void updateEmployee(EmployeeDto empdto) {
		Department dept = deptrepo.getDeptById(empdto.getDeptno());
		 if(dept==null)
			 throw new DepartmentNotFoundException();
		Employee emp = emprepo.getEmployeeById(empdto.getEmpno());
		  if(emp==null)
			  throw new EmployeeNotFoundException();
		  emp.setEmpname(empdto.getEmpname());
		  emp.setJob(empdto.getJob());
		  emp.setDoj(empdto.getDoj());
		  emp.setSalary(empdto.getSalary());
		  emp.setDept(dept);
		  emprepo.save(emp);
		
	}

	@Override
	public void deleteEmployee(int empno) {
		Employee emp = emprepo.getEmployeeById(empno);
		  if(emp==null)
			  throw new EmployeeNotFoundException();
		emprepo.deleteById(empno); 	
	}

}
