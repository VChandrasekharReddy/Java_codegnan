package com.codegnan.assignmet2;

import java.util.Scanner;

public class LS {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter how many numbers you want to read");
		int  n = sc.nextInt();
		int num = sc.nextInt();
		int s=num,l=num;
		for(int i =1; i<n;i++) {
			num = sc.nextInt();
			if(num >l) l=num;
			if(num <s) s=num;
		}
		System.out.println("larges number "+ l+" smalest number are "+s);
		sc.close();
	}

}
