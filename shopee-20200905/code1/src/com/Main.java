package com;

import java.util.Scanner;

public class Main {

	public static String camelCase(String s){
		String[] tokens = s
				.replaceAll("'|", "")
				.split("[\\W_]+|(?<=[a-z])(?=[A-Z][a-z])");
		s = "";
		for(String token : tokens){
			String lowercaseToken = token.toLowerCase();
			s += tokens[0].equals(token)?lowercaseToken:lowercaseToken.toUpperCase().charAt(0)+lowercaseToken.substring(1);
		}
		return s;
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String str = in.nextLine();
		System.out.println(camelCase(str));
	}
}
