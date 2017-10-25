package com.phani.treesAndGraphs;
import java.util.*;
public class MinimalTree {
	private static class Node{
		int data;
		Node left;
		Node right;
		
		public Node(int data){
			this.data = data;
		}
		
		public void addToLeft(Node n){
			this.left = n;
		}
		
		public void addToRight(Node n){
			this.right = n;
		}
	}

	public Node constructBST(int[] array, int start, int end){
		int size = end-start+1;
		if (end == start){
			return new Node(array[start]);
		}
		if (end < start || end < 0 || start < 0){
			return null;
		}
		int dividing = 0;
		if (size%2 == 0){
			dividing = start+((end-start+1)/2);
		} else{
			dividing = start+((end-start)/2);
		}
		Node n = new Node(array[dividing]);
		n.addToLeft(constructBST(array, start, dividing-1));
		n.addToRight(constructBST(array, dividing+1, end));
		return n;
	}
	
	public void printTree(Node root){
		if (root == null) return;
		System.out.println(" " + root.data);
		this.printTree(root.left);
		this.printTree(root.right);
	}
	
	public static void main(String[] args){
		MinimalTree minimalTree = new MinimalTree();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter length of array: ");
		int size = sc.nextInt();
		int[] array = new int[size];
		for (int i = 0; i<size; i++){
			System.out.println("Enter data: ");
			array[i] = sc.nextInt();
		}
		minimalTree.printTree(minimalTree.constructBST(array, 0, size-1));
		sc.close();
	}
}
