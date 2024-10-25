package com.codegnan.assignment1;

import java.util.Scanner;

public class LargeAmongThree {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("enter the number:-");
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		
		System.out.println(((a>b)&&(a>c))?a+" is larger number": (b>c)? b+" is the largers number":c+"is the largest number");
		sc.close();
	}

}
