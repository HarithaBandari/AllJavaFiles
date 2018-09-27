package com.stackroute.datamunger.query;

import java.util.HashMap;
import java.util.Map;

//This class will be used to store the column data types as columnIndex/DataType
public class RowDataTypeDefinitions extends HashMap<Integer, String>{
	Map<Integer,String> rowDataTypeDefinitionMap= new HashMap<Integer,String>();
	public Map<Integer,String> getrowData() {

		return rowDataTypeDefinitionMap;
	}

	public void setrowData(Map<Integer, String> rowDataTypeMap) {

		this.rowDataTypeDefinitionMap=rowDataTypeMap;
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
}
