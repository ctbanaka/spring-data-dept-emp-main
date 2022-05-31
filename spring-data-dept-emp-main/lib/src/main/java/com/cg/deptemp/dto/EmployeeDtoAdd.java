package com.cg.deptemp.dto;

import java.util.Date;

public class EmployeeDtoAdd {
	private String empname;
	private String job;
	private Date doj;
	private double salary;
	private int deptno;
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
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	@Override
	public String toString() {
		return "EmployeeDto [empname=" + empname + ", job=" + job + ", doj=" + doj + ", salary=" + salary + ", deptno="
				+ deptno + "]";
	}
}
