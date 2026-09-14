package de.bcxp.challenge;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import de.bcxp.challenge.Utils.FormatterUtils;

public class TestFormatterUtils {
	
	@Test
	public void TestStringNumberNormalizationInEuropeanFormat() {
		var testNumber = "123456789";
		assertTrue(FormatterUtils.normalizeStringNumberInEuropeanFormat(testNumber).equals("123456789"));
		
		testNumber = "1234567,89";
		assertTrue(FormatterUtils.normalizeStringNumberInEuropeanFormat(testNumber).equals("1234567.89"));
		
		testNumber = "1.234.567,89";
		assertTrue(FormatterUtils.normalizeStringNumberInEuropeanFormat(testNumber).equals("1234567.89"));
		
		testNumber = "0,123";
		assertTrue(FormatterUtils.normalizeStringNumberInEuropeanFormat(testNumber).equals("0.123"));
	}
}
