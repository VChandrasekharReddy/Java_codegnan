package com.codegnan.assinment24;

import java.util.Scanner;

public class SpyNumber {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the number");
		int n = sc.nextInt();
		int num=n;
		int p = 1;
		int sum=0;
		while(num>0) {
			int r= num%10;
			sum+=r;
			p*=r;
			num/=10;
		}
		if(sum==p) {
			System.out.println(n+"is a Spy Number");
		}else System.out.println(n+"is not Spy number");
		sc.close();
	}


}
