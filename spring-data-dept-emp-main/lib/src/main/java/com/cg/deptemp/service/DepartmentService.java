package com.cg.deptemp.service;

import java.util.List;
import java.util.Optional;

import com.cg.deptemp.entities.Department;

public interface DepartmentService {
	void addDepartment(Department dept);
	List<Department> viewAllDepts();
	Optional<Department> getDeptById(int deptno);
	void updateDepartment(Department dept);
	void deleteDepartment(int deptno);
}
