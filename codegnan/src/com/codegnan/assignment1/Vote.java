package com.codegnan.assignment1;

import java.util.Scanner;

public class Vote {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("enter your age:-");
		int age = sc.nextInt();
		System.out.println((age>18)?"Congratulation! You are eligible for casting your vote.": "You are not eligible for casting your vote.");
		sc.close();
	}

}
