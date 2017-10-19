package com.phani.arraysAndStrings;

import java.util.*;

public class PalindromePermutation {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter string");
		String str = sc.nextLine();
		System.out.println(isPalindromePermutation(str.replace(" ", "")));
	}

	public static boolean isPalindromePermutation (String str){
		List<String> list = new ArrayList<String>();
		char[] cArr = str.toCharArray();
		for (char c : cArr){
			if (list.contains(String.valueOf(c))){
				list.remove(String.valueOf(c));
			} else{
				list.add(String.valueOf(c));
			}
		}
		return (list.size() == 0 || list.size() ==1);
	}
}
