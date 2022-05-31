package com.cg.deptemp.service;

import java.util.List;
import com.cg.deptemp.dto.EmployeeDto;
import com.cg.deptemp.dto.EmployeeDtoAdd;

public interface EmployeeService {
	int addEmployee(EmployeeDtoAdd empdtoAdd);
	List<EmployeeDto> viewAllEmployees();
	EmployeeDto getEmployeeById(int empno);
	void updateEmployee(EmployeeDto empdto);
	void deleteEmployee(int empno);
}
