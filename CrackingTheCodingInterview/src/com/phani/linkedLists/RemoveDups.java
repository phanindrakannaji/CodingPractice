package com.phani.linkedLists;
import java.util.*;
public class RemoveDups {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter length of linked list:");
		int n = sc.nextInt();
		System.out.println("Enter node data: ");
		int d = sc.nextInt();
		Node head = new Node(d);
		LinkedList ll = new LinkedList(head);
		for (int i = 0; i<n-1 ; i++){
			d = sc.nextInt();
			ll.appendToTail(d);
		}
		System.out.println("Before operation: ");
		ll.print();
		removeDupsNoBuffer(ll);
		System.out.println();
		System.out.println("After operation: ");
		
		ll.print();
		sc.close();
	}

	@SuppressWarnings("unused")
	private static void removeDups(LinkedList ll) {
		List<Integer> list = new ArrayList<Integer>();
		Node n = ll.getHead();
		if (n == null || n.next == null){
			return;
		}
		list.add(n.data);
		while (n.next != null){
			if (list.contains(n.next.data)){
				n.next = n.next.next;
			} else{
				list.add(n.next.data);
				n = n.next;
			}
		}
	}
	
	private static void removeDupsNoBuffer(LinkedList ll){
		Node current = ll.getHead();
		if (current == null || current.next == null){
			return;
		}
		while(current.next != null){
			int data = current.data;
			Node n = current;
			while(n.next != null){
				if (n.next.data == data){
					n.next = n.next.next;
				} else{
					n = n.next;
				}
			}
			if (current.next != null){
				current = current.next;
			}
		}
	}
}
