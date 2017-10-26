package com.phani.bitManipulation;

public class Insertion {

	private static int insert(int N, int M, int i, int j){
		int count = 0;
		for (int k = i; k<=j; k++){
			N = N & ~(1 << k) | ((((M & (1 << count)) != 0)?1:0) << k);
			count++;
		}
		return N;
	}


	public static void main(String[] args) {
		System.out.println(insert(1024, 19, 2, 6));
	}

}
