package com.codegnan.assignmet2;

import java.util.Scanner;

public class SumofDigits {
	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		System.out.println("Enter the number");
		int n = sc.nextInt();
		int sum =0;
		int r=0;
		while(n>0) {
			r = n%10;
			sum+=r;
			n/=10;
		}
		System.out.println(sum);
		sc.close();
		}

}
