package org.nitin.bidirectional.manytomany;

import java.sql.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity(name="employee121u")
@Table(name="EMPLOYEE")
public class Employeebm2m {

	@Id
	@GeneratedValue
	@Column(name="employee_id")
	private Long employeeId;
	
	@Column(name="firstname")
	private String firstname;
	
	@Column(name="lastname")
	private String lastname;
	
	@Column(name="birth_date")
	private Date birthDate;
	
	@Column(name="cell_phone")
	private String cellphone;
	
	@ManyToMany(cascade =  CascadeType.ALL)
	private Set<Departmentbm2m> departmentbm2m;

	
	public Set<Departmentbm2m> getDepartmentbm2m() {
		return departmentbm2m;
	}

	public void setDepartmentbm2m(Set<Departmentbm2m> departmentbm2m) {
		this.departmentbm2m = departmentbm2m;
	}

	public Employeebm2m() {
		
	}
	
	public Employeebm2m(String firstname, String lastname, String phone) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.birthDate = new Date(System.currentTimeMillis());
		this.cellphone = phone;
	}

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getCellphone() {
		return cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

}