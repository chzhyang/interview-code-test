package com;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] s = sc.nextLine().split(" ");
		if(s==null || s[0].length() != s[1].length()){
			return;
		}
		pre(s[0], s[1],s[1].length()-1, 0, s[1].length()-1);
		System.out.println();
	}

	public static void pre(String mid, String post, int root, int start, int end) {
		if(start > end){
			return;
		}
		int i = start;
		//定位root在mid中的index
		while(i < end && mid.charAt(i)!=post.charAt(root)){
			i++;
		}
		System.out.print(mid.charAt(i));
		pre(mid, post, root-1-(end-i), start, i-1);//左子树
		pre(mid, post, root-1, i+1, end);//右子树
	}

}
