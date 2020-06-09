package com.stringCalculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

	public static int add(String line) {
		if (line.isEmpty())
			return 0;
		else if (line.contains(",") || line.contains("\n")) {
			if (line.startsWith("//")) {
				Matcher m1 = Pattern.compile("//(.)\n(.*)").matcher(line);
				if (m1.matches()) {
					String customDelimeter1 = m1.group(1);
					String numbers1 = m1.group(2);
					int sum1 = sumOfNumbersWithCustomDelimiter(numbers1, customDelimeter1);
					return sum1;
				}
				Matcher m2 = Pattern.compile("//(.+)\n((.+)*)").matcher(line);
				if (m2.matches()) {
					String customDelimeter2 = m2.group(1);
					String numbers2 = m2.group(2);
					int sum2 = sumOfNumbersWithCustomDelimiterofVariableLengths(numbers2, customDelimeter2);
					return sum2;
				} else
					return 0;
			} else {
				int sumOfNumbers = sumOfMultipleNumbers(line);
				return sumOfNumbers;
			}
		} else
			return Integer.parseInt(line);
	}

	private static int sumOfNumbersWithCustomDelimiter(String numbers, String customDelimiter) {
		String[] numbersFromCustomDelimiter = numbers.split(customDelimiter);
		int sum = calculateSum(numbersFromCustomDelimiter);
		return sum;
	}

	private static int sumOfNumbersWithCustomDelimiterofVariableLengths(String numbers, String customDelimiter) {
		String[] numbersFromCustomDelimiter = numbers.split(customDelimiter);
		int sum = calculateSum(numbersFromCustomDelimiter);
		return sum;
	}

	private static int sumOfMultipleNumbers(String numbers) {
		String[] newNumbers = numbers.split(",|\n");
		int sum = calculateSum(newNumbers);
		return sum;
	}

	private static int calculateSum(String[] newNumbers) {
		int sum = 0,count=0;
		String negatives="";
		String allNegatives="";
		for (int i = 0; i < newNumbers.length; i++) {
			
				if (Integer.parseInt(newNumbers[i]) < 0) {
					count++;
					allNegatives=allNegatives+negatives.concat(newNumbers[i]);
				}
			
			if (Integer.parseInt(newNumbers[i]) > 1000) {
				continue;
			} else
				sum += Integer.parseInt(newNumbers[i]);
		}
		
		if(count>0) {
			throw new RuntimeException("Negatives not allowed"+allNegatives);
		}
		return sum;
	}
}