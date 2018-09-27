package com.stackroute.datamunger.query.parser;

/* This class is used for storing name of field, aggregate function for 
 * each aggregate function
 * */
public class AggregateFunction {
	String field;
	String function;
	// Write logic for constructor
	public AggregateFunction(String field, String function) {
		this.function=function;
		this.field=field;}
	public String getFunction() {
		
		return function;
	}
public String setFunction(String field) {
		
		return this.function;
	}

	public String getField() {
		
		return field;
	}
public String setField(String field) {
		
		return this.field;
	}
	

}
