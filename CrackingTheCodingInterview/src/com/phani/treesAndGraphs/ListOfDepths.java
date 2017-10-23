package com.phani.treesAndGraphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListOfDepths {
	private static class Node{
		int data;
		Node left;
		Node right;

		public Node(int data){
			this.data = data;
		}
	}

	private static class QueueNode{
		private Node node;
		private int level;

		public QueueNode(Node n, int level){
			this.node = n;
			this.level = level;
		}
	}

	public void loadLists(Node root, List<ArrayList<Node>> lists){
		LinkedList<QueueNode> list = new LinkedList<QueueNode>();
		list.add(new QueueNode(root, 0));
		while(!list.isEmpty()){
			QueueNode current = list.removeLast();
			if (lists.size() == current.level) lists.add(new ArrayList<Node>());
			ArrayList<Node> innerList = lists.get(current.level);
			if (innerList == null) innerList = new ArrayList<Node>();
			innerList.add(current.node);
			if (current.node.left != null){
				list.add(new QueueNode(current.node.left, current.level+1));
			}
			if (current.node.right != null){
				list.add(new QueueNode(current.node.right, current.level+1));
			}
		}
	}
	
	public static void main(String[] args) {
		ListOfDepths listOfDepths = new ListOfDepths();
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

		List<ArrayList<Node>> lists = new ArrayList<ArrayList<Node>>();

		listOfDepths.loadLists(n0, lists);
		for (ArrayList<Node> list : lists){
			for (Node n : list){
				System.out.print(" . " + n.data);
			}
			System.out.println();
		}
	}

}
