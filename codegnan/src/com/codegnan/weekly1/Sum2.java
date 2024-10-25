package com.codegnan.weekly1;

import java.util.Scanner;

public class Sum2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int sum =0;
		System.out.println("You entered the following positive numbers:");
		while(true) {
			int num = sc.nextInt();
			if(num>=0) {
				System.out.println(num);
				sum+=num;
			}else break;
		}
		System.out.println("The sum of the positive numbers is: "+sum);
		sc.close();
	}

}
