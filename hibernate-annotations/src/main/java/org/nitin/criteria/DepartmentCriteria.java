package org.nitin.criteria;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity(name="departmentCrit")
public class DepartmentCriteria {

	@Id
	@GeneratedValue
	@Column(name="DEPARTMENT_ID")
	private Long departmentId;
	
	@Column(name="DEPT_NAME")
	private String departmentName;
	
	@OneToOne(mappedBy="departmentbo2o",cascade =  CascadeType.ALL)
	private EmployeeCriteria employee;

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

	public EmployeeCriteria getEmployees() {
		return employee;
	}

	public void setEmployees(EmployeeCriteria employees) {
		this.employee = employees;
	}

}