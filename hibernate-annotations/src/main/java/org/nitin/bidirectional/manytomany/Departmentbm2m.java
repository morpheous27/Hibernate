package org.nitin.bidirectional.manytomany;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity(name="departmentB121")
@Table(name="DEPARTMENT")
public class Departmentbm2m {

	@Id
	@GeneratedValue
	@Column(name="DEPARTMENT_ID")
	private Long departmentId;
	
	@Column(name="DEPT_NAME")
	private String departmentName;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="empdep", joinColumns={@JoinColumn(name="department_id")}, inverseJoinColumns={@JoinColumn(name="employee_id")})
	private Set<Employeebm2m> employee;

	public Set<Employeebm2m> getEmployee() {
		return employee;
	}

	public void setEmployee(Set<Employeebm2m> employee) {
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