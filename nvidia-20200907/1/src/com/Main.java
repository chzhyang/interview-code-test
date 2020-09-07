package com;

import java.util.Scanner;

public class Main {
	static int len = 100001;
	static int[] cnt = new int[len];

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		getPrime();
		while(in.hasNext()){
			int n= in.nextInt();

			System.out.println(cnt[n]);
		}
	}
	public static void getPrime(){
		boolean[] v = new boolean[len];
		int[] list = new int[len];
		int c =0;
		for(int i=2; i<len; i++){
			if(!v[i]){
				list[c++] = i;
				for(int j =i<<1; j<len; j+=i){
					v[j]=true;
				}
			}
		}
		for(int i=0; i<c; i++){
			for(int j=i+1; j<c; j++){
				if(list[i]+list[j]>len){
					break;
				}
				cnt[list[i]+list[j]]++;
			}
		}
	}

}
