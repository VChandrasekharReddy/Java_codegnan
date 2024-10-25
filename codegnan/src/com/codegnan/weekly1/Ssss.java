package com.codegnan.weekly1;

import java.util.Scanner;

public class Ssss {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String a = "";
		int sum =0;
		while(true) {
			int num = sc.nextInt();
			if ( num >=0) {
				a=a+" "+num+"";
				sum += num;
			}else break;
			
		}
		System.out.println("You entered the following positive numbers:");
		int c=0;
		for( int i=1 ;i<a.length();i++) {
			if(a.charAt(i)==' ' || i==a.length()-1){
				System.out.println(a.substring(c+1,i+1));
				c=i;
			}
			
		}
		System.out.println("The sum of the positive numbers is: "+sum);
		sc.close();
	}

}
