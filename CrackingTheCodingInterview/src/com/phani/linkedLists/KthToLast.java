package com.phani.linkedLists;

import java.util.Scanner;

public class KthToLast {

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
		System.out.println("Enter k: ");
		int k = sc.nextInt();
		System.out.println("Before operation: ");
		ll.print();
		System.out.println();
		System.out.println(kThToLast(ll, k));
		sc.close();
	}

	private static int kThToLast(LinkedList ll, int k) {
		Node current = ll.getHead();
		Node n = current;
		int count = 1;
		boolean isKAway = (count == k);
		if (current == null){
			return 0;
		}
		while (current.next != null){
			current = current.next;
			if (isKAway){
				n = n.next;
			} else{
				count++;
				isKAway = (count >= k);
			}
		}
		if (isKAway){
			return n.data;
		} else{
			return -1;
		}
	}

}
