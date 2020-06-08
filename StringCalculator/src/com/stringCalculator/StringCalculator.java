package com.stringCalculator;

public class StringCalculator {

	public static int add(String numbers) {
		if(numbers.isEmpty())
			return 0;
		else if(numbers.contains(",") || numbers.contains("\n")) {
			int sumOfNumbers = sumOfMultipleNumbers(numbers);
			return sumOfNumbers;
		}
		else
			return Integer.parseInt(numbers);
		}

	private static int sumOfMultipleNumbers(String numbers) {
		int sum=0;
		String[] newNumbers = numbers.split(",|\n");
		for(int i=0;i<newNumbers.length;i++) {
			sum+=Integer.parseInt(newNumbers[i]);
		}
		return sum;
	}
	
	
}
