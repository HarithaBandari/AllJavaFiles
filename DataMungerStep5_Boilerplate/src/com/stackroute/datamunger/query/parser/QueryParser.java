package com.stackroute.datamunger.query.parser;

import java.util.ArrayList;
import java.util.List;

public class QueryParser {

	private QueryParameter queryParameter = new QueryParameter();
	/*
	 * This method will parse the queryString and will return the object of
	 * QueryParameter class
	 */
	public QueryParameter parseQuery(String queryString) {
		

			queryParameter.setFileName(getFileName(queryString));
			queryParameter.setBaseQuery(getBaseQuery(queryString));

			queryParameter.setGroupByFields(getGroupByFields(queryString));
			queryParameter.setLogicalOperators(getLogicalOperators(queryString));
			queryParameter.setAggregateFunctions(getAggregateFunctions(queryString));
			queryParameter.setRestriction(getRestriction(queryString));
			queryParameter.setOrderByFields(getOrderByFields(queryString));
			queryParameter.setFields(getFields(queryString));

			return queryParameter;

		}
		/*
		 * extract the name of the file from the query. File name can be found after the
		 * "from" clause.
		 */
		public String getFileName(String queryString) {

			String[] s = queryString.split("from");
			String s1 = s[1];
			String[] s2 = s1.split(" ");
			String s3 = null;
			s3 = s2[1];
			return s3;
		}
		
		
		
		public String getBaseQuery(String queryString) {
			queryString = queryString.toLowerCase();
			int index = 0;
			if (queryString.contains("where")) {
				index = queryString.indexOf(" where ");
			} else if (queryString.contains("group by")) {
				index = queryString.indexOf(" group");
			}
			queryString = queryString.substring(0, index);

			return queryString;
		}
		/*
		 * extract the order by fields from the query string. Please note that we will
		 * need to extract the field(s) after "order by" clause in the query, if at all
		 * the order by clause exists. For eg: select city,winner,team1,team2 from
		 * data/ipl.csv order by city from the query mentioned above, we need to extract
		 * "city". Please note that we can have more than one order by fields.
		 */
		public List<String> getOrderByFields(String queryString) {
			List<String> orderByFields = new ArrayList<String>();
			String[] tempArray;
			if (queryString.contains("order by")) {
				tempArray = queryString.trim().split(" order by ");
				String[] orderByArray = tempArray[1].trim().split(",");
				if (orderByArray.length == 1) {
					orderByFields.add(orderByArray[0]);
				} else {
					for (int i = 0; i < orderByArray.length; i++) {
						orderByFields.add(orderByArray[i]);
					}
				}
			}
			return orderByFields;
		}
		
		/*
		 * extract the group by fields from the query string. Please note that we will
		 * need to extract the field(s) after "group by" clause in the query, if at all
		 * the group by clause exists. For eg: select city,max(win_by_runs) from
		 * data/ipl.csv group by city from the query mentioned above, we need to extract
		 * "city". Please note that we can have more than one group by fields.
		 */
		
		public List<String> getGroupByFields(String queryString) {

			String[] output;
			String[] outputArray;
			List<String> groupByFields = new ArrayList<String>();
			if (queryString.contains("group by")) {
				output = queryString.trim().split(" group by ");
				if (output[1].contains("order by")) {
					String[] str = output[1].trim().split(" order by");
					outputArray = str[0].trim().split(",");
					if (outputArray.length == 1) {
						groupByFields.add(outputArray[0]);
					} else {
						for (int i = 0; i < outputArray.length; i++) {
							groupByFields.add(outputArray[i]);
						}
					}
				} else {
					outputArray = output[1].trim().split(",");
					if (outputArray.length == 1) {
						groupByFields.add(outputArray[0]);
					} else {
						for (int i = 0; i < outputArray.length; i++) {
							groupByFields.add(outputArray[i]);
						}
					}
				}
			}
			return groupByFields;
		}
		/*
		 * extract the selected fields from the query string. Please note that we will
		 * need to extract the field(s) after "select" clause followed by a space from
		 * the query string. For eg: select city,win_by_runs from data/ipl.csv from the
		 * query mentioned above, we need to extract "city" and "win_by_runs". Please
		 * note that we might have a field containing name "from_date" or "from_hrs".
		 * Hence, consider this while parsing.
		 */
		
		public List<String> getFields(String queryString) {
			queryString = queryString.toLowerCase();
			List<String> fields = new ArrayList<String>();
			int index = queryString.length();
			if (queryString.contains("from")) {
				index = queryString.indexOf("from");
			}
			queryString = queryString.substring(6, index);
			String[] str = queryString.trim().split(",");

			if (str.length == 1) {
				fields.add(str[0]);
			} else {
				for (int i = 0; i < str.length; i++) {
					fields.add(str[i]);
				}
			}

			return fields;
		}

		
		
		/*
		 * extract the conditions from the query string(if exists). for each condition,
		 * we need to capture the following: 
		 * 1. Name of field 
		 * 2. condition 
		 * 3. value
		 * 
		 * For eg: select city,winner,team1,team2,player_of_match from data/ipl.csv
		 * where season >= 2008 or toss_decision != bat
		 * 
		 * here, for the first condition, "season>=2008" we need to capture: 
		 * 1. Name of field: season 
		 * 2. condition: >= 
		 * 3. value: 2008
		 * 
		 * the query might contain multiple conditions separated by OR/AND operators.
		 * Please consider this while parsing the conditions.
		 * 
		 */
		
