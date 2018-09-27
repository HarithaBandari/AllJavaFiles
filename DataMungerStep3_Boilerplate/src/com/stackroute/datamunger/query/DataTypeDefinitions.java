package com.stackroute.datamunger.query;

public class DataTypeDefinitions {

//	public DataTypeDefinitions(String[] str) {
//		
//		this.str = str;
//	}
	/*
	 * This class should contain a member variable which is a String array, to hold
	 * the data type for all columns for all data types
	 */
	String[] str=new String[16];
	public String[] getDataTypes() {
		return str;
	}
	public String[] setDataTypes(String[] str) {
		return this.str=str;
	}
}
