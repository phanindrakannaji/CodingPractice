package com.phani.linkedLists;

import java.util.Scanner;

public class Intersection {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		Node n5 = new Node(5);
		Node n6 = new Node(6);
		Node n7 = new Node(7);
		Node n8 = new Node(8);
		Node n9 = new Node(9);
		Node n10 = new Node(10);
		Node n11 = new Node(11);
		Node n12 = new Node(12);
		Node n13 = new Node(13);
		Node n14 = new Node(14);
		Node n15 = new Node(15);
		Node n16 = new Node(16);
		Node n17 = new Node(17);
		Node n18 = new Node(18);
		
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = n7;
		n7.next = n8;
		n8.next = n9;
		n9.next = n10;
		n11.next = n12;
		n12.next = n13;
		n13.next = n14;
		n14.next = n15;
		n15.next = n16;
		n16.next = n17;
		n17.next = n18;
		n18.next = n5;
		
		LinkedList ll = new LinkedList(n1);
		LinkedList ll2 = new LinkedList(n11);
		System.out.println("Before operation: ");
		ll.print();
		System.out.println();
		ll2.print();
		System.out.println();
		System.out.println("Merged at: " + mergedAt(ll, ll2));
		sc.close();

	}

	private static int mergedAt(LinkedList ll, LinkedList ll2) {
		Node current1 = ll.getHead();
		Node current2 = ll2.getHead();
		int count1 = 1;
		int count2 = 1;
		while(current1.next != null){
			current1 = current1.next; 
			count1++;
		}
		while(current2.next != null){
			current2 = current2.next; 
			count2++;
		}
		if (current1 != current2){
			return -1;
		}
		current1 = ll.getHead();
		current2 = ll2.getHead();
		while (count1 != count2){
			if (count1 > count2){
				current1 = current1.next;
				count1--;
			} else{
				current2 = current2.next;
				count2--;
			}
		}
		while (current1.next != null){
			if (current1 == current2) return current1.data;
			current1 = current1.next;
			current2 = current2.next;
		}
		return 1;
	}
}
