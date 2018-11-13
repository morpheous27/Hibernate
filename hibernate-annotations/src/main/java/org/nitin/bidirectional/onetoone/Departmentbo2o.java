package org.nitin.bidirectional.onetoone;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity(name = "departmentbo2o")
@Table(name = "DEPARTMENT")
public class Departmentbo2o {

	@Id
	@GeneratedValue
	@Column(name = "DEPARTMENT_ID")
	private Long departmentId;

	@Column(name = "DEPT_NAME")
	private String departmentName;

	@OneToOne(mappedBy = "departmentbo2o")
	private Employeebo2o employee;

	public Long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public Employeebo2o getEmployees() {
		return employee;
	}

	public void setEmployees(Employeebo2o employees) {
		this.employee = employees;
	}

}