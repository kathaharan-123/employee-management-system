package com.example.jdbc_mysql_practice;

import java.util.Scanner;

public class InputUtil {
	
	public static int readInt(Scanner scanner,String message) {
		
		while(true) {
			
			System.out.print(message+" : ");
			String input = scanner.nextLine();
			
			try {
				
				int result = Integer.parseInt(input);
				
				if(result<=0) {
					
					System.out.println("Enter positive value!");
					
				}
				else {
					
					return result;
					
				}
				
			}
			catch(NumberFormatException e) {
				
				System.out.println("Enter valid input.");
				
			}
		}
	}
	
	public static String readString(Scanner scanner,String message) {
		
		while(true) {
				
			System.out.print(message+" : ");
			String input = scanner.nextLine().trim();
				
			if(input.isEmpty()) {
					
				System.out.println(message+" cannot be empty!");
					
			}
			else {
					
				return input;
					
			}
		}
	}
}
