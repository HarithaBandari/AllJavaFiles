package com.stackroute.datamunger.query.parser;

/*
 * This class is used for storing name of field, condition and value for 
 * each conditions
 * */
public class Restriction {
	String name;
	String value;
	 String condition;
	// Write logic for constructor
	public Restriction(String name, String value, String condition) {
 this.name=name;
 this.value=value;
 this.condition=condition;
	}
	public String getPropertyName() {
		// TODO Auto-generated method stub
		return name;
	}
	public String setPropertyName() {
		
		return this.name;
	}

	public String getPropertyValue() {
		// TODO Auto-generated method stub
		return value;
	}
	public String setPropertyValue() {
		// TODO Auto-generated method stub
		return this.value;
	}

	public String getCondition() {
		// TODO Auto-generated method stub
		return condition;
	}
	
	public String setCondition() {
		// TODO Auto-generated method stub
		return this.condition;
	}
	
	

}
