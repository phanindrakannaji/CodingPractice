package com.phani.treesAndGraphs;

import java.util.*;

public class PathsWithSum {

	private static class Node{
		int data;
		Node left;
		Node right;
		Node parent;
		List<Integer> possibleSums;
		
		public Node(int data){
			this.data = data;
		}
	}

	private static List<Integer> generatePossibleSums(Node n) {
		List<Integer> list = new ArrayList<Integer>();
		if (n != null){
			list.add(n.data);
			if (n.left != null) {
				n.left.possibleSums = generatePossibleSums(n.left);
				for (Integer i : n.left.possibleSums){
					list.add(n.data + i);
				}
			}
			if (n.right != null) {
				n.right.possibleSums = generatePossibleSums(n.right);
				for (Integer i : n.right.possibleSums){
					list.add(n.data + i);
				}
			}
		}
		n.possibleSums = list;
		return list;
	}

	private static int countPathsWithSums(Node n, Integer givenInt){
		if (n == null) return 0;
		System.out.print("For node " + n.data + " : ");
		for (Integer i : n.possibleSums){
			System.out.print(i + ",");
		}
		System.out.println();
		return Collections.frequency(n.possibleSums, givenInt) 
				+ countPathsWithSums(n.left, givenInt) 
				+ countPathsWithSums(n.right, givenInt);
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

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a number: ");
		int givenInt = sc.nextInt();
		
		generatePossibleSums(n0);
		System.out.println(countPathsWithSums(n0, givenInt));
		sc.close();
	}
}
