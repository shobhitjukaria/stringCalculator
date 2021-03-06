package com.stringCalculator;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;


public class StringCalculatorTest {
	@Test
	public void checkForEmptyString(){
	Assert.assertEquals(0, StringCalculator.add(""));
	}
	
	@Test
	public void checkForSingleNumber(){
	Assert.assertEquals(2, StringCalculator.add("2"));
	}
	
	@Test
	public void sumOfTwoNumbers(){
	Assert.assertEquals(5, StringCalculator.add("2,3"));
	}
	
	@Test
	public void sumOfMultipleNumbers(){
	Assert.assertEquals(12, StringCalculator.add("2,3,4,3"));
	}
	
	@Test
	public void sumOfMultipleNumbersWithNewLineDelimiter(){
	Assert.assertEquals(5, StringCalculator.add("2\n3"));
	Assert.assertEquals(16, StringCalculator.add("2,3\n4,7"));
	}
	
	@Test
	public void sumOfMultipleNumbersWithCustomDelimiter(){
	Assert.assertEquals(3, StringCalculator.add("//;\n1;2"));
	}
	
	@Test
	public void checkForNegativeNumbers(){
		try {
		StringCalculator.add("-1,-2\n-3");
	}catch(RuntimeException e) {
		assertEquals("Negatives not allowed-1-2-3", e.getMessage());
	}
		}
	
	@Test
	public void removeNumbersGreaterThanThousand(){
	Assert.assertEquals(10, StringCalculator.add("1001,3,4,3"));
	}
	
	@Test
	public void sumOfNumbersWithCustomDelimiterWithVariableLength(){
	Assert.assertEquals(6, StringCalculator.add("//;;;\n1;;;2;;;3"));
	}
	
}