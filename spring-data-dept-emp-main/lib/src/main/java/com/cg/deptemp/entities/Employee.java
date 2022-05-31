package com.cg.deptemp.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int empno;
	@Column(name = "empname",length = 30)
	private String empname;
	@Column(name = "job",length = 30)
	private String job;
	@Column(name = "doj",columnDefinition = "date")
	private Date doj;
	@Column(name = "salary",columnDefinition = "numeric(8,2)")
	private double salary;
	@OneToOne
	@JoinColumn(name = "deptno")
	private Department dept;
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public String getEmpname() {
		return empname;
	}
	public void setEmpname(String empname) {
		this.empname = empname;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public Date getDoj() {
		return doj;
	}
	public void setDoj(Date doj) {
		this.doj = doj;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public Department getDept() {
		return dept;
	}
	public void setDept(Department dept) {
		this.dept = dept;
	}
}
