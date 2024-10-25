package com.codegnan.assignmet2;

import java.util.Scanner;

public class Prime {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the number");
		int n = sc.nextInt();
		boolean temp = true;
		if(n==1 || n==2) {
			System.out.println("prime");
		}
		else {
			for( int i =2;i<n/2;i++) {
				if(n%i==0) {
					temp = false;
					break;
				}
			}
			if(temp) {
				System.out.println("prime");
			}else System.out.println("not a prime");
		}
		sc.close();
	}

}
