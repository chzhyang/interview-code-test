package com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader re = new BufferedReader(new InputStreamReader(System.in));
		String input;
		while((input=re.readLine())!=null && !"".equals(input)){
			String [] ss = input.split(" ");
			int a = getInputNum(ss[0]);
			int b = getInputNum(ss[1]);
			int c = getInputNum(ss[2]);
			int d = getInputNum(ss[3]);
			if(a==-1||b==-1||c==-1||d==-1){
				System.out.println("ERROR");
				continue;
			}
			compute24(a,b,c,d);
		}
	}

	//str->int
	public static int getInputNum(String str) {
		switch (str.toUpperCase()){
			case "A":
				return 1;
			case "J":
				return 11;
			case "Q":
				return 12;
			case "K":
				return 13;
			case "JOKER":
				return -1;//退出标志
			default:
				return Integer.parseInt(str);
		}
	}
	//int-str
	public static String change(int i){
		switch (i) {
			case 1:
				return "A";
			case 11:
				return "J";
			case 12:
				return "Q";
			case 13:
				return "K";
			default:
				return String.valueOf(i);
		}
	}
	//穷举计算方法
	public  static  void compute24(int a, int b, int c, int d){
		int[] array={a,b,c,d};
		String[][] arr1 = symbleList();
		for(int i=0; i<4; i++){
			for(int j=0; j<4; j++){
				for(int k=0; k<4; k++){
					for(int l=0; l<4; l++){
						if((i!=j)&&(i!=k)&&(i!=l)&&(j!=k)&&(j!=l)&&(k!=l)){//四个互不相等，防止出现两次
							for(String[] str : arr1){
								int sum = sumNum(array[i],array[j],str[0]);
								sum=sumNum(sum, array[k],str[1]);
								sum=sumNum(sum,array[l],str[2]);
								if(sum==24){
									String str1=change(array[i])+str[0]+change(array[j])+str[1]+change(array[k])+str[2]+change(array[l])+"";
									System.out.println(str1);
									return;
								}
							}

						}
					}
				}
			}
		}
		System.out.println("NONE");
	}

	public static String[] op = new String[]{"+","-","*","/"};
	public static String[][] symbleList(){
		//穷举运算符组合
		String[][] symbleList = new String[64][3];
		int p=0;
		for(int i=0; i<4; i++){
			for(int j=0; j<4;j++){
				for(int k=0; k<4;k++){
					symbleList[p++] =new String[]{op[i],op[j],op[k]};
				}
			}
		}
		return symbleList;
	}
	//sum
	public  static  int sumNum(int a,int b,String s){
		switch (s){
			case "+":
				return a+b;
			case "-":
				return a-b;
			case "*":
				return a+b;
			case "/":
				return a+b;
			default:
				return 0;
		}
	}

}
