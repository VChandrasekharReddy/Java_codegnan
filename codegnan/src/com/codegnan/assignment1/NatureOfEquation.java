package com.codegnan.assignment1;

import java.util.Scanner;

public class NatureOfEquation {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the a,b,c values for aX*2+bX+c=0");
		int a = sc.nextInt();
		int b= sc.nextInt();
		int c = sc.nextInt();
		int dic = b*b-4*a*c;
		if(dic>0) System.out.println("Real and Unequal");
		else if(dic==0) System.out.println("Real and equal");
		else System.out.println("Unequal and Imaginary");
		sc.close();
	}

}
