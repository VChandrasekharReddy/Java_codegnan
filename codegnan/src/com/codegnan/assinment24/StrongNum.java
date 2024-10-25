package com.codegnan.assinment24;

import java.util.Scanner;

public class StrongNum {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int i=sc.nextInt();
		int n=i;
		int sum=0;
		while(n>0) {
			int r= n%10;
			int p=1;
			for( int j=1;j<=r;j++) {
				p*=j;
			}
			sum+=p;
			n/=10;
		}
		if(sum==i) {
			System.out.println("strong number");
		}
		else System.out.println("not Strong number");
		sc.close();
	}

}
