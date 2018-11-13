package org.nitin.bidirectional.onetomany;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name="departmentB121")
@Table(name="DEPARTMENT")
public class Departmentbo2m {

	@Id
	@GeneratedValue
	@Column(name="DEPARTMENT_ID")
	private Long departmentId;
	
	@Column(name="DEPT_NAME")
	private String departmentName;
	
	@OneToMany(mappedBy="departmentbo2o", cascade = CascadeType.ALL)	
	private Set<Employeebo2m> employee;

	public Set<Employeebo2m> getEmployee() {
		return employee;
	}

	public void setEmployee(Set<Employeebo2m> employee) {
		this.employee = employee;
	}

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


}