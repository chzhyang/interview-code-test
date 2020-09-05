package com;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Iterator;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		in.nextLine();
		HashMap<Integer, HashSet> map = new HashMap<>();//k，v=hashcode，指向一个hashset
		//输入map
		for(int i=0; i<n; i++){
			String[] s = in.nextLine().split(" ");
			//System.out.println("in:"+s[1]+":"+s[0]);
			int hc = s[1].hashCode();
			if(!map.containsKey(hc)) {//不存在的name
				HashSet<String> hs = new HashSet<>();
				hs.add(s[0]);
				map.put(hc, hs);
			}else{//存在name
				HashSet set = map.get(hc);
				if(!set.contains(s[0])){//重名，不重id
					set.add(s[0]);
				}
			}
		}
		//遍历map查找
		int cnt=0;
		/*
        for (Integer key : map.keySet()) {
			System.out.print(key+" ");
			System.out.println(map.get(key).size());
		}
        */
		for (HashSet t : map.values()){
			if(t.size()>=2){
				cnt++;
			}
		}
		System.out.println(cnt);
	}

}