package com.phani.stacksAndQueues;

import java.util.*;
public class ThreeInOne {

	public static void main(String[] args) {
		int top1 = 0;
		int top2 = 1;
		int top3 = 2;
		int[] arr = new int[1000];
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter queue number: 1/2/3, 0 to exit");
		int choice = sc.nextInt();
		while (choice != 0){
			if (choice != 1 && choice != 2 && choice != 3){
				System.out.println("Invalid!! Enter queue number: 1/2/3, 0 to exit");
		 		choice = sc.nextInt();
			} else {
				System.out.println ("Enter action: 1-add, 2-remove, 3-peek");
				int action = sc.nextInt();
				if (action != 1 && action !=2 && action !=3){
					System.out.println("Invalid action!!");
				} else{
					switch (action){
						case 1 : 
							System.out.println("Enter data to add: ");
							int data = sc.nextInt();
							switch (choice){
								case 1 : 
									top1 = top1+3;
									arr[top1] = data;
									break;
								case 2 : 
									top2 = top2+3;
									arr[top2] = data;
									break;
								case 3 : 
									top3 = top3+3;
									arr[top3] = data;
									break;
							}
							break;

						case 2 : 
							switch (choice){
								case 1 : 
									if (top1 <= 0){
										System.out.println("Empty stack");	
									} else{
										System.out.println("Removed item: " + arr[top1]);
										top1 = top1-3;
									}
									break;
								case 2 : 
									if (top2 <= 1){
										System.out.println("Empty stack");	
									} else{
										System.out.println("Removed item: " + arr[top2]);
										top2 = top2-3;
									}
									break;
								case 3 : 
									if (top3 <= 2){
										System.out.println("Empty stack");	
									} else{
										System.out.println("Removed item: " + arr[top3]);
										top3 = top3-3;
									}
									break;
							}
							break;

						case 3 :
							switch (choice){
								case 1 : 
									if (top1 <= 0){
										System.out.println("Empty stack");	
									} else{
										System.out.println(" item: " + arr[top1]);
									}
									break;
								case 2 : 
									if (top2 <= 1){
										System.out.println("Empty stack");	
									} else{
										System.out.println(" item: " + arr[top2]);
									}
									break;
								case 3 : 
									if (top3 <= 2){
										System.out.println("Empty stack");	
									} else{
										System.out.println(" item: " + arr[top3]);
									}
									break;
							}
							break;
					}
				}
				System.out.println("Enter queue number: 1/2/3, 0 to exit");
		 		choice = sc.nextInt();
			}
		}
	}

}
