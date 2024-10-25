package com.codegnan.assignment1;

import java.util.Scanner;

public class OvelCons {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the alphabet:");
		char alpha = sc.next().charAt(0);
		if(Character.isAlphabetic(alpha)) {
			if(alpha=='a' || alpha=='e'|| alpha=='i'||alpha=='o'|| alpha=='u'||alpha=='A' || alpha=='E'|| alpha=='I'||alpha=='O'|| alpha=='U')
				System.out.println("The alphabet is a ovel.");
		}
		else
			System.out.println("The alphabet is a consonant.");
		
		sc.close();
	}

}
