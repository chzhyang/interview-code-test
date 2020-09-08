package com;
import java.util.Scanner;

/**
 * 矩阵相乘
 */
public class Main {
	public static void matrix_multiply(int[][] A, int[][] B, int[][] C, int M, int K, int N){
		for(int i=0; i<M; i++){
			for(int j=0; j<N; j++){
				for(int k=0; k<K; k++){
					C[i][j] += A[i][k]*B[k][j];
				}
			}
		}
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int M,K,N;
		M = in.nextInt();
		K = in.nextInt();
		N= in.nextInt();
		if(M<=0 || N<=0 || K<=0){
			return;
		}
		int[][] A = new int[M][K];
		int[][] B = new int[K][N];
		int[][] C = new int[M][N];
		for(int i=0; i<M; i++){
			for(int j=0;j<K; j++){
				A[i][j] = in.nextInt();
			}
		}
		for(int i=0; i<K; i++){
			for(int j=0;j<N; j++){
				B[i][j] = in.nextInt();
			}
		}

		//乘法计算
		matrix_multiply(A,B,C,M,K,N);
		//输出
		for(int i=0; i<M; i++) {
			for (int j = 0; j < N; j++) {
				if(j!=N-1){
					System.out.print(C[i][j]+" ");
				}else{
					System.out.println(C[i][j]);
				}

			}
		}
	}
}
