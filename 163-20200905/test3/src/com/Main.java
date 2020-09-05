package com;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		if(n<=0){
			return;
		}
		/**
		 * 起点坐标设为（0,0,），通过轨迹找到终点坐标(x,y)，计算两点间曼哈顿距离 abs(x)+abs(y)
		 */
		int[] res = new int[n];//最终结果
		for(int i = 0;i < n; i++){//n组数据,min路径长度为res[i]
			int m = in.nextInt();//m行轨迹
			if(m<=0){
				res[i]=0;
				continue;
			}
			int x = 0;
			int y = 0;
			for(int j=0; j<m; j++){//通过m行轨迹找到终点坐标
				int direction = in.nextInt();
				int ok = in.nextInt();
				if(ok==1){//成功了就改变坐标
					switch (direction){
						case 0:
							x += 1;
							break;
						case 1:
							x -= 1;
							break;
						case 2:
							y -= 1;
							break;
						case 3:
							y += 1;
							break;
					}
					//System.out.println(direction+","+ok+":"+x+","+y);
				}
			}//终点
			//System.out.println(i+":"+x+","+y);
			//计算终点和起点的曼哈顿距离
			res[i] = Math.abs(x) + Math.abs(y);
		}
		for(int i = 0; i<n; i++) {
			System.out.println(res[i]);
		}

	}
}
