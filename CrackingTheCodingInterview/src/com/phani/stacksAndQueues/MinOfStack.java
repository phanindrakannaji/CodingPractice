package com.phani.stacksAndQueues;

import java.util.EmptyStackException;
import java.util.Scanner;

public class MinOfStack<T> {
	private static class StackNode<T> {
		private T data;
		private StackNode<T> next;
		private T previousMin;
		
		public StackNode (T data, T previousMin) {
			this.data = data;
			this.previousMin = previousMin;
		}
	}
	
	private StackNode<T> top;
	
	public T pop(){
		if (top == null) throw new EmptyStackException();
		T data = top.data;
		top = top.next;
		return data;
	}
	
	public void push (T data){
		StackNode<T> node = null;
		if (top == null){
			node = new StackNode<T>(data, data);
		} else{
			T topData = top.data;
			if ((Integer)topData <= (Integer)data){
				node = new StackNode<T>(data, topData);
			} else{
				node = new StackNode<T>(data, top.previousMin);
			}
		}
		node.next = top;
		top = node;
	}
	
	public T min(){
		if (top == null)  throw new EmptyStackException();
		return ((Integer)top.previousMin < (Integer)top.data) ? top.previousMin : top.data;
	}
	
	public void peek(){
		if (top == null) throw new EmptyStackException();
		System.out.println("Data:" + top.data + ", PreviousMin: " + top.previousMin);
	}
	
	public boolean isEmpty (){
		return top == null;
	}
	
	
	public static void main(String[] args){
		MinOfStack<Integer> stack = new MinOfStack<Integer>();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter operation: 1-push, 2-pop, 3-min, 4-peek, 0-exit");
		int choice = sc.nextInt();
		while (choice != 0){
			switch (choice){
				case 1 : System.out.println("Enter data: ");
						 int data = sc.nextInt();
						 stack.push(data);
						 break;
				case 2 : stack.pop();
				 		 break;
				case 3 : System.out.println("Stack Min: " + stack.min());
				 		 break;
				case 4 : System.out.println("Peek: ");
				 		 stack.peek();
				 		 break;
				default : System.out.println("Invalid option!!");
			}
			System.out.println("Enter operation: 1-push, 2-pop, 3-min, 4-peek, 0-exit");
			choice = sc.nextInt();
		}
		
		sc.close();
	}
}
