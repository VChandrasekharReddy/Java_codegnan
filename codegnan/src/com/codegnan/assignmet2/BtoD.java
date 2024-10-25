package com.codegnan.assignmet2;

import java.util.Scanner;

public class BtoD {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		int p=0;
		int d =0;
		for( int i=s.length()-1;i>=0;i--) {
			
			if(s.charAt(i)=='1') {
				d+=((int)Math.pow(2, p))*1;
				p++;
			}else {
				p++;
			}
		}
		System.out.println(d);
		sc.close();
	}

}
