package com;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		boolean[] res = new boolean[N];
		for(int i=0; i<N; i++){
			int n = in.nextInt();
			int m = in.nextInt();
			int k = in.nextInt();
			int[] nums = new int[n];
			for(int j=0; j<n;j++){
				nums[j]=in.nextInt();
			}
			res[i] = get(nums,m,k);
		}
		for(boolean r : res){
			if(r){
				System.out.println("Yes");
			}else{
				System.out.println("No");
			}
		}
	}

	public static boolean get(int[] nums, int m, int k) {
		int cnt = 0;
		for(int i=0;i<nums.length;i++){
			if(nums[i]%k==0){
				cnt++;
			}
			if(cnt>=m){
				return true;
			}
		}
		return cnt>=m;
	}

}
