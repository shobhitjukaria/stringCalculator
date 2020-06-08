package com.stringCalculator;

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
}
