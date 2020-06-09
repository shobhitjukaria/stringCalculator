package com.stringCalculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

	public static int add(String line) {
		if(line.isEmpty())
			return 0;
		else if(line.contains(",") || line.contains("\n")) {
			if(line.startsWith("//")) {
				Matcher m = Pattern.compile("//(.)\n(.*)").matcher(line);
				m.matches();
				String customDelimeter = m.group(1);
				String numbers=m.group(2);
				int sum = sumOfNumbersWithCustomDelimiter(numbers,customDelimeter);
				return sum;
			}
			else {
			int sumOfNumbers = sumOfMultipleNumbers(line);
			return sumOfNumbers;
			}
		}
		else
			return Integer.parseInt(line);
		}

	private static int sumOfNumbersWithCustomDelimiter(String numbers, String customDelimiter) {
		String[] numbersFromCustomDelimiter=numbers.split(customDelimiter);
		int sum=calculateSum(numbersFromCustomDelimiter);
		return sum;
	}

	private static int sumOfMultipleNumbers(String numbers) {
		String[] newNumbers = numbers.split(",|\n");
		int sum = calculateSum(newNumbers);
		return sum;
	}

	private static int calculateSum(String[] newNumbers) {
		int sum=0;
		for(int i=0;i<newNumbers.length;i++) {
			try {
			if(Integer.parseInt(newNumbers[i]) < 0) {
				throw new RuntimeException();}
			}
			catch(RuntimeException e) {
				System.out.println("Negatives Not allowed" );
			}
			
			sum+=Integer.parseInt(newNumbers[i]);
		}
		return sum;
		}
	
	
	}

