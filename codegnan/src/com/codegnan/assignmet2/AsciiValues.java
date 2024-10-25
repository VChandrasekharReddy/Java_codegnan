package com.codegnan.assignmet2;

import java.util.Scanner;

public class AsciiValues {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter any value:");
		int i = sc.next().charAt(0);
		System.out.println(i);
		sc.close();
	}

}
