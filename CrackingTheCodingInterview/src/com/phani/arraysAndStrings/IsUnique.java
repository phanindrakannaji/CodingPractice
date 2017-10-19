package com.phani.arraysAndStrings;

import java.util.Scanner;
import java.util.*;

public class IsUnique {
	public static void main (String[] args){
		System.out.println("Enter a string: ");
		String str = (new Scanner(System.in)).nextLine();
		doWithDS(str);
		doWithoutDS(str);
		actualAnswer(str);
	}

	public static void doWithDS(String str) {
		char[] charArray = str.toCharArray();
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (char c : charArray) {
			if (map.containsKey(String.valueOf(c))) {
				System.out.println("DS: Not Unique");
				return;
			} else {
				map.put(String.valueOf(c), 1);
			}
		}
		System.out.println("DS: Unique");
	}

	public static void doWithoutDS(String str) {
		char[] charArray = str.toCharArray();
		for (int i=0;i<charArray.length;i++){
			for (int j=i+1; j<charArray.length;j++){
				if (charArray[i] == charArray[j]){
					System.out.println("NDS: Not Unique");
					return;
				}
			}
		}
		System.out.println("NDS: Unique");
	}
	
	public static void actualAnswer(String str){
		if (str.length() > 128){
			System.out.println("AS: Not Unique");
			return;
		}
		boolean[] bArray = new boolean[128];
		for (int i = 0; i< str.length(); i++){
			char c = str.charAt(i);
			if (bArray[c]){
				System.out.println("AS: Not Unique");
				return;
			} 
			bArray[c] = true;
		}
		System.out.println("AS: Unique");
		return;
	}
}
