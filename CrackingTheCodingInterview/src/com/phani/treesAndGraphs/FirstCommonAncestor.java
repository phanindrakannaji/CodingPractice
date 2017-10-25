package com.phani.treesAndGraphs;

public class FirstCommonAncestor {
	
	private static class Node{
		int data;
		Node left;
		Node right;
		Node parent;
		
		public Node(int data){
			this.data = data;
		}
		
		public Node goUpBy(int count){
			Node n = this;
			while (count!=0){
				n = n.parent;
				count--;
			}
			return n; 
		}
	}
	
	private static Node firstCommonAncestor(Node first, Node second) {
		int diff = getDepth(first) - getDepth(second);
		if (diff > 0){
			first = first.goUpBy(diff);
			if (first == second && first.parent != null) return first.parent;
		} else if (diff < 0){
			second = second.goUpBy(-1 * diff);
			if (first == second && first.parent != null) return first.parent;
		}
		while (first != null && second!= null && first != second){
			first = first.goUpBy(1);
			second = second.goUpBy(1);
		}
		return first;
	}
	
	private static int getDepth(Node n){
		int count = 0;
		while(n != null){
			count++;
			n = n.parent;
		}
		return count;
	}
	
	

	public static void main(String[] args) {
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
		Node n17 = new Node(17);
		Node n18 = new Node(18);

		n0.left = n1;
		n1.parent = n0;
		n0.right = n2;
		n2.parent = n0;
		n1.left = n3;
		n3.parent=n1;
		n1.right = n4;
		n4.parent = n1;
		n2.left=n5;
		n5.parent = n2;
		n2.right=n6;
		n6.parent = n2;
		n3.left=n7;
		n7.parent = n3;
		n3.right=n8;
		n8.parent = n3;
		n4.left=n9;
		n9.parent=n4; 
		n4.right=n10;
		n10.parent=n4;
		n5.left=n11;
		n11.parent=n5;
		n5.right=n12;
		n12.parent=n5;
		n6.left=n13;
		n13.parent=n6;
		n6.right=n14;
		n14.parent=n6;
		n7.left=n15;
		n15.parent=n7;
		n7.right=n16;
		n16.parent=n7;
		n16.right=n17;
		n17.parent=n16;
		n12.left=n18;
		n18.parent=n12;
		
		System.out.println(firstCommonAncestor(n0, n6).data);
		System.out.println(firstCommonAncestor(n1, n8).data);
		System.out.println(firstCommonAncestor(n2, n12).data);
		System.out.println(firstCommonAncestor(n3, n17).data);
		System.out.println(firstCommonAncestor(n4, n5).data);
		System.out.println(firstCommonAncestor(n5, n0).data);
		System.out.println(firstCommonAncestor(n6, n10).data);
		System.out.println(firstCommonAncestor(n7, n14).data);
		System.out.println(firstCommonAncestor(n8, n9).data);
		System.out.println(firstCommonAncestor(n9, n10).data);
		System.out.println(firstCommonAncestor(n10, n18).data);
		System.out.println(firstCommonAncestor(n11, n5).data);
		System.out.println(firstCommonAncestor(n12, n5).data);
		System.out.println(firstCommonAncestor(n13, n14).data);
		System.out.println(firstCommonAncestor(n15, n3).data);
		System.out.println(firstCommonAncestor(n16, n17).data);
	}

}
