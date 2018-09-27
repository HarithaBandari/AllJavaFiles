package com.stackroute.datamunger.reader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.stackroute.datamunger.query.DataTypeDefinitions;
import com.stackroute.datamunger.query.Header;

public class CsvQueryProcessor extends QueryProcessingEngine {
	String fileName;
	BufferedReader br;
	DataTypeDefinitions dataType;
	Header header;

	// Parameterized constructor to initialize filename
	public CsvQueryProcessor(String fileName) throws FileNotFoundException {
		this.fileName = fileName;
		this.header = new Header();
		this.br = new BufferedReader(new FileReader(fileName));
		this.dataType = new DataTypeDefinitions();
	}

	/*
	 * Implementation of getHeader() method. We will have to extract the headers
	 * from the first line of the file. Note: Return type of the method will be
	 * Header
	 */

	@Override
	public Header getHeader() throws IOException {
		br.mark(1);
		if (header.getHeaders() == null) {
			//
			String headString = br.readLine();
			String[] headArray = headString.trim().split(",");
//for(String s:headArray) {
//	System.out.println(s);
//}
//		
			header.setHeaders(headArray);
		}
		// populate the header object with the String array containing the header names
		br.reset();
		return header;

	}

	/**
	 * getDataRow() method will be used in the upcoming assignments
	 */

	@Override
	public void getDataRow() {

	}

	/*
	 * Implementation of getColumnType() method. To find out the data types, we will
	 * read the first line from the file and extract the field values from it. If a
	 * specific field value can be converted to Integer, the data type of that field
	 * will contain "java.lang.Integer", otherwise if it can be converted to Double,
	 * then the data type of that field will contain "java.lang.Double", otherwise,
	 * the field is to be treated as String. Note: Return Type of the method will be
	 * DataTypeDefinitions
	 */

	@Override
	public DataTypeDefinitions getColumnType() throws IOException {
		@SuppressWarnings("unused")
		final String headerLine = br.readLine();

		
		String dataString = "";

		String[] result = new String[18];
		if (dataString != null) {
			dataString = br.readLine();
		}

		dataString += " ";
		String[] dataArray = dataString.split(",");

		for (int j = 0; j < dataArray.length; j++)
			if (isInteger(dataArray[j])) {
				int i = Integer.parseInt(dataArray[j]);
				result[j] = ((Object) i).getClass().getName();
			} else {
				result[j] = dataArray[j].getClass().getName();
			}

		dataType.setDataTypes(result);

		return dataType;

	}

	boolean isInteger(String s) {
		boolean isInteger = false;
		try {
			Integer.parseInt(s);
			isInteger = true;
		} catch (NumberFormatException ex) {

		}

		return isInteger;

	}

}
