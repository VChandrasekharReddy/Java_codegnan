package com.codegnan.assinment24;

import java.util.Scanner;

public class RangeAmstrong {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int i= sc.nextInt();
		for(int m=1;m<=i;m++) {
			int n=m;
			int p= (""+n+"").length();
			int sum=0;
			while(n>0) {
				int r = n%10;
				sum+=Math.pow(r, p);
				n/=10;
			}
			if(sum==m)System.out.println(sum);
		}
		sc.close();
	}

}
