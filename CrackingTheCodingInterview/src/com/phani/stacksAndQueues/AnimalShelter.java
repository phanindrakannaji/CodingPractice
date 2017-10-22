package com.phani.stacksAndQueues;

import java.util.EmptyStackException;
import java.util.Scanner;

public class AnimalShelter {

	private static class Animal{
		String type;
		String name;

		public Animal(String name, String type){
			this.name = name;
			this.type = type;
		}

		public String getType(){
			return this.type;
		}
	}

	private static class Cat extends Animal{
		public Cat(String name){
			super(name, "CAT");
		}
	}

	private static class Dog extends Animal{
		public Dog(String name){
			super(name, "DOG");
		}
	}

	private static class QueueNode{
		private Animal data;
		private QueueNode next;

		public QueueNode(Animal data) {
			this.data = data;
		}
	}

	private QueueNode first;
	private QueueNode last;

	public Animal deQueueAny() {
		if (first == null) throw new EmptyStackException();
		Animal data = first.data;
		first = first.next;
		if (first == null) last = null;
		return data;
	}

	public Animal deQueueDog() {
		if (first == null) throw new EmptyStackException();
		QueueNode currentPet = first;
		if (first.data.getType().equalsIgnoreCase("DOG")){
			Animal data = currentPet.next.data;
			currentPet.next = currentPet.next.next;
			return data;
		}
		while (currentPet.next != null){
			if (currentPet.next.data.getType().equalsIgnoreCase("DOG")){
				Animal data = currentPet.next.data;
				currentPet.next = currentPet.next.next;
				return data;
			}
			currentPet = currentPet.next;
		}
		return null;
	}

	public Animal deQueueCat() {
		if (first == null) throw new EmptyStackException();
		QueueNode currentPet = first;
		if (first.data.getType().equalsIgnoreCase("CAT")){
			Animal data = first.data;
			first = first.next;
			return data;
		}
		while (currentPet.next != null){
			if (currentPet.next.data.getType().equalsIgnoreCase("CAT")){
				Animal data = currentPet.next.data;
				currentPet.next = currentPet.next.next;
				return data;
			}
			currentPet = currentPet.next;
		}
		return null;
	}

	public void enqueue (Animal data){
		QueueNode node = new QueueNode(data);
		if (last != null){
			last.next = node;
		}
		last = node;
		if (first == null) first = last;
	}

	public Animal peek(){
		if (first == null) throw new EmptyStackException();
		return first.data;
	}

	public boolean isEmpty(){
		return first == null;
	}

	public static void main(String[] args){
		AnimalShelter shelter = new AnimalShelter();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter operation: 1-enqueue, 2-dequeueAny, 3-dequeueDog, 4-dequeueCat, 5-peek, 0-exit");
		int choice = sc.nextInt();
		while(choice != 0){
			switch(choice){
			case 1:
				System.out.println("Select type: 1-cat, 2-dog ");
				int type = sc.nextInt();
				sc.nextLine();
				switch(type){
				case 1:
					System.out.println("Enter name: ");
					String name = sc.nextLine();
					Cat cat = new Cat(name);
					shelter.enqueue(cat);
					break;
				case 2:
					System.out.println("Enter name: ");
					name = sc.nextLine();
					Dog dog = new Dog(name);
					shelter.enqueue(dog);
					break;
				default:
					System.out.println("Incorrect option!!");
					break;
				}
				break;
			case 2:
				Animal pet = shelter.deQueueAny();
				System.out.println("The " + pet.getType() + "'s name is : " + pet.name);
				break;
			case 3:
				pet = shelter.deQueueDog();
				System.out.println("The " + pet.getType() + "'s name is : " + pet.name);
				break;
			case 4:
				pet = shelter.deQueueCat();
				System.out.println("The " + pet.getType() + "'s name is : " + pet.name);
				break;
			case 5:
				pet = shelter.peek();
				System.out.println("The " + pet.getType() + "'s name is : " + pet.name);
				break;
			default:
				System.out.println("Invalid choice!!");
				break;
			}
			System.out.println("Enter operation: 1-enqueue, 2-dequeueAny, 3-dequeueDog, 4-dequeueCat, 5-peek, 0-exit");
			choice = sc.nextInt();
		}
		sc.close();
	}
}
