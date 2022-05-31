package com.cg.deptemp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.deptemp.entities.Department;
@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {
	//custom query
	@Query(value = "select dept from Department dept where dept.deptno=?1")
	Department getDeptById(int deptno);
}
