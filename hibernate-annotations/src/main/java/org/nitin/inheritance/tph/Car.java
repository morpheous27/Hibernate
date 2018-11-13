package org.nitin.inheritance.tph;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="C")
public class Car extends Vehicle{

	private String type;
	
	@org.hibernate.annotations.Type(type = "yes_no")
	private boolean is4wheel;
	
	@org.hibernate.annotations.Type(type = "yes_no")
	private boolean isAutomatic;
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public boolean isIs4wheel() {
		return is4wheel;
	}
	public void setIs4wheel(boolean is4wheel) {
		this.is4wheel = is4wheel;
	}
	public boolean isAutomatic() {
		return isAutomatic;
	}
	public void setAutomatic(boolean isAutomatic) {
		this.isAutomatic = isAutomatic;
	}
}
