package com;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			list.add(in.nextInt());
		}
		Collections.sort(list);//up sort
		int[][] result = new int[n][n];//dp table
		btree(list, result, n);
		System.out.println(result[0][n - 1]);
	}

	public static void btree(List<Integer> list, int[][] result, int n) {
		for (int i = 0; i < n; i++) {
			result[i][i] = 1;
		}
		for (int len = 2; len <= n; len++) {//length从1到n构建dp
			for (int i = 0; i < len; i++) {
				for (int j = i + 1; j < len; j++) {
					for (int k = i; k <= j; k++) {//left=i,right=j,从左到右各元素依次作为root
						if (k > i && list.get(k) == list.get(k - 1)) {
							continue;
						}
						if (k > i && k < j) {
							result[i][j] += result[i][k - 1] * result[k + 1][j];
						} else if (k == i) {
							result[i][j] += result[k + 1][j];
						} else if (k == j) {
							result[i][j] += result[i][k - 1];
						}
					}
				}
			}
		}
	}
}