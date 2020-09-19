package com;

import java.util.*;

class Node implements Comparable<Node>{
	int val;
	int idx;
	char set;
	Node(int x, int y, char z){
		val=x;
		idx=y;
		set=z;
	}

	@Override
	public int compareTo(Node o) {
		if(val<o.val){
			return -1;
		if(val<o.val){
			return 1;
		}
		if(val==o.val){
			if(idx<o.idx){
				return -1;
			}
			if(idx>o.idx){
				return 1;
			}
			if(idx==o.idx){
				if(set=='A'){
					return -1;
				}
				if(set=='B'){
					return 1;
				}
			}
		}
	}
}
public class Solution {
	/**
	 * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
	 * 实现Sort Merge Join
	 * @param setA int整型ArrayList
	 * @param setB int整型ArrayList
	 * @return int整型ArrayList<ArrayList<>>
	 */
	public ArrayList<ArrayList<Integer>> sortMergeJoin (ArrayList<Integer> setA, ArrayList<Integer> setB) {
		// write code here
		//重组
		ArrayList<Node> list = new ArrayList<>();
		for(int i=0; i<setA.size();i++){
			Node node =new Node(setA.get(i), i, 'A');
			list.add(node);
		}
		for(int i=0; i<setB.size();i++){
			Node node =new Node(setB.get(i), i, 'B');
			list.add(node);
		}
		//排序
		Collections.sort(list);
		//遍历
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		for(int i=0; i<list.size(); i++){
			int a = list.get(i).val;
		}
	}
}