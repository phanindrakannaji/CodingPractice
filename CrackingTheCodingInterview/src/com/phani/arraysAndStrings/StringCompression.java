package com.phani.arraysAndStrings;

import java.util.*;
public class StringCompression {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a string:");
		String str = sc.nextLine();
		System.out.println(getCompressedString(str));
	}

	public static String getCompressedString(String str){
		StringBuilder sb = new StringBuilder();
		char[] cArr = str.toCharArray();
		boolean firstChar = true;
		char previousChar = 'a';
		int count = 0;
		int numSwitches = 0;
		for (char c : cArr){
			if (firstChar){
				previousChar = c;
				firstChar = false;
				sb.append(String.valueOf(c));
				count++;
			} else{
				if (previousChar == c){
					count++;
				} else{
					numSwitches = numSwitches + 2;
					if (numSwitches >= str.length()){
						return str;
					}
					sb.append(String.valueOf(count));
					sb.append(String.valueOf(c));
					previousChar = c;
					count = 1;
				}
			}
		}
		sb.append(count);
		return sb.toString();
	}
}
