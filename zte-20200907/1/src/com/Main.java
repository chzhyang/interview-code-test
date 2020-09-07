package com;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt(), m = in.nextInt();
		if(n<1||m<1){
			return;
		}
		int[][] p = new int [m][n];
		float[] q = new float[m];//每门课总分
		for(int j=0; j<m; j++){
			for(int i=0; i<n; i++){
				p[j][i] = in.nextInt();
				q[j] += (float)p[j][i];
			}
			q[j]=(float)q[j]/n;
		}
		int cnt=0;
		for (int i = 0; i < n; i++){
			 for(int j=0; j < m; j++) {
				if((float)p[j][i] > q[j]){
					cnt++;
					break;
				}
			}
		}
		System.out.println(cnt);
	}
}
