package com.stackroute.datamunger.query.parser;

//import java.util.List;

/* This class is used for storing name of field, aggregate function for 
 * each aggregate function
 * generate getter and setter for this class,
 * Also override toString method
 * */

public class AggregateFunction {
	String field;
	String function;
	// Write logic for constructor
	public AggregateFunction(String field, String function) {
		this.function=function;
		this.field=field;}
		public String getAggregateFunctions() {

			return this.field +" " + this.function;
		}
		public void setAggregateFunctions(String field, String function) {
			this.function=function;
			this.field=field;
			
		}
		public String toString() {
			return this.field +" " + this.function;
		}
		
	}

