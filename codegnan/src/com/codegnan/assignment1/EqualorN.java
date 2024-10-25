package com.codegnan.assignment1;

import java.util.Scanner;

public class EqualorN {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter two numbers:-");
		int a = sc.nextInt();
		int b = sc.nextInt();
		System.out.println((a==b)?"Number1 and Number2 are Equal": "Number1 and Number2 are not equal");
		sc.close();
	}

}
