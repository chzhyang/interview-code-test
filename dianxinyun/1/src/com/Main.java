package com;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String s = in.nextLine();
		if(s==null){
			return;
		}
		List<Character> list = new LinkedList<>();
		Map<Character,Integer> map = new HashMap<>();
		for(int i=0; i<s.length(); i++){
			char c = s.charAt(i);
			list.add(c);
			if(!map.containsKey(c)){
				map.put(c,1);
			}else{
				map.put(c,map.get(c)+1);
			}
		}
		//查找
		int min = Integer.MAX_VALUE;
		for(Integer cnt : map.values()){
			if(min>cnt){
				min = cnt;
			}
		}
		// 删除
		for(int i=0; i<list.size(); i++){
			char c = list.get(i);
			int k = map.get(c);
			if(k==min){
				list.remove(i--);
			}
		}
		if(list.size()==0){
			return;
		}
		for(int i=0; i<list.size(); i++){
			if(i<list.size()-1){
				System.out.print(list.get(i));
			}else{
				System.out.println(list.get(i));
			}
		}

	}

}
