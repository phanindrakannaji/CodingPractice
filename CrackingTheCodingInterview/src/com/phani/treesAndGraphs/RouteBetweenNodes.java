package com.phani.treesAndGraphs;

import java.util.*;

public class RouteBetweenNodes {
	List<Node> nodes;
	public RouteBetweenNodes(){
		nodes = new ArrayList<Node>();
	}

	private static class Node{
		int data;
		boolean visited = false;
		List<Node> children;

		public Node(int data){
			this.data = data;
			children = new ArrayList<Node>();
		}

		public void markVisited(){
			this.visited = true;
		}

		public boolean isVisited(){
			return this.visited;
		}

		public void clearVisited(){
			this.visited = false;
		}

		public void addChild(Node n){
			children.add(n);
		}
	}

	public void clearAllVisited(){
		if (nodes.size() == 0) return;
		for (Node node : nodes){
			node.clearVisited();
		}
	}

	public boolean doesRouteExist(Node start, Node end){
		Node current = start;
		if (start == null || end == null) return false;
		if (start == end) return true;
		this.clearAllVisited();
		LinkedList<Node> queue = new LinkedList<Node>();
		queue.add(current);
		while (queue.isEmpty()){
			current = queue.removeFirst();
			current.markVisited();
			if (current == end) return true;
			for (Node n : current.children){
				queue.add(n);
			}
		}
		return false;
	}
}
