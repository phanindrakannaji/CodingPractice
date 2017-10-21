package com.phani.linkedLists;

public class LinkedList {
	Node head;
	
	public Node getHead() {
		return head;
	}

	public void setHead(Node head) {
		this.head = head;
	}

	public LinkedList(Node n) {
		this.head = n;
	}
	
	public void appendToTail(int data){
		Node newNode = new Node(data);
		Node n = head;
		while (n.next != null) n = n.next;
		n.next = newNode;
	}
	
	public Node deleteNode(int data){
		Node n = head;
		if (n.data == data) return n.next;
		while (n.next != null){
			if (n.next.data == data){
				n.next = n.next.next;
			}
			n = n.next;
		}
		return head;
	}
	
	public void print(){
		Node n = head;
		if (n == null){
			System.out.println("Empty");
		} else{
			System.out.print(n.data);
			while (n.next != null){
				n = n.next;
				System.out.print(" -> " + n.data);
			}
		}
	}
}
