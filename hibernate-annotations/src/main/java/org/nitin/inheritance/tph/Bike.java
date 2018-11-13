package org.nitin.inheritance.tph;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
@DiscriminatorValue(value="B")
public class Bike extends Vehicle{

	private String type;
	
	@org.hibernate.annotations.Type(type = "yes_no")
	private boolean isAutomatic;
	
	@Enumerated(EnumType.STRING)
	private Bike.InjectionType injectionType;
	
	
	public Bike.InjectionType getInjectionType() {
		return injectionType;
	}
	public void setInjectionType(Bike.InjectionType injectionType) {
		this.injectionType = injectionType;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public boolean isAutomatic() {
		return isAutomatic;
	}
	public void setAutomatic(boolean isAutomatic) {
		this.isAutomatic = isAutomatic;
	}
	
	
public enum InjectionType
{
	FI,
	ANALOGU,
	DIGITAL;
}

}
