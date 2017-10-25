package com.phani.treesAndGraphs;

import java.util.*;
// incomplete
public class BuildOrder {
	private Map<Integer, Node> nodes;
	private Node start;

	private static class Dependant{
		int dependantPid;
		int pid;

		public Dependant(int dependantPid, int pid){
			this.dependantPid = dependantPid;
			this.pid=pid;
		}
	}

	private static class Node{
		int pid;
		List<Integer> dependancies;
		int remainingDependantCount = 0;

		public Node(int pid){
			this.pid = pid;
			this.dependancies = new ArrayList<Integer>();
		}
	}

	private List<Node> getBuildOrder(){
		boolean found = false;
		List<Node> nodeList = new ArrayList<Node>();
		for (Integer pid : nodes.keySet()){
			List<Integer> dependancies = nodes.get(pid).dependancies;
			if (dependancies.size() == 0) {
				found = true;
				nodeList.add(nodes.get(pid));
			}
		}

		if (!found) return null;
		return nodeList;
	}

	private void buildDependancies(List<Dependant> dependants){
		nodes = new HashMap<Integer, Node>();
		for (Dependant d : dependants){
			if (nodes.containsKey(d.pid)){
				nodes.get(d.pid).dependancies.add(d.dependantPid);
				nodes.get(d.pid).remainingDependantCount++;
			} else{
				Node n = new Node(d.pid);
				n.remainingDependantCount++;
				n.dependancies.add(d.dependantPid);
				nodes.put(d.pid, n);
			}
		}
	}

	public static void main(String[] args) {
		
	}

}
