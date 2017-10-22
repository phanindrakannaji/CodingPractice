package com.phani.linkedLists;
import java.util.*;
public class Partition {

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
		System.out.println("Enter partition value: ");
		int k = sc.nextInt();
		System.out.println("Before operation: ");
		ll.print();
		partition(ll, k);
		System.out.println();
		System.out.println("After operation: ");
		
		ll.print();
		sc.close();
	}

	private static void partition(LinkedList ll, int k) {
		Node current = ll.getHead();
		Node dummy = new Node(0);
		dummy.next = current;
		Node lesser = dummy;
		if (current == null | current.next == null) return;
		while (current.next != null){
			if (current.next.data < k){
				Node temp = lesser.next;
				lesser.next = current.next;
				current.next = current.next.next;
				lesser = lesser.next;
				lesser.next = temp;
			} else{
				current = current.next;
			}
		}
		ll.setHead(dummy.next);
	}

}
