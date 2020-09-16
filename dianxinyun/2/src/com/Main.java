package com;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
class MyStack {
	int minIndex;
	List<Integer> stack;
	MyStack(){
		stack = new ArrayList<>();
		minIndex=0;
	}
	public void myPush(int a) {
		stack.add(a);
		if(stack.size()>1 && a<stack.get(minIndex)){
			minIndex = stack.size()-1;
		}
	}
	public void myPop() {
		int n = stack.size();
		if(n>0){
			stack.remove(n-1);
			minIndex=0;
			for(int i=0; i<n-1; i++){
				if(stack.get(i)<stack.get(minIndex)){
					minIndex=i;
				}
			}
		}
	}
	public int myGetMin() {
		if(stack.size()>0) {
			return stack.get(minIndex);
		}else{
			return -1;
		}
	}
	public int myTop() {
		if (stack.size() > 0) {
			return stack.get(stack.size()-1);
		}else{
			return -1;
		}
	}
}
public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		in.nextLine();
		if(n<=0){
			return;
		}
		MyStack st = new MyStack();
		String[] ss = new String[n];
		for(int i=0; i<n; i++) {
			ss[i] = in.nextLine();
		}
			for(int i=0; i<n; i++){
				String[] s = ss[i].split(" ");
				switch (s[0]){
					case "push":
						st.myPush(Integer.valueOf(s[1]));
						break;
					case "top":
						System.out.println(st.myTop());
						break;
					case "pop":
						st.myPop();
						break;
					case "getMin":
						System.out.println(st.myGetMin());
						break;
				}
		}
	}
}
