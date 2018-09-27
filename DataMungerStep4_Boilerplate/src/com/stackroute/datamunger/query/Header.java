package com.stackroute.datamunger.query;

import java.util.Arrays;

//header class
public class Header {

	/*
	 * this class should contain a member variable which is a String array, to hold
	 * the headers and should override toString() method.
	 */
	String[] headerString;

	public String[] getHeaders() {

		return headerString;
	}

	public void setHeaders(String[] headerString) {

		this.headerString = headerString;
	}

	@Override
	public String toString() {
		return "Header [headerString=" + Arrays.toString(headerString) + "]";
	}

	
	}

