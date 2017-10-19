package com.phani.arraysAndStrings;

import java.util.*;

public class OneAway {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter first String: ");
		String str1 = sc.nextLine();
		System.out.println("Enter second String: ");
		String str2 = sc.nextLine();
		System.out.println(isOneAway(str1, str2));
	}

	public static boolean isOneAway(String str1, String str2) {
		if (str1 == str2 || (str1 == null && str2 == null)){
			return true;
		}
		if ((str1 == null && str2.length() == 1) || (str2 == null && str1.length() == 1)){
			return true;
		}
		if (str1 != null && str1.equals(str2)) {
			return true;
		}
		if (str1 != null && str2 != null){
			int len1 = str1.length();
			int len2 = str2.length();
			int diff = len1 - len2;
			if (diff != 0 && diff != 1 && diff != -1){
				return false;
			} else {
				String big = (len1 >= len2)?str1 : str2;
				String small = (len1>=len2)?str2 : str1;
				if (diff == 0){
					int i = 0;
					while (i < len1 && big.charAt(i) == small.charAt(i)){
						i++;
					}
					if (i != len1-1){
						i++;
						while (i < len1 && big.charAt(i) == small.charAt(i)){
							i++;
						}
						if (i != len1){
							return false;
						}
					}
				} else{
					int i = 0;
					while (i < small.length() && big.charAt(i) == small.charAt(i)){
						i++;
					}
					if (i != small.length()){
						i++;
						while (i < big.length() && big.charAt(i) == small.charAt(i-1)){
							i++;
						}
						if (i != big.length()){
							return false;
						}
					} 
				}
			}
		} else{
			return false;
		}
		return true;
	}

}
