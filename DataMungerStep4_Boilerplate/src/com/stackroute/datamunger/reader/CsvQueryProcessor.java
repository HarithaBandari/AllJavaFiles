package com.stackroute.datamunger.reader;

import java.awt.List;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.stackroute.datamunger.query.DataTypeDefinitions;
import com.stackroute.datamunger.query.Header;

public class CsvQueryProcessor extends QueryProcessingEngine {
	String fileName;
	BufferedReader br;
	DataTypeDefinitions dataType;
	Header header;

	/*
	 * parameterized constructor to initialize filename. As you are trying to
	 * perform file reading, hence you need to be ready to handle the IO Exceptions.
	 */
	public CsvQueryProcessor(String fileName) throws FileNotFoundException {
		this.fileName = fileName;
		this.header = new Header();
		this.br = new BufferedReader(new FileReader(fileName));
		this.dataType = new DataTypeDefinitions();
	}

	/*
	 * implementation of getHeader() method. We will have to extract the headers
	 * from the first line of the file.
	 */
	@Override
	public Header getHeader() throws IOException {
		br.mark(1);
		if (header.getHeaders() == null) {
			//
			String headString = br.readLine();
			String[] headArray = headString.trim().split(",");
		
			header.setHeaders(headArray);
		}
		// populate the header object with the String array containing the header names
		br.reset();
		return header;

	}

	/**
	 * This method will be used in the upcoming assignments
	 */
	@Override
	public void getDataRow() {

	}

	/*
	 * implementation of getColumnType() method. To find out the data types, we will
	 * read the first line from the file and extract the field values from it. In
	 * the previous assignment, we have tried to convert a specific field value to
	 * Integer or Double. However, in this assignment, we are going to use Regular
	 * Expression to find the appropriate data type of a field. Integers: should
	 * contain only digits without decimal point Double: should contain digits as
	 * well as decimal point Date: Dates can be written in many formats in the CSV
	 * file. However, in this assignment,we will test for the following date
	 * formats('dd/mm/yyyy',
	 * 'mm/dd/yyyy','dd-mon-yy','dd-mon-yyyy','dd-month-yy','dd-month-yyyy','yyyy-mm
	 * -dd')
	 */
	@Override
	public DataTypeDefinitions getColumnType() throws IOException {
		// TODO Auto-generated method stub

		// checking for Integer

		// checking for floating point numbers

		// checking for date format dd/mm/yyyy

		// checking for date format mm/dd/yyyy

		// checking for date format dd-mon-yy

		// checking for date format dd-mon-yyyy

		// checking for date format dd-month-yy

		// checking for date format dd-month-yyyy

		// checking for date format yyyy-mm-dd
		@SuppressWarnings("unused")
		final String headerLine = br.readLine();

		String dataString = "";

		String[] result = new String[18];

		dataString = br.readLine();

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

		dataType.setDataTypes(result);

		return dataType;

	}

}
