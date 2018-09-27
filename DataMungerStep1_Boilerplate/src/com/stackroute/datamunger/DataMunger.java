package com.stackroute.datamunger;

/*There are total 5 DataMungertest files:
 * 
 * 1)DataMungerTestTask1.java file is for testing following 3 methods
 * a)getSplitStrings()  b) getFileName()  c) getBaseQuery()
 * 
 * Once you implement the above 3 methods,run DataMungerTestTask1.java
 * 
 * 2)DataMungerTestTask2.java file is for testing following 3 methods
 * a)getFields() b) getConditionsPartQuery() c) getConditions()
 * 
 * Once you implement the above 3 methods,run DataMungerTestTask2.java
 * 
 * 3)DataMungerTestTask3.java file is for testing following 2 methods
 * a)getLogicalOperators() b) getOrderByFields()
 * 
 * Once you implement the above 2 methods,run DataMungerTestTask3.java
 * 
 * 4)DataMungerTestTask4.java file is for testing following 2 methods
 * a)getGroupByFields()  b) getAggregateFunctions()
 * 
 * Once you implement the above 2 methods,run DataMungerTestTask4.java
 * 
 * Once you implement all the methods run DataMungerTest.java.This test case consist of all
 * the test cases together.
 */

public class DataMunger {

	/*
	 * This method will split the query string based on space into an array of words
	 * and display it on console
	 */

	public String[] getSplitStrings(String queryString) {
		String[] str1 = queryString.toLowerCase().trim().split(" ");

		return str1;

	}

	/*
	 * Extract the name of the file from the query. File name can be found after a
	 * space after "from" clause. Note: ----- CSV file can contain a field that
	 * contains from as a part of the column name. For eg: from_date,from_hrs etc.
	 * 
	 * Please consider this while extracting the file name in this method.
	 */

	public String getFileName(String queryString) {

		String[] s = queryString.split("from");
		String s1 = s[1];
		String[] s2 = s1.split(" ");
		String s3 = null;
		s3 = s2[1];
		return s3;

	}

	/*
	 * This method is used to extract the baseQuery from the query string. BaseQuery
	 * contains from the beginning of the query till the where clause
	 * 
	 * Note: ------- 1. The query might not contain where clause but contain order
	 * by or group by clause 2. The query might not contain where, order by or group
	 * by clause 3. The query might not contain where, but can contain both group by
	 * and order by clause
	 */

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
	 * This method will extract the fields to be selected from the query string. The
	 * query string can have multiple fields separated by comma. The extracted
	 * fields will be stored in a String array which is to be printed in console as
	 * well as to be returned by the method
	 * 
	 * Note: 1. The field name or value in the condition can contain keywords as a
	 * substring. For eg: from_city,job_order_no,group_no etc. 2. The field name can
	 * contain '*'
	 * 
	 */

	public String[] getFields(String queryString) {
		queryString = queryString.toLowerCase();
		
		int index = queryString.length();
		if (queryString.contains("from")) {
			index = queryString.indexOf("from");
		}
		queryString = queryString.substring(6, index);
		String[] str=queryString.trim().split(",");
		return str ;
	}

	/*
	 * This method is used to extract the conditions part from the query string. The
	 * conditions part contains starting from where keyword till the next keyword,
	 * which is either group by or order by clause. In case of absence of both group
	 * by and order by clause, it will contain till the end of the query string.
	 * Note: 1. The field name or value in the condition can contain keywords as a
	 * substring. For eg: from_city,job_order_no,group_no etc. 2. The query might
	 * not contain where clause at all.
	 */

	public String getConditionsPartQuery(String queryString) {
		String query=queryString.toLowerCase();
		if (query.contains(" where ")) {
	           String[] condition = query.split("where | group by | order by");
	           return condition[1].trim();
	       } else
	           return null;
		
		
		
	}	

	/*
	 * This method will extract condition(s) from the query string. The query can
	 * contain one or multiple conditions. In case of multiple conditions, the
	 * conditions will be separated by AND/OR keywords. for eg: Input: select
	 * city,winner,player_match from ipl.csv where season > 2014 and city
	 * ='Bangalore'
	 * 
	 * This method will return a string array ["season > 2014","city ='bangalore'"]
	 * and print the array
	 * 
	 * Note: ----- 1. The field name or value in the condition can contain keywords
	 * as a substring. For eg: from_city,job_order_no,group_no etc. 2. The query
	 * might not contain where clause at all.
	 */

