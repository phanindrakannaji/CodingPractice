package com.phani.arraysAndStrings;

import java.util.*;

public class URLify {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter string");
		String str = sc.nextLine();
		System.out.println("Enter true length");
		int trueLength = sc.nextInt();
		System.out.println(getEncodedString(str, trueLength));
		System.out.println(getEncodedStringInPlace(str, trueLength));
		sc.close();
	}

	public static String getEncodedString(String str, int truelength){
		int len = str.length();
		String finalString = "";
		for (int i=truelength-1; i>=0;i--){
			if (str.charAt(i) == 32){
				finalString = "%20" + finalString;
			} else{
				finalString = String.valueOf(str.charAt(i)) + finalString;
			}
		}
		return finalString;
	}

	public static String getEncodedStringInPlace(String str, int truelength){
		int len = str.length();
		char[] cArr = str.toCharArray();
		for (int i=truelength-1; i>=0;i--){
			char c = cArr[i];
			if (c == 32){
				cArr[--len] = '0';
				cArr[--len] = '2';
				cArr[--len] = '%';
			} else{
				cArr[--len] = c;
			}
		}
		return new String(cArr);
	}
}