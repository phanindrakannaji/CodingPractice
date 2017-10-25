package com.phani.treesAndGraphs;

import java.util.*;

public class BSTSequences {

	private static class Node{
		int data;
		Node left;
		Node right;
		Node parent;

		public Node(int data){
			this.data = data;
		}

		public void addToLeft(Node n){
			this.left = n;
			n.parent = this;
		}

		public void addToRight(Node n){
			this.right = n;
			n.parent = this;
		}
	}

	public static void printAllPossibleArrays(Node n){
		List<LinkedList<Integer>> lists = getPossibleAtNode(n);
		for (LinkedList<Integer> l : lists){
			System.out.print("{");
			for (Integer i : l){
				System.out.print(i + ", ");
			}
			System.out.println("}");
		}
	}

	public static List<LinkedList<Integer>> getPossibleAtNode(Node n){
		if (n == null) return null;
		List<LinkedList<Integer>> lists = new ArrayList<LinkedList<Integer>>();
		LinkedList<Integer> list = new LinkedList<Integer>();
		list.add(n.data);
		List<LinkedList<Integer>> leftList = getPossibleAtNode(n.left);
		List<LinkedList<Integer>> rightList = getPossibleAtNode(n.right);
		if (leftList == null && rightList == null){
			lists.add(list);
			return lists;
		} else if (rightList == null){
			lists.addAll(leftList);
		} else if (leftList == null){
			lists.addAll(rightList);
		} else{
			for (LinkedList<Integer> l1 : leftList){
				for (LinkedList<Integer> l2 : rightList){
					LinkedList<Integer> lc1 = (LinkedList<Integer>) l1.clone();
					LinkedList<Integer> lc11 = (LinkedList<Integer>) l1.clone();
					LinkedList<Integer> lc2 = (LinkedList<Integer>) l2.clone();
					lc1.addAll(lc2);
					lc2.addAll(lc11);
					lists.add(lc1);
					lists.add(lc2);
				}
			}
		}
		for (LinkedList<Integer> l : lists){
			l.addFirst(n.data);
		}
		return lists;
	}

	public static void main(String[] args) {
		Node n1  = new Node(8);
		Node n2  = new Node(4);
		Node n3  = new Node(12);
		Node n4  = new Node(2);
		Node n5  = new Node(6);
		Node n6  = new Node(10);
		Node n7  = new Node(14);
		Node n8  = new Node(1);
		Node n9  = new Node(3);
		Node n10 = new Node(5);
		Node n11 = new Node(7);
		Node n12 = new Node(9);
		Node n13 = new Node(11);
		Node n14 = new Node(13);

		n1.addToLeft(n2);
		n1.addToRight(n3);
		n2.addToLeft(n4);
		n2.addToRight(n5);
		n3.addToLeft(n6);
		n3.addToRight(n7);
		n4.addToLeft(n8);
		n4.addToRight(n9);
		n5.addToLeft(n10);
		n5.addToRight(n11);
		n6.addToLeft(n12);
		n6.addToRight(n13);
		n7.addToLeft(n14);

		printAllPossibleArrays(n1);
		
		Node na = new Node(2);
		Node nb = new Node(1);
		Node nc = new Node(3);
		
		na.addToLeft(nb);
		na.addToRight(nc);
		printAllPossibleArrays(na);
	}

}
