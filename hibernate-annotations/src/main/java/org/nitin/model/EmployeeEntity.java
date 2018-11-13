package org.nitin.model;

import java.io.Serializable;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employeeData")
public class EmployeeEntity implements Serializable
{
   private static final long serialVersionUID = 570235488278506106L;
   
   @Id
   @GeneratedValue(strategy = GenerationType.SEQUENCE)
   private Integer           employeeId;
   private String            firstName;
   private String            lastName;
   private Address           studentAddress;
   
   @Embedded
   public Address getStudentAddress() {
	return studentAddress;
}

public void setStudentAddress(Address studentAddress) {
	this.studentAddress = studentAddress;
}

public Integer getEmployeeId()
   {
      return employeeId;
   }
 
   public void setEmployeeId(Integer employeeId)
   {
      this.employeeId = employeeId;
   }
 
   public String getFirstName()
   {
      return firstName;
   }
 
   public void setFirstName(String firstName)
   {
      this.firstName = firstName;
   }
 
   public String getLastName()
   {
      return lastName;
   }
 
   public void setLastName(String lastName)
   {
      this.lastName = lastName;
   }
}