		public List<Restriction> getRestriction(String queryString) {
		       List<Restriction> output = new ArrayList<Restriction>();
		       String result = "";    
		       String[] str = null;
		       if (queryString.contains("where ")) {
		           String[] whereQuery = queryString.split("where ");
		           String outputArray = whereQuery[1];         
		           if (!(outputArray .contains(" group by "))) {
		               if (!(outputArray .contains(" order by"))) {
		                   result = outputArray ;
		               } else {
		                   String[] orderByQuery = outputArray .split(" order by");
		                   result = orderByQuery[0];
		               }
		           } else {
		               String[] groupBySplit =outputArray .split(" group by");
		               result = groupBySplit[0];
		           }
		       } else {
		           output = null;
		       }        String[] conditionalSplit = result.split(" and | or | not ");     
		       if (conditionalSplit  != null) {
		           for (int i = 0; i < conditionalSplit .length; i++) {            
		        	   if (conditionalSplit [i].contains(">")) {
		                   str =conditionalSplit [i].trim().split("\\W+");
		                   String name = str[0];
		                   String Operator = ">";
		                   String value = str[1];
		                   output.add(new Restriction(name, value, Operator));
		               }                else if (conditionalSplit [i].contains("<")) {
		                   str = conditionalSplit[i].trim().split("\\W+");
		                   String name = str[0];
		                   String Operator = "<";
		                   String value = str[1];
		                   output.add(new Restriction(name, value, Operator));
		               } else if (conditionalSplit[i].contains("=")) {
		                   str = conditionalSplit[i].trim().split("\\W+");
		                   String name = str[0];
		                   String Operator = "=";
		                   String value = str[1];
		                   output.add(new Restriction(name, value, Operator));
		               } else if (conditionalSplit [i].contains(">=")) {
		                   str = conditionalSplit [i].trim().split("\\W+");
		                   String name = str[0];
		                   String Operator = ">=";
		                   String value = str[1];
		                   output.add(new Restriction(name, value, Operator));
		               } else if (conditionalSplit[i].contains("<=")) {
		                   str = conditionalSplit[i].trim().split("\\W+");
		                   String name = str[0];
		                   String Operator = "<=";
		                   String value = str[1];
		                   output.add(new Restriction(name, value, Operator));
		               }            }
		       }
		       return output;
		   }
		/*
		 * extract the logical operators(AND/OR) from the query, if at all it is
		 * present. For eg: select city,winner,team1,team2,player_of_match from
		 * data/ipl.csv where season >= 2008 or toss_decision != bat and city =
		 * bangalore
		 * 
		 * the query mentioned above in the example should return a List of Strings
		 * containing [or,and]
		 */
		public List<String> getLogicalOperators(String queryString) {

			List<String> logicalOperators = null;
			
			if (queryString.contains(" where ")) {
				logicalOperators=new ArrayList<String>();
				String[] query = queryString.toLowerCase().split(" ");
				for (int i = 0; i < query.length; i++) {
					if (query[i].contains("where")) {
						for (int j = i + 1; j < query.length; j++) {

							if (query[j].equals("order") && query[j + 1].equals("by")
									|| query[j].equals("group") && query[j + 1].equals("by")) {
								break;
							}
							if (query[j].matches("and") || query[j].matches("or")) {

								logicalOperators.add(query[j]);
							}
						}

					}
				}
			}
			return logicalOperators;
		}
		
		/*
		 * extract the aggregate functions from the query. The presence of the aggregate
		 * functions can determined if we have either "min" or "max" or "sum" or "count"
		 * or "avg" followed by opening braces"(" after "select" clause in the query
		 * string. in case it is present, then we will have to extract the same. For
		 * each aggregate functions, we need to know the following: 
		 * 1. type of aggregate function(min/max/count/sum/avg) 
		 * 2. field on which the aggregate function is being applied
		 * 
		 * Please note that more than one aggregate function can be present in a query
		 * 
		 * 
		 */
		public List<AggregateFunction> getAggregateFunctions(String queryString) {
			List<AggregateFunction> outputString = new ArrayList<AggregateFunction>();
			int selectIndexPosition = queryString.toLowerCase().indexOf("select");
			int fromIndexPosition = queryString.toLowerCase().indexOf(" from");
			String fieldsString = queryString.toLowerCase().substring(selectIndexPosition + 7, fromIndexPosition);
			String[] fieldsArray = fieldsString.split(",");
			for (int j = 0; j < fieldsArray.length; j++) {
				if (fieldsArray[j].startsWith("max(") || fieldsArray[j].startsWith("min(")
						|| fieldsArray[j].startsWith("avg(")
						|| fieldsArray[j].startsWith("sum") && fieldsArray[j].endsWith(")")) {
					outputString.add(new AggregateFunction(fieldsArray[j].substring(4, fieldsArray[j].length() - 1),
							fieldsArray[j].substring(0, 3)));
				} else if (fieldsArray[j].startsWith("count(") && fieldsArray[j].endsWith(")")) {
					outputString.add(new AggregateFunction(fieldsArray[j].substring(6, fieldsArray[j].length() - 1),
							fieldsArray[j].substring(0, 5)));

				}

			}
			return outputString;
		}
		
	}
	

