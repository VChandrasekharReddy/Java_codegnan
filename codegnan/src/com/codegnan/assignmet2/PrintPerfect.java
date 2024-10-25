package com.codegnan.assignmet2;

import java.util.Scanner;

public class PrintPerfect {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num=sc.nextInt();
		int sum=0;
		for( int j=1;j<num;j++) {
			if(num%j==0) {
				sum+=j;
			}
			
		}
		if(sum==num) {
			System.out.println(num+" is a perfect number");
	}
		else {
			System.out.println(num+" is not a perfect number");
		}
		sc.close();

}
}
