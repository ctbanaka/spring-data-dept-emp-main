package com.cg.deptemp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.deptemp.entities.Employee;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	@Query(value = "select emp from Employee emp where emp.empno=?1")
	Employee getEmployeeById(int empno);
}
