package com.stackroute.datamunger.query;

import java.util.HashMap;
import java.util.Map;

//Contains the row object as ColumnName/Value. Hence, HashMap is being used
public class Row extends HashMap<String, String>{
	Map<String,String> rowMap= new HashMap<String, String>();
	
	public Map<String, String> getRowMap() {
		return rowMap;
	}
	public void setRowMap(Map<String, String> rowMap) {
		this.rowMap = rowMap;
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
}
