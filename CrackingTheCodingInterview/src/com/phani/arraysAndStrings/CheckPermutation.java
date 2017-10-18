package com.phani.arraysAndStrings;

import java.util.*;

public class CheckPermutation {
	public static void main (String[] args){
		System.out.println("Enter a string: ");
		Scanner sc = new Scanner(System.in);
		String str1 = sc.nextLine();
		String str2 = sc.nextLine();
		if (checkPermutation(str1, str2)){
			System.out.println("Permuted");
		} else{
			System.out.println("Non-Permuted");
		}
	}

	private static boolean checkPermutation(String str1, String str2) {
		if (str1.length() != str2.length()) return false;
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (int i = 0; i<str1.length();i++){
			String c = str1.substring(i,i+1);
			if (map.containsKey(c)){
				map.put(c, map.get(c) + 1);
			} else{
				map.put(c, 1);
			}
		}
		for (int i = 0; i<str2.length();i++){
			String c = str2.substring(i,i+1);
			if (map.containsKey(c)){
				map.put(c, map.get(c) - 1);
			} else{
				return false;
			}
		}
		int sum = 0;
		for (String s : map.keySet()){
			sum = sum + map.get(s);
		}
		return sum == 0;
	}
}
