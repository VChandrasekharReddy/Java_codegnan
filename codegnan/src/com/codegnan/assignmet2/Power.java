package com.codegnan.assignmet2;

import java.util.Scanner;

public class Power {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number");
		int num = sc.nextInt();
		System.out.println("enter the power of the numebr:");
		int pow = sc.nextInt();
		int p = num;
		for (int i =2;i <=pow;i++) {
			p*=num;
		}
		System.out.println(p);
		sc.close();
	}

}
