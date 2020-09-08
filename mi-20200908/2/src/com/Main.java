package com;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 装箱子
 */
public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		if(n<=0){
			return;
		}
		int[] arr = new int[n];
		for(int i=0; i<n; i++){
			arr[i] = in.nextInt();
		}
		//先升序排序，再双指针查找，visted作为访问标志
		Arrays.sort(arr);
		int cnt=0;
		boolean[] visted =new boolean[5000];
		for(int i=0;i<n;i++){
			if(!visted[i]){
				for(int j=i+1;j<n;j++){
					if(!visted[j] && arr[i]!=arr[j]){//装箱
						visted[i]=true;
						visted[j]=true;
						cnt++;
						break;
					}//否则表示相等，继续往后找
				}
			}//否则，arr[i]已装箱
		}
		//剩下没访问的都是相等的
		for(int i=0;i<n;i++){
			if(!visted[i]){
				cnt++;
			}
		}
		System.out.println(cnt);
	}

}
