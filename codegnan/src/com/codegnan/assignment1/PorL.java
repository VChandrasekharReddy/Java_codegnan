package com.codegnan.assignment1;

import java.util.Scanner;

public class PorL {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("enter the selling price of the product :-  ");
		int sp = sc.nextInt();
		System.out.print("enter the cost price of the product :-  ");
		int cp = sc.nextInt();
		System.out.println((sp>cp)?"profit":"loss");
		sc.close();
	}

}
