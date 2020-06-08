package com.stringCalculator;

public class StringCalculator {

	public static int add(String numbers) {
		if(numbers.isEmpty())
			return 0;
		else if(numbers.contains(",")) {
			String[] newNumbers = numbers.split(",");
			return Integer.parseInt(newNumbers[0])+Integer.parseInt(newNumbers[1]);
		}
		else
			return Integer.parseInt(numbers);
		}

	
}
