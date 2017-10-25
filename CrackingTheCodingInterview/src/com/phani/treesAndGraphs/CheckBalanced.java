package com.phani.treesAndGraphs;

public class CheckBalanced {
	private static class Node{
		int data;
		Node left;
		Node right;
		
		public Node(int data){
			this.data = data;
		}
	}
	
	public int checkBalanced(Node root){
		if (root == null) return 0;
		int leftSize = 0, rightSize = 0;
		if (root.left != null) leftSize = checkBalanced(root.left);
		if (root.right != null) rightSize = checkBalanced(root.right);
		int diff = leftSize - rightSize;
		if (leftSize == -1 || rightSize == -1){
			return -1;
		}
		if (diff == 0 || diff == 1 || diff == 2){
			return leftSize + rightSize + 1;
		} else{
			return -1;
		}
	}
	
	
	
	public static void main(String[] args){
		Node n0  = new Node(0);
		Node n1  = new Node(1);
		Node n2  = new Node(2);
		Node n3  = new Node(3);
		Node n4  = new Node(4);
		Node n5  = new Node(5);
		Node n6  = new Node(6);
		Node n7  = new Node(7);
		Node n8  = new Node(8);
		Node n9  = new Node(9);
		Node n10 = new Node(10);
		Node n11 = new Node(11);
		Node n12 = new Node(12);
		Node n13 = new Node(13);
		Node n14 = new Node(14);
		Node n15 = new Node(15);
		Node n16 = new Node(16);

		n0.left = n1;
		n0.right = n2;
		n1.left = n3;
		n1.right = n4;
		n2.left=n5;
		n2.right=n6;
		n3.left=n7;
		n3.right=n8;
		n4.left=n9;
		n4.right=n10;
		n5.left=n11;
		n5.right=n12;
		n6.left=n13;
		n6.right=n14;
		n7.left=n15;
		n7.right=n16;
		
		CheckBalanced checkBalanced = new CheckBalanced();
		
		System.out.println((checkBalanced.checkBalanced(n0) == -1)?false: true);
	}
}
