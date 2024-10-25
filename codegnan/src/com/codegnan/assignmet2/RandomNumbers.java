package com.codegnan.assignmet2;

import java.util.Scanner;

public class RandomNumbers {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println((int)Math.random()*n+1);
		sc.close();
		}

}
