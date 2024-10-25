package com.codegnan.assignment1;

import java.util.Scanner;

public class Larger {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n1 = sc.nextInt();
		int n2 = sc.nextInt();
		System.out.println((n1>n2)?n1:n2);
		sc.close();
	}
}
