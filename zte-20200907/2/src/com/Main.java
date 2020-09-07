package com;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static int findUp(List arr, int m){
		if(arr==null || m<2){
			return 0;
		}
		int cnt=0;
		if(m==2){
			if((int)arr.get(0)<(int)arr.get(1)){
				return 0;
			}else{
				return 1;
			}
		}
		//m>=3
		int i = 0, j =1, k=2;
		while( k<m){
			int p = (int)arr.get(i);
			int q = (int)arr.get(j);
			int g = (int)arr.get(k);
			if(p<q&&q<g){
				i=j;
				j=k;
				k++;
			}else{
				cnt++;
				j++;
				k++;
			}
		}
		return cnt;
	}
	public static int findDown(List arr, int m){
		if(arr==null || m<2){
			return 0;
		}
		int cnt=0;
		if(m==2){
			if((int)arr.get(0)>(int)arr.get(1)){
				return 0;
			}else{
				return 1;
			}
		}
		//m>=3
		int i = 0, j =1, k=2;
		while( k<m){
			int p = (int)arr.get(i);
			int q = (int)arr.get(j);
			int g = (int)arr.get(k);
			if(p>q&&q>g){
				i=j;
				j=k;
				k++;
			}else{
				cnt++;
				j++;
				k++;
			}
		}
		return cnt;
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int cnt=0;//结果

		for(int i=0; i<n; i++){
			int m = in.nextInt();
			if(m<=0){
				continue;
			}
			List<Integer> arr = new ArrayList<>();
			for(int j=0; j<m; j++){
				arr.add(in.nextInt());
			}
			//处理
			System.out.println(Math.min(findUp(arr,m),findDown(arr,m)));
		}

	}

}
