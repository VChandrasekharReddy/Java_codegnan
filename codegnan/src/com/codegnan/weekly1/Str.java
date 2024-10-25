package com.codegnan.weekly1;

public class Str {
	public static void main(String[] args) {
		int arr[] = {22,1,33,21,30};
		int m =0 ;
		int n=0;
		for (int i : arr) {
			if(i>m) {
				m=i;
				if(i>n) {
					n=i;
					m=n;
				}
			}
		}
		System.out.println(n);
				
	}

}
