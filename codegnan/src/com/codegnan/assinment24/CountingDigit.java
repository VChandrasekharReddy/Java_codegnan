package com.codegnan.assinment24;

import java.util.Scanner;

public class CountingDigit {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n= sc.nextInt();
		int c=0;
		while(n>0) {
			c++;
			n=n/10;
		}
		System.out.println(c);
		sc.close();
	}
}
