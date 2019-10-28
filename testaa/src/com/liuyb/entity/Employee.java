package com.liuyb.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="emp")
public class Employee {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="emp_no",length=32)
	private Integer empNo;
	@Column(name="emp_name")
	private String empName;
	@Column(name="emp_addr")
	private String empAddress;
	@Column(name="emp_dept_no",length=32)
	private Integer empDeptNo;
	@Column(name="emp_age",length=32)
	private Integer empAge;
	
	public Integer getEmpNo() {
		return empNo;
	}
	
	public void setEmpNo(Integer empNo) {
		this.empNo = empNo;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpAddress() {
		return empAddress;
	}
	public void setEmpAddress(String empAddress) {
		this.empAddress = empAddress;
	}
	public Integer getEmpDeptNo() {
		return empDeptNo;
	}
	public void setEmpDeptNo(Integer empDeptNo) {
		this.empDeptNo = empDeptNo;
	}
	public Integer getEmpAge() {
		return empAge;
	}
	public void setEmpAge(Integer empAge) {
		this.empAge = empAge;
	}
	public Employee() {
		super();
	}

}
