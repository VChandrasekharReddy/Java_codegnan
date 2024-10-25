package com.codegnan.assinment24;

import java.util.Scanner;

public class RangeFAct {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x=sc.nextInt();
		for(int n=1;n<=x;n++) {
			int f =1;
			for( int i =1 ; i<=n;i++) {
				f*=i;
			}
			System.out.println(f);
		}
		sc.close();
	}

}
