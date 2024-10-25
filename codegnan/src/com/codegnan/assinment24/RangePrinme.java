package com.codegnan.assinment24;

import java.util.Scanner;

public class RangePrinme {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		System.out.println('1');
		System.out.println('2');
		for( int i =3;i<=n;i++) {
			boolean b=true;
			for( int j=2;j<i;j++) {
				if(i%j==0) {
					b=false;
					break;
				}
			}
			if(b) {
				System.out.println(i);
			}
		}
		sc.close();
	}
}
