package com.codegnan.assignmet2;

public class ReverseAlpha {
	public static void main(String[] args) {
		String al="abcdefghijklmnopqrstuvwxyz";
		al=al.toUpperCase();
		for(int i = al.length()-1;i >=0;i--) {
			System.out.println(al.charAt(i));
		}
	}


}
