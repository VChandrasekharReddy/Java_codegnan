package com.codegnan.assignmet2;

import java.util.Scanner;

public class PNCount {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int p =0,n=0,z=0;
		System.out.println("enter how many numbers you want to read");
		int  s = sc.nextInt();
		for(int i=0 ; i<s;i++) {
			int num = sc.nextInt();
			if(num>0) p++;
			else if(num<0)n++;
			else z++;
		}
		System.out.println("positives are "+p + " nagatives are " + n+" Zeros are "+ z);
		sc.close();
	}

}
