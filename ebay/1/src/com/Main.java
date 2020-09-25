package com;

import java.util.Scanner;
import java.lang.Math;
public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		System.out.println(fun(n));
	}

	public static int fun(int n) {
		// TODO:
		int res = 0;
		double kk = Math.log((double)n)/Math.log((double)2);
		int k = (int)Math.floor(kk);
		if(n==0){
			return 1;
		}
		if(n==1){
			return 1;
		}
		if(n==2){
			return 2;
		}

		for(int i=0; i<=k;i++){
			res += fun(n-(int)Math.pow(2,i));
		}
		return res;
	}

}
