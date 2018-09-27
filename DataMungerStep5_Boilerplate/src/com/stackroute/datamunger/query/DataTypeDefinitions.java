package com.stackroute.datamunger.query;

import java.io.BufferedReader;
//import java.io.FileNotFoundException;
//import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
//import java.util.Arrays;

/*
 * Implementation of DataTypeDefinitions class. This class contains a method getDataTypes() 
 * which will contain the logic for getting the datatype for a given field value. This
 * method will be called from QueryProcessors.   
 * In this assignment, we are going to use Regular Expression to find the 
 * appropriate data type of a field. 
 * Integers: should contain only digits without decimal point 
 * Double: should contain digits as well as decimal point 
 * Date: Dates can be written in many formats in the CSV file. 
 * However, in this assignment,we will test for the following date formats('dd/mm/yyyy',
 * 'mm/dd/yyyy','dd-mon-yy','dd-mon-yyyy','dd-month-yy','dd-month-yyyy','yyyy-mm-dd')
 */
public class DataTypeDefinitions {
	static DataTypeDefinitions dataType;
	static BufferedReader br;
	// method stub
	public static Object getDataType(String input) {
		
		// checking for Integer

		// checking for floating point numbers

		// checking for date format dd/mm/yyyy

		// checking for date format mm/dd/yyyy

		// checking for date format dd-mon-yy

		// checking for date format dd-mon-yyyy

		// checking for date format dd-month-yy

		// checking for date format dd-month-yyyy

		// checking for date format yyyy-mm-dd
		try {
			@SuppressWarnings("unused")
			final String headerLine = br.readLine();
		} catch (IOException e1) {
			
			e1.printStackTrace();
		}

		String dataString = "";

		String[] result = new String[18];

		try {
			dataString = br.readLine();
		} catch (IOException e1) {
			
			e1.printStackTrace();
		}

		dataString += " ";
		String[] dataArray = dataString.split(",");

		for (int j = 0; j < dataArray.length; j++)

			if (dataArray[j].matches("[+-]?[0-9][0-9]*")) {
				int i = Integer.parseInt(dataArray[j]);
				result[j] = ((Object) i).getClass().getName();
			} else if (dataArray[j].matches("[+-]?[0-9]+(\\\\.[0-9]+)?([Ee][+-]?[0-9]+)?")) {
				int i = Integer.parseInt(dataArray[j]);
				result[j] = ((Object) i).getClass().getName();
			}

			else if (dataArray[j].matches("\\d{4}-\\d{2}-\\d{2}")) {
				SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-mm-dd");
				java.util.Date date1 = null;

				try {
					date1 = formatter1.parse(dataArray[j]);
				} catch (ParseException e) {

					e.printStackTrace();
				}

				result[j] = ((Object) date1).getClass().getName();
			} else if (dataArray[j].matches("\\s")) {

				result[j] = dataType.getClass().getSuperclass().getName();
			}

			else {
				result[j] = dataArray[j].getClass().getName();
			}

		//dataType.setDataTypes(result);

		

		
return dataType;
	}

}
