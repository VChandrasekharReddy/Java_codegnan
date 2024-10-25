package com.codegnan.assignmet2;

public class Strong1to100000 {
	public static void main(String[] args) {
		for(int i=0 ; i<=100000;i++) {
			int n=i;
			int sum=0;
			while(n>0) {
				int r= n%10;
				int p=1;
				for( int j=1;j<=r;j++) {
					p*=j;
				}
				sum+=p;
				n/=10;
			}
			if(sum==i) {
				System.out.println(i);
			}
		}
	}

}
