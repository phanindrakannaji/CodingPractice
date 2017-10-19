package com.phani.arraysAndStrings;

import java.util.*;

/**
 * Make first row and first column zeroes - kind of marking them as 0 
 * and then parse the first column and first row to nullify the rest of the elements to 0
 * @author phanindra
 *
 */
public class ZeroMatrix {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter size of array: ");
		int n = sc.nextInt();
		int[][] matrix = new int[n][];
		System.out.println("Enter numbers continuosly");
		for (int i = 0; i<n;i++){
			int[] temp = new int[n];
			for (int j=0;j<n;j++){
				temp[j] = sc.nextInt();
			}
			matrix[i] = temp;
		}
		System.out.println("Before rotation: ");
		for (int i = 0; i<n;i++){
			for (int j=0;j<n;j++){
				System.out.print(matrix[i][j]);
				System.out.print(" ");
			}
			System.out.println();
		}
		matrix = zeroMatrix(matrix, n);
		System.out.println("After rotation: ");
		for (int i = 0; i<n;i++){
			for (int j=0;j<n;j++){
				System.out.print(matrix[i][j]);
				System.out.print(" ");
			}
			System.out.println();
		}
	}
	
	public static int[][] zeroMatrix(int[][] matrix, int n){
		List<Integer> rowList = new ArrayList<Integer>();
		List<Integer> columnList = new ArrayList<Integer>();
		for (int i = 0; i< n; i++){
			for (int j = 0; j<n; j++){
				if (matrix[i][j] == 0){
					if (!rowList.contains(i)) rowList.add(i);
					if (!columnList.contains(j)) columnList.add(j);
					for (int k = 0; k< i; k++){
						matrix[k][j] = 0;
					}
					for (int k = 0; k< j; k++){
						matrix[i][k] = 0;
					}
				} else if (rowList.contains(i) || columnList.contains(j)){
					matrix[i][j] = 0;
				}
			}
		}
		return matrix;
	}

}
