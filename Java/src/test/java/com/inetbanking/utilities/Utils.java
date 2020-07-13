package com.inetbanking.utilities;

import org.apache.commons.lang3.RandomStringUtils;

public class Utils {
	
	public static String randomemail() {
		
		int length = 10;
	    boolean useLetters = true;
	    boolean useNumbers = false;
	    String generatedString = RandomStringUtils.random(length, useLetters, useNumbers);
	    
		return generatedString;
	}

}
