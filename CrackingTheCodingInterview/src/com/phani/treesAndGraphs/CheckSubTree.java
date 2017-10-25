package com.phani.treesAndGraphs;

public class CheckSubTree {

	private static boolean found = false;

	private static class Node{
		int data;
		Node left;
		Node right;
		Node parent;

		public Node(int data){
			this.data = data;
		}
	}

	public static boolean matchSubTree(Node n1, Node n2){
		if (n2 == null) return true;
		if (n1.data != n2.data) return false;
		if (n1.left == null && n2.left != null || n1.right == null && n2.right != null) return false;
		if (n2.left == null && n2.right == null & n1.data == n2.data) return true;
		return matchSubTree(n1.left, n2.left) && matchSubTree(n1.right, n2.right);
	}

	public static boolean checkSubTree(Node n1, Node n2){
		if (!found){

			if (n1 == null) return false;
			if (n1.data == n2.data){
				found = matchSubTree(n1, n2);
			}
			if (found) return true;
			return checkSubTree(n1.left, n2) || checkSubTree(n1.right, n2);
		} else{
			return true;
		}
	}

}
