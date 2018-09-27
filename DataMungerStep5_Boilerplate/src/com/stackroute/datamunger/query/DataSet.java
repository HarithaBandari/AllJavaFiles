package com.stackroute.datamunger.query;

import java.util.LinkedHashMap;

//This class will be acting as the DataSet containing multiple rows
public class DataSet extends LinkedHashMap<Long, Row> {
	 LinkedHashMap<Long, Row>datasetMap=new LinkedHashMap<Long, Row>();
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public LinkedHashMap<Long, Row> getDatasetMap() {
		return datasetMap;
	}
	public void setDatasetMap(LinkedHashMap<Long, Row> datasetMap) {
		this.datasetMap = datasetMap;
	}
	
}
