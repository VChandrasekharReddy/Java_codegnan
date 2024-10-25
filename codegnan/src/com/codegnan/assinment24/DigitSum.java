package com.codegnan.assinment24;

import java.util.Scanner;

public class DigitSum {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n= sc.nextInt();
		int rn=0;
		while(n>0) {
			int r = n%10;
			rn+=r;
			n/=10;
		}
		System.out.println(rn);
		sc.close();
	}

}
