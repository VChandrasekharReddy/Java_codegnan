package com.codegnan.assinment24;

import java.util.Scanner;

public class RangePerfect {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x=sc.nextInt();
		for(int i =2;i<=x;i++) {
			int sum=0;
			for( int j=1;j<i;j++) {
				if(i%j==0) {
					sum+=j;
				}
				
			}
			if(sum==i) {
				System.out.println(i);
			}
		}
		sc.close();
	}

}
