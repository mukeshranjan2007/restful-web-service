package com.rest.webservice.restfulwebservice;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DateExample {

	public static void main(String[] args) {
		
		/*
		 * DateUtil util=new DateUtil();
		 * 
		 * Date d=util.stringToDate("05-2-2021");
		 * 
		 * System.out.println("Date " +d);
		 */
		
		
		
		
		// TODO Auto-generated method stub

		
		/*
		 * String inputDate="201-091-09";
		 * 
		 * Date formatDate=extractTimestampInput(inputDate);
		 * 
		 * if(formatDate==null){ System.out.println("Date Format not found"); }else {
		 * System.out.println(formatDate); }
		 */
		 
		
		

	}

	@SuppressWarnings("deprecation")
	public static Date extractTimestampInput(String strDate) {
		List<SimpleDateFormat> knownPatterns = new ArrayList();
		knownPatterns.add(new SimpleDateFormat("yyyy-MM-dd"));
		knownPatterns.add(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'"));
		knownPatterns.add(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm.ss'Z'"));
		knownPatterns.add(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"));
		knownPatterns.add(new SimpleDateFormat("yyyy-MM-dd' 'HH:mm:ss"));
		knownPatterns.add(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX"));

		for (SimpleDateFormat pattern : knownPatterns) {
			try {
				// Take a try
				return new Date(pattern.parse(strDate).getTime());

			} catch (ParseException pe) {
				// Loop on
				// System.out.println("Pattern Not Found");

			}

			
		}
		return new Date(null);
	}

}
