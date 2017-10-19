package com.phani.arraysAndStrings;
import java.util.*;
public class StringRotation {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter first string:");
		String str1 = sc.nextLine();
		System.out.println("Enter second string:");
		String str2 = sc.nextLine();
		System.out.println(isRotation(str1, str2));
	}

	public static boolean isRotation(String str1, String str2){
		String newStr = str2 + str2;
		return newStr.indexOf(str1) >= 0;
	}

}
