package com.codegnan.assignment1;

import java.util.Scanner;

public class CheckChar {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the Chareacter:-");
		int a  =(int) sc.next().charAt(0);
		if(a>=48 && a<=57) {
			System.out.print("is number");
		}
		else if ((a>=65 && a<=90) || (a>=97 && a<=122)) {
			System.out.print("is Alphabet");
		}else {
			System.out.print("is a Splecial Character");
		}
		sc.close();
	}

}
