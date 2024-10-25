package com.codegnan.assinment24;

import java.util.Scanner;

public class SumofEvenandOdd {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n= sc.nextInt();
		int even=0,odd=0;
		for( int i =2 ; i<=n;i+=2) {
			even+=i;
		}
		for( int i =1 ; i<=n;i+=2) {
			odd+=i;
		}
		System.out.println(even);
		System.out.println(odd);
		sc.close();
	}
}
