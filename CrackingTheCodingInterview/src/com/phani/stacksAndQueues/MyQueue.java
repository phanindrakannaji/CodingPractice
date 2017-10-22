package com.phani.stacksAndQueues;

import java.util.EmptyStackException;

public class MyQueue<T> {
	private static class QueueNode <T>{
		private T data;
		private QueueNode<T> next;
		
		public QueueNode(T data) {
			this.data = data;
		}
	}
	
	private QueueNode<T> first;
	private QueueNode<T> last;
	
	public T remove() {
		if (first == null) throw new EmptyStackException();
		T data = first.data;
		first = first.next;
		if (first == null) last = null;
		return data;
	}
	
	public void add (T data){
		QueueNode<T> node = new QueueNode<T>(data);
		if (last != null){
			last.next = node;
		}
		last = node;
		if (first == null) first = last;
	}
	
	public T peek(){
		if (first == null) throw new EmptyStackException();
		return first.data;
	}
	
	public boolean isEmpty(){
		return first == null;
	}
}
