package com.stackroute.datamunger.query.parser;

import java.util.ArrayList;
import java.util.List;

/* 
 * This class will contain the elements of the parsed Query String such as conditions,
 * logical operators,aggregate functions, file name, fields group by fields, order by
 * fields, Query Type
 * */

public class QueryParameter {
	// private String queryString;
	private String fileName;
	private String baseQuery;
	private List<String> orderByFields = new ArrayList<String>();

	private List<Restriction> restrictions = new ArrayList<Restriction>();
	private List<String> groupByFields = new ArrayList<String>();
	private List<String> logicalOperators = new ArrayList<String>();
private	List<AggregateFunction> aggregatefunctions = new ArrayList<AggregateFunction>();
	private List<String> fields = new ArrayList<String>();

	public String getFileName() {

		return fileName;
	}

	public void setFileName(String fileName) {

		this.fileName = fileName;
	}

	public String getBaseQuery() {

		return baseQuery;
	}

	public void setBaseQuery(String baseQuery) {

		this.baseQuery = baseQuery;
	}

	public List<String> getLogicalOperators() {

		return logicalOperators;
	}
	public void setLogicalOperators(List<String> logicalOperators) {

		this.logicalOperators=logicalOperators;
	}

	public List<String> getFields() {

		return fields;
	}

	public void setFields(List<String> fields) {

		this.fields = fields;
	}

	public List<AggregateFunction> getAggregateFunctions() {

		return aggregatefunctions;
	}

	public void setAggregateFunctions(List<AggregateFunction> aggregatefunctions) {

		this.aggregatefunctions =aggregatefunctions ;
	}

	public List<String> getGroupByFields() {

		return groupByFields;
	}

	public void setGroupByFields(List<String> groupByFields) {

		this.groupByFields = groupByFields;
	}

	public List<String> getOrderByFields() {

		return orderByFields;
	}

	public void setOrderByFields(List<String> orderByFields) {

		this.orderByFields = orderByFields;
	}

	public List<Restriction> getRestriction() {
		return restrictions;

	}

	public void setRestriction(List<Restriction> restrictions) {
		this.restrictions = restrictions;

	}

}