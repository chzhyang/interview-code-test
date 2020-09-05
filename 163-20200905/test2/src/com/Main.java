package com;

import java.util.Scanner;

public class Main {
	/**
	 *
	 * a,b为速度，根据正负判断方向，根据移动方向确定基准坐标，右下移动时基准为人物的左上角
	 * 移动出去的标志为基准坐标完全移动出边界
	 * 两个辅助数组，分别代表人物和屏幕，通过对比移动前屏幕的字符和移动后的字符计算刷新次数，累加的最后结果
	 * @param args
	 */

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println();
		int n = in.nextInt();
		if(n<=0){
			return;
		}
		int W = in.nextInt(), H = in.nextInt();//屏幕大小
		if(W<=0 && H<=0){
			return;
		}
		char[][] base = new char[H+1][W+1];
		for(int i=1; i<=H; i++){//将屏幕输入数组
			String s = in.nextLine();
			for(int j=1; j<=W; j++){
				base[i][j] = s.charAt(j);
			}
		}

		int P = in.nextInt(), Q = in.nextInt();//人物大小
		if(P<1 || Q>100){
			return;
		}
		char[][] p = new char[Q][P];
		for(int i=0; i<Q; i++){//将人物输入数组
			String s = in.nextLine();
			for(int j=0; j<=P; j++){
				p[i][j] = s.charAt(j);
			}
		}

		int i = in.nextInt(), j = in.nextInt(), a = in.nextInt(), b = in.nextInt();//起始坐标和速度

		/**
		 * 根据速度正负，计算移出去的路径
		 */
		int cnt = 0;

		//第一帧，人物刷新到屏幕，判断重叠区域
		int x1 = 1-i, y1 = 1-j, x2 = W-i+P+1, y2 = H-i+Q+1;
		x1 =x1>=0?x1:0;
		y1 =y1>=0?y1:0;
		x2 =x2>=0?x2:0;
		y2 =y2>=0?y2:0;
		//计算重叠区域要刷新的字符
		while(x1<=x2){
			while(y1<=y2){
				if(base[x1][y1]!=p[x1][y1]){//字符不同时刷新
					cnt++;
					base[x1][y1] = p[x1][y1];
				}
			}
		}

		//以后的帧


	}
	public static void sollution() {
		// TODO:
		return;
	}

}
