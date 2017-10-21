package com.phani.linkedLists;

import java.util.Scanner;

public class SumLists {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter length of first linked list:");
		int n = sc.nextInt();
		System.out.println("Enter node data: ");
		int d = sc.nextInt();
		Node head = new Node(d);
		LinkedList ll = new LinkedList(head);
		for (int i = 0; i<n-1 ; i++){
			d = sc.nextInt();
			ll.appendToTail(d);
		}
		System.out.println("Enter length of second linked list:");
		int n2 = sc.nextInt();
		System.out.println("Enter node data: ");
		int d2 = sc.nextInt();
		Node head2 = new Node(d2);
		LinkedList ll2 = new LinkedList(head2);
		for (int i = 0; i<n2-1 ; i++){
			d2 = sc.nextInt();
			ll2.appendToTail(d2);
		}
		System.out.println("Before operation: ");
		ll.print();
		System.out.println();
		ll2.print();
		System.out.println();
		System.out.println("Forward sum:");
		LinkedList ll3 = forwardSum(ll, ll2);
		//ll3.print();
		System.out.println();
		System.out.println("Backward sum:");
		LinkedList ll4 = backwardSum(ll, ll2);
		ll4.print();
		System.out.println();
		sc.close();
	}

	private static LinkedList backwardSum(LinkedList ll, LinkedList ll2) {
		Node current1 = ll.getHead();
		Node current2 = ll2.getHead();
		if (current1 == null || current2 == null) return null;
		int data = current1.data + current2.data;
		Node currentSum = new Node(data%10);
		int carry = (int) Math.floor(data/10);
		LinkedList sum = new LinkedList(currentSum);
		while (current1.next != null && current2.next != null){
			data = current1.next.data + current2.next.data + carry;
			currentSum.next = new Node(data%10);
			currentSum = currentSum.next;
			carry = (int) Math.floor(data/10);
			current1 = current1.next;
			current2 = current2.next;
		}
		while (current1.next != null){
			data = current1.next.data + carry;
			currentSum.next = new Node(data%10);
			currentSum = currentSum.next;
			carry = (int) Math.floor(data/10);
			current1 = current1.next;
		}
		while (current2.next != null){
			data = current2.next.data + carry;
			currentSum.next = new Node(data%10);
			currentSum = currentSum.next;
			carry = (int) Math.floor(data/10);
			current2 = current2.next;
		}
		if (carry != 0) {
			currentSum.next = new Node(carry);
			currentSum = currentSum.next;
		}
		return sum;
	}

	private static LinkedList forwardSum(LinkedList ll, LinkedList ll2) {
		// TODO
		return null;
	}

}
