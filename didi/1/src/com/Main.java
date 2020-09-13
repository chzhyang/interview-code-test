package com;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int k = in.nextInt();
		in.nextLine();
		String s = in.nextLine();
		if(k<0 || s == null){
			return;
		}
		solution(s,k);
	}

	public static void solution(String s, int k) {
		if(k==0) {
			System.out.println(s);
			return;
		}
		int n = s.length();
		if(k>=n) {
			System.out.println(new StringBuilder(s).reverse().toString());
			return;
		}
		int left=0, end=left+k;
		//List<String> list = new ArrayList<>();
		while(end<n){
			String sub = s.substring(left,end);
			//list.add(new StringBuilder(sub).reverse().toString());
			System.out.print(new StringBuilder(sub).reverse().toString());
			left = end;
			end = left + k;
		}
		if(n%k != 0){
			String sub = s.substring(left,n);
			//list.add(new StringBuilder(sub).reverse().toString());
			System.out.print(new StringBuilder(sub).reverse().toString());
		}
	}

}
