package com.phani.stacksAndQueues;

import java.util.*;

public class StackOfPlates<T> {
	private int maxCount = 5;
	private int index = -1;
	private List<Stack<T>> platesSet = new ArrayList<Stack<T>>();
	
	private static class Plate<T>{
		T data;
		Plate<T> next;
		
		public Plate(T data){
			this.data = data;
		}
	}
	
	private static class Stack<T>{
		int currentIndex = -1;
		Plate<T> top;
	}
	
	public void push(T data){
		Plate<T> plate = new Plate<T>(data);
		if (index == -1 
				|| (index != -1 && platesSet.get(index) == null)
				|| (index != -1 && platesSet.get(index) != null && platesSet.get(index).currentIndex == maxCount-1)) {
			Stack<T> stack = new Stack<T>();
			stack.top = plate;
			stack.currentIndex++;
			platesSet.add(++index, stack);
		} else {
			Stack<T> stack = platesSet.get(index);
			plate.next = stack.top;
			stack.top = plate;
			stack.currentIndex++;
		}
	}
	
	public T pop(){
		if (index == -1) throw new EmptyStackException();
		T data = platesSet.get(index).top.data;
		platesSet.get(index).top = platesSet.get(index).top.next;
		platesSet.get(index).currentIndex--;
		if (platesSet.get(index).currentIndex == -1){
			index--;
		}
		return data;
	}
	
	public T peek(){
		if (index == -1) throw new EmptyStackException();
		return platesSet.get(index).top.data;
	}
	
	public T pop(int atIndex) throws Exception{
		if (index == -1) throw new EmptyStackException();
		if (atIndex > index || atIndex < 0) throw new Exception("Invalid index");
		if (platesSet.get(atIndex).currentIndex == -1){
			throw new EmptyStackException();
		}
		T data = platesSet.get(atIndex).top.data;
		platesSet.get(atIndex).top = platesSet.get(atIndex).top.next;
		platesSet.get(atIndex).currentIndex--;
		if (platesSet.get(atIndex).currentIndex == -1 && atIndex==index){
			index--;
		}
		return data;
	}
	
	public static void main(String[] args) throws Exception {
		StackOfPlates<Integer> stackOfPlates = new StackOfPlates<Integer>();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter operation: 1-push, 2-pop, 3-popAtIndex, 4-peek, 0-exit");
		int choice = sc.nextInt();
		while (choice != 0){
			switch (choice){
				case 1 : System.out.println("Enter data: ");
						 int data = sc.nextInt();
						 stackOfPlates.push(data);
						 break;
				case 2 : stackOfPlates.pop();
				 		 break;
				case 3 : System.out.println("Enter index to pop:");
						 int atIndex = sc.nextInt();
						 System.out.println("Popped item: " + stackOfPlates.pop(atIndex));
				 		 break;
				case 4 : System.out.println("Peek: " + stackOfPlates.peek());
				 		 break;
				default : System.out.println("Invalid option!!");
			}
			System.out.println("Enter operation: 1-push, 2-pop, 3-popAtIndex, 4-peek, 0-exit");
			choice = sc.nextInt();
		}
		
		sc.close();
	}

}
