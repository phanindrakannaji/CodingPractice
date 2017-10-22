package com.phani.linkedLists;

import java.util.*;

public class PalindromeCheck {

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
		System.out.println();
		System.out.println(checkPalindrome(ll));
		sc.close();
	}

	private static boolean checkPalindrome(LinkedList ll) {
		Node current = ll.getHead();
		Node n = current;
		int index = 0;
		int count = 1;
		List<Integer> list = new ArrayList<Integer>();
		boolean alt = true;
		while (current.next != null){
			if (alt){
				list.add(index, n.data);
				n = n.next;
				index++;
			}
			alt = !alt;
			count++;
			current = current.next;
		}
		if (count%2 != 0) {
			n = n.next;
		}
		while (n != null){
			if (n.data != list.get(--index)) return false;
			n = n.next;
		}
		
		return true;
	}

}
