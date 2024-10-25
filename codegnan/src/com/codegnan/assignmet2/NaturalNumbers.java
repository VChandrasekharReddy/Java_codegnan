package com.codegnan.assignmet2;

import java.util.Scanner;

public class NaturalNumbers {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for( int i = 1 ; i<=n;i++ ) {
			System.out.println(i);
		}
		sc.close();
	}

}
