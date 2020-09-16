package com;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();

		System.out.println(nUgly(n));
	}
	public static int nUgly(int n){
		int i=1,x=2;
		while(i<n){
			if(isUgly(x)){
				i++;
				//System.out.println(x);
				++x;
			}else{
				++x;
			}
		}
		return x-1;
	}
	public static boolean isUgly(int x) {
		if(x<1){
			return false;
		}
		if(x==1){
			return true;
		}
		while(x%2==0){
			x=x/2;
		}
		while(x%3==0){
			x=x/3;
		}
		while(x%5==0){
			x=x/5;
		}
		return x==1;
	}

}
