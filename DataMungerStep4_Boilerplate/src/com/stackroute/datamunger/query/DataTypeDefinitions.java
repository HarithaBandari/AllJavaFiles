package com.stackroute.datamunger.query;

import java.util.Arrays;

//this class contains the data type definitions
public class DataTypeDefinitions {

	/*
	 * this class should contain a member variable which is a String array, to hold
	 * the data type for all columns for all data types and should override toString() method as well.
	 */	
	String[] str;
	public String[] getDataTypes() {
		return str;
	}
	public String[] setDataTypes(String[] str) {
		return this.str=str;
	}
	@Override
	public String toString() {
		return "DataTypeDefinitions [str=" + Arrays.toString(str) + "]";
	}
	
}
