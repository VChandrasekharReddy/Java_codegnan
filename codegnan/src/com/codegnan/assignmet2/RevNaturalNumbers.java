package com.codegnan.assignmet2;

import java.util.Scanner;

public class RevNaturalNumbers {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for( int i=n;i>0;i--) {
			System.out.println(i);
		}
		sc.close();
	}

}
