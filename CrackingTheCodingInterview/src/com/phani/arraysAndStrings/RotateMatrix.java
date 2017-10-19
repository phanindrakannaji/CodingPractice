package com.phani.arraysAndStrings;
import java.util.*;
public class RotateMatrix {

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
		matrix = transformMatrix(matrix, n);
		System.out.println("After rotation: ");
		for (int i = 0; i<n;i++){
			for (int j=0;j<n;j++){
				System.out.print(matrix[i][j]);
				System.out.print(" ");
			}
			System.out.println();
		}
	}

	public static int[][] transformMatrix(int[][] matrix, int n){
		for (int i = 0; i < Math.floor(new Float(n)/2); i++){
			for (int j = i; j< n-i-1; j++){
				int previous = matrix[j][n-i-1];
				matrix[j][n-i-1] = matrix[i][j];
				int next = matrix[n-i-1][n-j-1];
				matrix[n-i-1][n-j-1] = previous;
				previous = matrix[n-j-1][i];
				matrix[n-j-1][i] = next;
				matrix[i][j] = previous;
			}
		}
		return matrix;
	}
}
