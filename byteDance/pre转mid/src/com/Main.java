package com;

import java.util.*;
public class Main {
	public static void mid(String pre){
		if(pre==null) return;
		Stack<Character> st = new Stack<>();
		StringBuilder result = new StringBuilder();
		for(int i=0; i<pre.length(); i++){
			char c = pre.charAt(i);
			if(c!='#'){
				st.push(c);
			}else if(i+1<pre.length() && pre.charAt(i+1) == '#'){
				result.append('#');
				if(!st.isEmpty()){
					result.append(st.pop());
				}
				result.append('#');
				if(!st.isEmpty()){
					result.append(st.pop());
				}
				i++;
			}else{
				result.append('#');
				if(!st.isEmpty()){
					result.append(st.pop());
				}

			}
		}
		System.out.println(result.toString());
	}
	public static void main(String[] args) {
		//Scanner in = new Scanner(System.in);
		String s1 = "#";
		String s2 = "ABC#D#E##F##G##";
		String s3 = "ABC##D#E###";
		mid(s1);
		System.out.println("Hello World!");
	}
}