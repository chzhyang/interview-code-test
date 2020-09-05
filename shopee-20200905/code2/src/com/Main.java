package com;

import java.util.*;

public class Main {
	/**
	 * 倒序查找，找到第一个数字x，条件是x后边的数字中有一个数字y<x
	 */
	public static StringBuilder solution(String s) {
		StringBuilder sb = new StringBuilder(s);
		int len = sb.length();//0-len-1
		ArrayList<Integer> list = new ArrayList<>();
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		//Queue<Integer> maxH = new PriorityQueue<>(1000,(i1, i2) -> i2 - i1);//大根堆
		for(int i=len-1; i>=0; i--){
			int x = sb.charAt(i) - '0';
			if(i==0){
				max=x;
				min=x;
			}
			else if(x <= min){
				list.add(x);
				min = x;
				continue;
			}else {//list中找到比x小的最大值
				sb.setCharAt(i, (char)max);
				list.add(x);
				list.remove(max);
				Collections.sort(list,(o1, o2) -> o2 - o1);//降序
				int h = 0;
				for(int j=i-1,; j<len; j++){
					int t = list.get(h++);
					sb.setCharAt(j,(char)t);
				}
			}
		}
		return sb;
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String s = in.nextLine();
		if(s!=null) {
			System.out.println(solution(s));
		}

	}

}
