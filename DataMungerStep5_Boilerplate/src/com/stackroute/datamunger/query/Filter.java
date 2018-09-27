package com.stackroute.datamunger.query;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

//This class contains methods to evaluate expressions
public class Filter {
	RowDataTypeDefinitions rowDataTypeMap;
	String dataType;
	boolean bool;
	String name;
	/* 
	 * The evaluateExpression() method of this class is responsible for evaluating 
	 * the expressions mentioned in the query. It has to be noted that the process 
	 * of evaluating expressions will be different for different data types. there 
	 * are 6 operators that can exist within a query i.e. >=,<=,<,>,!=,= This method 
	 * should be able to evaluate all of them. 
	 * Note: while evaluating string expressions, please handle uppercase and lowercase 
	 * 
	 */
	public boolean evaluateExpressions(String[] lineArray, String value,String condition,int index) throws ParseException {
		
		Map<Integer,String> rowMap= new HashMap<Integer, String>();
		rowMap=(Map<Integer, String>) (rowDataTypeMap.getrowData());
		if(rowMap.containsKey(index)) {
			dataType=rowMap.get(index);
			}
		
		switch(condition) {
		case "=":
			
			bool=equalTo(name,value,dataType);
			break;
			
		case "!=":
			bool=notequalTo(name,value,dataType);
			break;
			
		case ">":
			bool=greaterThan(name,value,dataType);
			break;
			
		case ">=":
			bool=greaterThanequalTo(name,value,dataType);
			break;
			
		case "<":
			bool=lessThan(name,value,dataType);
			break;
			
		case "<=":
			bool=lessThanequalTo(name,value,dataType);
			break;
		
		}
		return bool;
	
	}
	
	//Method containing implementation of equalTo operator


	private boolean equalTo(String name, String value, String dataType) throws ParseException {
		boolean result=false;
		if(dataType=="java.lang.Integer") {
		int n=Integer.parseInt(name);
		int v=Integer.parseInt(value);
		if(n==v) {
				result=true;
			}
			else
				result=false;
			}
		
		if(dataType=="java.lang.Double") {
			double n=Integer.parseInt(name);
			double v=Integer.parseInt(value);
			if(n==v) {
					result=true;
				}
				else
					result=false;
				}
		
		
		if(dataType=="java.lang.Date") {
			Date rowDate=new SimpleDateFormat("yyyy-mm-dd").parse(value);
			Date restrictionDate=new SimpleDateFormat("yyyy-mm-dd").parse(value);
			if(rowDate.compareTo(restrictionDate)==0) {
					result=true;
				}
				else
					result=false;
				}
		
		return result;
	}
		
	//Method containing implementation of notEqualTo operator
	
	private boolean notequalTo(String name, String value, String dataType) throws ParseException {
		boolean result=false;
		if(dataType=="java.lang.Integer") {
		int n=Integer.parseInt(name);
		int v=Integer.parseInt(value);
		if(n!=v) {
				result=true;
			}
			else
				result=false;
			}
		
		if(dataType=="java.lang.Double") {
			double n=Integer.parseInt(name);
			double v=Integer.parseInt(value);
			if(n!=v) {
					result=true;
				}
				else
					result=false;
				}
		
		
		if(dataType=="java.lang.Date") {
			Date rowDate=new SimpleDateFormat("yyyy-mm-dd").parse(value);
			Date restrictionDate=new SimpleDateFormat("yyyy-mm-dd").parse(value);
			if(rowDate.compareTo(restrictionDate)!=0) {
					result=true;
				}
				else
					result=false;
				}
		
		return result;
	}
	
	
	
	
	
	//Method containing implementation of greaterThan operator
	
	
private boolean greaterThan(String name, String value, String dataType) throws ParseException {
		
	boolean result=false;
	if(dataType=="java.lang.Integer") {
	int n=Integer.parseInt(name);
	int v=Integer.parseInt(value);
	if(n>v) {
			result=true;
		}
		else
			result=false;
		}
	
	if(dataType=="java.lang.Double") {
		double n=Integer.parseInt(name);
		double v=Integer.parseInt(value);
		if(n>v) {
				result=true;
			}
			else
				result=false;
			}
	
	
	if(dataType=="java.lang.Date") {
		Date rowDate=new SimpleDateFormat("yyyy-mm-dd").parse(value);
		Date restrictionDate=new SimpleDateFormat("yyyy-mm-dd").parse(value);
		if(rowDate.compareTo(restrictionDate)>0) {
				result=true;
			}
			else
				result=false;
			}
	
	return result;
	}
	
	
	//Method containing implementation of greaterThanOrEqualTo operator
	
private boolean greaterThanequalTo(String name, String value, String dataType) throws ParseException {
	
	boolean result=false;
	if(dataType=="java.lang.Integer") {
	int n=Integer.parseInt(name);
	int v=Integer.parseInt(value);
	if(n>=v) {
			result=true;
		}
		else
			result=false;
		}
	
	if(dataType=="java.lang.Double") {
		double n=Integer.parseInt(name);
		double v=Integer.parseInt(value);
		if(n>=v) {
				result=true;
			}
			else
				result=false;
			}
	
	
	if(dataType=="java.lang.Date") {
		Date rowDate=new SimpleDateFormat("yyyy-mm-dd").parse(value);
		Date restrictionDate=new SimpleDateFormat("yyyy-mm-dd").parse(value);
		if(rowDate.compareTo(restrictionDate)>=0) {
				result=true;
			}
			else
				result=false;
			}
	
	return result;
}
	
	//Method containing implementation of lessThan operator
	  
	
private boolean lessThan(String name, String value, String dataType) throws ParseException {
	
	boolean result=false;
	if(dataType=="java.lang.Integer") {
	int n=Integer.parseInt(name);
	int v=Integer.parseInt(value);
	if(n<v) {
			result=true;
		}
		else
			result=false;
		}
	
	if(dataType=="java.lang.Double") {
		double n=Integer.parseInt(name);
		double v=Integer.parseInt(value);
		if(n<v) {
				result=true;
			}
			else
				result=false;
			}
	
	
	if(dataType=="java.lang.Date") {
		Date rowDate=new SimpleDateFormat("yyyy-mm-dd").parse(value);
		Date restrictionDate=new SimpleDateFormat("yyyy-mm-dd").parse(value);
		if(rowDate.compareTo(restrictionDate)<0) {
				result=true;
			}
			else
				result=false;
			}
	
	return result;
}
	
	
	//Method containing implementation of lessThanOrEqualTo operator
private boolean lessThanequalTo(String name, String value, String dataType) throws ParseException {
	
	boolean result=false;
	if(dataType=="java.lang.Integer") {
	int n=Integer.parseInt(name);
	int v=Integer.parseInt(value);
	if(n<=v) {
			result=true;
		}
		else
			result=false;
		}
	
	if(dataType=="java.lang.Double") {
		double n=Integer.parseInt(name);
		double v=Integer.parseInt(value);
		if(n<=v) {
				result=true;
			}
			else
				result=false;
			}
	
	
	if(dataType=="java.lang.Date") {
		Date rowDate=new SimpleDateFormat("yyyy-mm-dd").parse(value);
		Date restrictionDate=new SimpleDateFormat("yyyy-mm-dd").parse(value);
		if(rowDate.compareTo(restrictionDate)<=0) {
				result=true;
			}
			else
				result=false;
			}
	
	return result;
}
}
	

