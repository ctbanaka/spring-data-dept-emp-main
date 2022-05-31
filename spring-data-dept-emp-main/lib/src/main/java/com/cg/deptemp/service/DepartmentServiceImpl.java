package com.cg.deptemp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.deptemp.entities.Department;
import com.cg.deptemp.exceptions.DepartmentAlreadyExistException;
import com.cg.deptemp.exceptions.DepartmentNotFoundException;
import com.cg.deptemp.repository.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService{
	@Autowired
	DepartmentRepository deptrepo;
	@Override
	public void addDepartment(Department dept) {
		Optional<Department> department = deptrepo.findById(dept.getDeptno());
		if(!department.isEmpty())
			throw new DepartmentAlreadyExistException();
		deptrepo.save(dept);
	}
	@Override
	public List<Department> viewAllDepts() {
		return deptrepo.findAll();
	}
	@Override 
	public Optional<Department> getDeptById(int deptno) {
		Optional<Department> dept = deptrepo.findById(deptno); 
		if(dept.isEmpty())
			throw new DepartmentNotFoundException();
		return dept;
	}
	@Override
	public void updateDepartment(Department dept) {
		Optional<Department> department = deptrepo.findById(dept.getDeptno());
		if(department.isEmpty())
			throw new DepartmentNotFoundException();
		deptrepo.save(dept);
		
	}
	@Override
	public void deleteDepartment(int deptno) {
		Optional<Department> dept = deptrepo.findById(deptno);
		if(dept.isEmpty())
			throw new DepartmentNotFoundException();
		deptrepo.deleteById(deptno); 		
	}

}