	public String[] getConditions(String queryString) {
			queryString = queryString.toLowerCase();
	
			String[] query = this.getSplitStrings(queryString);
			String out = "";
			if (queryString.contains(" where ")) {
				for (int i = 0; i < query.length; i++) {
					if (query[i].contains("where")) {
						for (int j = i + 1; j < query.length; j++) {
							if (query[j].contains("order") && query[j + 1].contains("by")
									|| query[j].contains("group") && query[j + 1].contains("by")) {
								break;
							}
							out += query[j] + " ";
						}
						break;
					}
				}
				String output[] = out.trim().split(" and | or | not |;");
				return output;
			}
			return null;
			}

	/*
	 * This method will extract logical operators(AND/OR) from the query string. The
	 * extracted logical operators will be stored in a String array which will be
	 * returned by the method and the same will be printed Note: 1. AND/OR keyword
	 * will exist in the query only if where conditions exists and it contains
	 * multiple conditions. 2. AND/OR can exist as a substring in the conditions as
	 * well. For eg: name='Alexander',color='Red' etc. Please consider these as well
	 * when extracting the logical operators.
	 * 
	 */

	public String[] getLogicalOperators(String queryString) {
		queryString=queryString.toLowerCase();
		
		String[] query = this.getSplitStrings(queryString);
		String out = "";
		if (queryString.contains(" where ")) {
			for (int i = 0; i < query.length; i++) {
				if (query[i].matches("and|or")) {
					out += query[i] + " ";
				}
			}
			return out.split(" ");
		}
		return null;
	}

	/*
	 * This method extracts the order by fields from the query string. Note: 1. The
	 * query string can contain more than one order by fields. 2. The query string
	 * might not contain order by clause at all. 3. The field names,condition values
	 * might contain "order" as a substring. For eg:order_number,job_order Consider
	 * this while extracting the order by fields
	 */

	public String[] getOrderByFields(String queryString) {
		queryString = queryString.toLowerCase();
		queryString = queryString.toLowerCase();
		String[] query = this.getSplitStrings(queryString);
		String out = "";
		if (queryString.contains(" order by ")) {
			for (int i = 0; i < query.length; i++) {
				if (query[i].contains("order") && query[i + 1].contains("by")) {
					for (int j = i + 2; j < query.length; j++) {
						if (query[j].contains(";")) {
							break;
						}
						out += query[j] + " ";
					}
				}
			}
			String output[] = out.trim().split(" |, ");
			return output;
		}
		return null;
	}

	
	/*
	 * This method extracts the group by fields from the query string. Note: 1. The
	 * query string can contain more than one group by fields. 2. The query string
	 * might not contain group by clause at all. 3. The field names,condition values
	 * might contain "group" as a substring. For eg: newsgroup_name
	 * 
	 * Consider this while extracting the group by fields
	 */

	public String[] getGroupByFields(String queryString) {
		
		
		queryString = queryString.toLowerCase();
		String[] query = this.getSplitStrings(queryString);
		String out = "";
		if (queryString.contains(" group by")) {
			for (int i = 0; i < query.length; i++) {
				if (query[i].contains("group") && query[i + 1].contains("by")) {
					for (int j = i + 2; j < query.length; j++) {
						if (query[j].contains(";")) {
							break;
						}
						out += query[j] + " ";
					}
				}
			}
			String output[] = out.trim().split(" |,");
			return output;
		}
	return null;
}
	
	

	/*
	 * This method extracts the aggregate functions from the query string. Note: 1.
	 * aggregate functions will start with "sum"/"count"/"min"/"max"/"avg" followed
	 * by "(" 2. The field names might contain"sum"/"count"/"min"/"max"/"avg" as a
	 * substring. For eg: account_number,consumed_qty,nominee_name
	 * 
	 * Consider this while extracting the aggregate functions
	 */

	public String[] getAggregateFunctions(String queryString) {
		queryString=queryString.toLowerCase();
		
				 String out = "";
			       boolean bool = false;
			       String[] intialArray = queryString.split(" ");
			       String[] temporaryArray = intialArray[1].split(",");
			       for (int i = 0; i < temporaryArray.length; i++) {
			           if ((temporaryArray[i].startsWith("max(") && temporaryArray[i].endsWith(")"))//Conditional check for aggregate functions
			                   || (temporaryArray[i].startsWith("min(") && temporaryArray[i].endsWith(")"))
			                   || (temporaryArray[i].startsWith("count(") && temporaryArray[i].endsWith(")"))
			                   || (temporaryArray[i].startsWith("avg(") && temporaryArray[i].endsWith(")"))
			                   || (temporaryArray[i].startsWith("sum(") && temporaryArray[i].endsWith(")"))) {
			               out += temporaryArray[i] + " ";
			               bool = true;
			           }
			       }
	
			       String output[] = out.trim().split(" ");// trim the spaces and split by space
			       if (bool)
			    	   return output;
				return null;
			     	}
	
}

