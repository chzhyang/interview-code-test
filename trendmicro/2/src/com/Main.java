package com;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String s = in.nextLine();
		int k = in.nextInt();
		if(s==null || k<0){
			return;
		}
		System.out.println(solution(s,k));
	}

	public static String solution(String s, int k) {
		if(k==0) return s;
		if(k==s.length()) return "0";

		//为方便比较和删除，string转换为list
		List<Character> num = new LinkedList<>();
		char[] array = s.toCharArray();
		for(int i=0; i<array.length;i++){
			num.add(array[i]);
		}
		//找k次，每次发现 num(i) > num(i+1) 时 删除num(i);
		while(k>0){
			boolean flag=true;//标志，找到要删除的第k个数字
			for(int i=0; i<num.size()-1; i++){
				if(num.get(i) > num.get(i+1)){//找到则删除该数字
					num.remove(i);
					k -= 1;
					flag=false;
					break;
				}
			}
			if(flag){//没找到，说明是递增的，删掉最后一个
				k -= 1;
				num.remove(num.size()-1);
			}
		}

		//去掉前面的0
		while(!num.isEmpty()){
			if(num.get(0) == '0'){
				num.remove(0);
			}else {
				break;
			}
		}

		if(num.isEmpty()){
			return "0";
		}else{
			StringBuilder str = new StringBuilder();
			for(Character c : num){
				str.append(c);
			}
			return str.toString();
		}
	}

}
