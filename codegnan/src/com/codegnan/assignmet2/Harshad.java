package com.codegnan.assignmet2;

import java.util.Scanner;

public class Harshad {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m= n;
		int sum =0;
		while(m>0) {
			int r = m%10;
			sum+=r;
			m/=10;
		}
		if(n%sum==0) System.out.println(n+" is a Harshad number");
		else System.out.println(n+" is not a Harshad number");
		sc.close();
	}

}
