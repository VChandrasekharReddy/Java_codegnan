package com.codegnan.assignment1;

import java.util.Scanner;

public class Triangel {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the angles of the triangle");
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		if ((a+b+c)==180 && !((a+b)<c || b+c<a || c+a <b) ) {
			System.out.println("is a triangle");
		}
		sc.close();
		
	}

}
