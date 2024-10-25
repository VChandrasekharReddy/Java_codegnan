package com.codegnan.assignment1;

import java.util.Scanner;

public class EorO {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("enter the number:-");
		int number = sc.nextInt();
		System.out.println((number%2==0)?number+" is even integer": number+" id odd integer");
		sc.close();
	}

}
