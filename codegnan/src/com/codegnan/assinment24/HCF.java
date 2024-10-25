package com.codegnan.assinment24;

import java.util.Scanner;

public class HCF {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the first number");
		int a = sc.nextInt();
		System.out.println("enter the secound number");
		int b= sc.nextInt();
		
		for( int i = a<b?a:b ; i>0;i--) {
			if(a%i==0 && b%i==0) {
				System.out.println(i);
				break;
			}
		}
		sc.close();
	}


}
