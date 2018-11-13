package org.nitin.bidirectional.onetomany;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity(name="employee121u")
@Table(name="EMPLOYEE")
public class Employeebo2m {

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
	
	@ManyToOne(cascade =  CascadeType.ALL)
	private Departmentbo2m departmentbo2o;

	public Departmentbo2m getDepartmentbo2o() {
		return departmentbo2o;
	}

	public void setDepartmentbo2o(Departmentbo2m departmentbo2o) {
		this.departmentbo2o = departmentbo2o;
	}

	public Employeebo2m() {
		
	}
	
	public Employeebo2m(String firstname, String lastname, String phone) {
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