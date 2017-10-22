package com.phani.stacksAndQueues;

import java.util.EmptyStackException;
import java.util.Scanner;

public class SortStack {
	private MyStack<Integer> myStack;
	
	public SortStack(){
		myStack = new MyStack<Integer>();
	}
	
	public void add(Integer data){
		if (myStack.isEmpty()){
			myStack.push(data);
			return;
		}
		MyStack<Integer> tempStack = new MyStack<Integer>();
		while ((!myStack.isEmpty()) && myStack.peek() < data){
			tempStack.push(myStack.pop());
		}
		myStack.push(data);
		while (! tempStack.isEmpty()){
			myStack.push(tempStack.pop());
		}
	}

	public Integer remove(){
		if (myStack.isEmpty()) throw new EmptyStackException();
		return myStack.pop();
	}

	public Integer peek(){
		if (myStack.isEmpty()) throw new EmptyStackException();
		return myStack.peek();
	} 

	public boolean isEmpty(){
		return myStack.isEmpty();
	}
	
	public static void main(String[] args) {
		SortStack sortStack = new SortStack();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter operation: 1-add, 2-remove, 3-peek, 0-exit");
		int choice = sc.nextInt();
		while (choice != 0){
			switch (choice){
				case 1 : System.out.println("Enter data: ");
						 int data = sc.nextInt();
						 sortStack.add(data);
						 break;
				case 2 : System.out.println("Removed item is : " + sortStack.remove());
				 		 break;
				case 3 : System.out.println("Peek : " + sortStack.peek());
				 		 break;
				default : System.out.println("Invalid option!!");
			}
			System.out.println("Enter operation: 1-add, 2-remove, 3-peek, 0-exit");
			choice = sc.nextInt();
		}
		
		sc.close();
	}

}
