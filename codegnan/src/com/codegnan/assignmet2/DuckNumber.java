package com.codegnan.assignmet2;

import java.util.Scanner;

public class DuckNumber {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String n = ""+sc.nextInt()+"";
		boolean b=true;
		for( int i =0 ; i<n.length();i++) {
			if(n.charAt(i)=='0') { 
				System.out.println(n+" is a duck number");
				b=false;
				break;
			}
		
		}
		if(b)System.out.println(n+" is not a duck number");
		sc.close();
	}

}
