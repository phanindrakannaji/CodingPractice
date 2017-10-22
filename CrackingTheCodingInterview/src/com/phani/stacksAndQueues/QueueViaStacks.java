package com.phani.stacksAndQueues;

import java.util.EmptyStackException;
import java.util.Scanner;

public class QueueViaStacks<T> {
	private MyStack<T> newStack;
	private MyStack<T> oldStack;

	public QueueViaStacks(){
		newStack = new MyStack<T>();
		oldStack = new MyStack<T>();
	}

	public void add(T data){
		newStack.push(data);
	}

	public T remove(){
		if (oldStack.isEmpty() && newStack.isEmpty()){
			throw new EmptyStackException();
		}
		if (oldStack.isEmpty()){
			while (!newStack.isEmpty()){
				oldStack.push(newStack.pop());
			}
		}
		return oldStack.pop();
	}

	public T peek(){
		if (oldStack.isEmpty() && newStack.isEmpty()){
			throw new EmptyStackException();
		}
		if (oldStack.isEmpty()){
			while (!newStack.isEmpty()){
				oldStack.push(newStack.pop());
			}
		} 
		return oldStack.peek();
	}

	public boolean isEmpty(){
		return (newStack.isEmpty() && oldStack.isEmpty());
	}

	public static void main(String[] args){
		QueueViaStacks<Integer> queue = new QueueViaStacks<Integer>();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter operation: 1-add, 2-remove, 3-peek, 0-exit");
		int choice = sc.nextInt();
		while (choice != 0){
			switch (choice){
				case 1 : System.out.println("Enter data: ");
						 int data = sc.nextInt();
						 queue.add(data);
						 break;
				case 2 : System.out.println("Removed item is : " + queue.remove());
				 		 break;
				case 3 : System.out.println("Peek : " + queue.peek());
				 		 break;
				default : System.out.println("Invalid option!!");
			}
			System.out.println("Enter operation: 1-add, 2-remove, 3-peek, 0-exit");
			choice = sc.nextInt();
		}
		
		sc.close();
	}
}
