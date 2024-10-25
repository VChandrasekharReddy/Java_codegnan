package com.codegnan.assignmet2;

import java.util.Scanner;

public class ReverseDigit {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int rn=0;
		while(n>0) {
			int rem = n%10;
			rn = rn*10 +rem;
			n/=10;
		}
		System.out.println(rn);
		sc.close();
	}

}
