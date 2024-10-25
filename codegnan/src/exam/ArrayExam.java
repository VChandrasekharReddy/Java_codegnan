package exam;

import java.util.Scanner;

public class ArrayExam {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(),a=0,b=0,p=0,pp=0,aa=0,bb=0;
		int [] arr= new int[n];
		for(int i =0; i<n;i++) {
			arr[i]=sc.nextInt();
		}
		for( int i=0;i<n-2;i++) {
			for(int j=0;j<n-1;j++) {
				a=arr[i];
				b=arr[j];
				if((a+b)==18) {
					pp=a*b;
					if(pp>p) {
						aa=a;
						bb=b;
					}
				}
			}
		}
		System.out.println("{"+aa+","+bb+"}");
		
	}
}
