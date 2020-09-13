package com;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		List<String> results = new ArrayList<>();
		for(int i=0; i<N; i++){//编号i的测试组
			int n = in.nextInt();
			int m = in.nextInt();
			int k = in.nextInt();
			Set<Integer> linked = new HashSet<>();//连通的岛
			for(int j=0; j<m; j++){//输入桥
				int a = in.nextInt();
				int b = in.nextInt();
				int kk = in.nextInt();
				if(kk<=k&&linked.size()<n){
					linked.add(a);
					linked.add(b);
				}
			}

			if(linked.size()<n){
				results.add("No");
			}else{
				results.add("Yes");
			}
		}
		for(String s : results){
			System.out.println(s);
		}
	}
}
