package com.codegnan.assignmet2;

import java.util.Scanner;

public class Tables {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter number ");
		int n = sc.nextInt();
		for( int i=1;i<=10;i++) {
			System.out.println(i+"*"+n+"\t=1"+i*n);
		}
		sc.close();
	}

}
