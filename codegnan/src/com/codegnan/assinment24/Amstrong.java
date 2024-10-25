package com.codegnan.assinment24;

import java.util.Scanner;

public class Amstrong {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m=sc.nextInt();
		int n=m;
		int p= (""+n+"").length();
		int sum=0;
		while(n>0) {
			int r = n%10;
			sum+=Math.pow(r, p);
			n/=10;
		}
		if(sum==m)System.out.println("Amstrong Number");
		else System.out.println("not the amstrong number");
	}

}
