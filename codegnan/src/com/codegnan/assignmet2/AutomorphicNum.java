package com.codegnan.assignmet2;

import java.util.Scanner;

public class AutomorphicNum {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the number");
		int n = sc.nextInt();
		String sn =""+ n*n+"";
		String ns=""+n+"";
		if(ns.equals(sn.substring(sn.length()-ns.length()))) System.out.println(n+" is a Automorphic");
		else System.out.println(n+" is not a Automorphic");
		sc.close();
		
	}

}
