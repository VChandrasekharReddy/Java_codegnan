package com.codegnan.assinment24;

import java.util.Scanner;

public class NeonNumber {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the number");
		int num = sc.nextInt();
		int sn = num*num;
		int sum=0;
		while(sn>0) {
			int r= sn%10;
			sum+=r;
			sn/=10;
		}
		if(sum==num) {
			System.out.println(num+"is a Neon number");
		}else System.out.println(num+"is not a Neon number");
		sc.close();
	}

}
