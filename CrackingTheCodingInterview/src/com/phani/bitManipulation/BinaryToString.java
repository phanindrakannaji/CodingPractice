package com.phani.bitManipulation;

public class BinaryToString {

	public static void main(String[] args) {
		double d = 0.515625;

		if (d<=0 || d>=1){
			System.out.println("ERROR");
			return;	
		} 

		StringBuilder binary = new StringBuilder();
		binary.append(".");

		while (d > 0){
			if (binary.length() >= 32) {
				System.out.println("ERROR");
				return;
			}
			d = d*2;
			if (d >=1){
				binary.append("1");
				d = d-1;
			} else{
				binary.append("0");
			}
		}
		System.out.println(binary.toString());
	}

}
