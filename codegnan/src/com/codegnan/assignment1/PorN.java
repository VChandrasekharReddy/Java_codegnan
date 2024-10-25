package com.codegnan.assignment1;

import java.util.Scanner;

public class PorN {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("enter the number:-");
		int number = sc.nextInt();
		System.out.println((number>0)?number+" is Positive Number": number+" is Negative Number");
		sc.close();
	}

}
