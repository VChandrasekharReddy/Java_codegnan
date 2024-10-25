package com.codegnan.weekly1;

import java.util.Scanner;

public class PositiveSum {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("enter the syze of the array:-");
		int n= sc.nextInt();
		int[] arr= new int[n];
		int sum = 0;
		int x=0;
		while(true) {
			if(x<n) {
				System.out.print("for "+(x+1)+":-");
				int num = sc.nextInt();
				if(num>=0) {
					arr[x]=num;
					x+=1;
				}
				else break;
			}else break;
		}
		System.out.println("You entered the following positive numbers:");
		for(int i=0 ; i<arr.length;i++) {
			if(arr[i]>0) {
				System.out.println(arr[i]);
				sum+=arr[i];
			}
		}
		System.out.println("The sum of the positive numbers is: "+sum);
		sc.close();
	}

}
