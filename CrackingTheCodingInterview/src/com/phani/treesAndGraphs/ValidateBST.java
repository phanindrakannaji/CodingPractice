package com.phani.treesAndGraphs;


public class ValidateBST {
	
	private static class Node{
		int data;
		Node left;
		Node right;
		
		public Node(int data){
			this.data = data;
		}
	}
	
	public static boolean validateBST(Node root){
		if (root == null) return false;
		boolean leftCheck = true, rightCheck = true;
		if (root.left == null && root.right == null) return true;
		if ((root.left != null && root.right== null && root.left.data < root.data)
				|| (root.left == null && root.right!= null && root.right.data >= root.data)
				|| (root.left != null && root.right != null && root.left.data < root.data && root.right.data >= root.data)){
			if (root.left != null) leftCheck = validateBST(root.left);
			if (root.right != null) rightCheck = validateBST(root.right);
			if (leftCheck && rightCheck) return true;
		}
		return false;
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
		
		System.out.println(validateBST(n0));
		
		Node n60  = new Node(8);
		Node n61  = new Node(4);
		Node n62  = new Node(12);
		Node n63  = new Node(2);
		Node n64  = new Node(6);
		Node n65  = new Node(10);
		Node n66  = new Node(14);
		Node n67  = new Node(1);
		Node n68  = new Node(3);
		Node n69  = new Node(5);
		Node n610 = new Node(7);
		Node n611 = new Node(9);
		Node n612 = new Node(11);
		Node n613 = new Node(13);
		Node n614 = new Node(15);
		
		n60.left = n61;
		n60.right = n62;
		n61.left = n63;
		n61.right = n64;
		n62.left=n65;
		n62.right=n66;
		n63.left=n67;
		n63.right=n68;
		n64.left=n69;
		n64.right=n610;
		n65.left=n611;
		n65.right=n612;
		n66.left=n613;
		n66.right=n614;
		
		System.out.println(validateBST(n60));
	}
}
