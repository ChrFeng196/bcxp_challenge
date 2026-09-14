package de.bcxp.challenge.Utils;

public class FormatterUtils {
	public static String normalizeStringNumberInEuropeanFormat(String stringNumber) {
	    if (stringNumber.contains(".") && stringNumber.contains(",")) {
	        // Remove thousand separators
	    	stringNumber = stringNumber.replace(".", "");
	        // Convert decimal comma to decimal point
	    	stringNumber = stringNumber.replace(",", ".");
	        return stringNumber;
	    }
	    
	    if (!stringNumber.contains(".") && stringNumber.contains(",")) {
	        // Convert decimal comma to decimal point
	    	stringNumber = stringNumber.replace(",", ".");
	        return stringNumber;
	    }
	    
	    if (stringNumber.contains(".") && !stringNumber.contains(",")) {
	    	// Remove thousand separators
	    	stringNumber = stringNumber.replace(".", "");
	        return stringNumber;
	    }

	    return stringNumber;
	}
}
