package com.codegnan.assinment24;

import java.util.Scanner;

public class RangeFibonac {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		int a = 0;
		int b=1;
		System.out.println(a);
		System.out.println(b);
		for( int i=2;i<n;i++) {
			int c = a+b;
			System.out.println(c);
			a=b;
			b=c;
		}
		sc.close();
	}
}
