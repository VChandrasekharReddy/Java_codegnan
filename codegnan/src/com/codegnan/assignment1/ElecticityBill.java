package com.codegnan.assignment1;

import java.util.Scanner;

public class ElecticityBill {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the id:-");
		String id = sc.nextLine();
		System.out.print("Enter the customer name:-");
		String name = sc.nextLine();
		System.out.print("Enter number of units cunsumed:-");
		int units = sc.nextInt();
		float amount =0;
		if (units>0) {
			if(units>=600) {
				amount = (float)(199*1.2)+ (float)(200*1.5) + (float)(200*1.8)+ (float)((units-599)*2.0);
			}
			else if(units >=400) {
				amount = (float)(199*1.2)+ (float)(200*1.5) + (float)((units-399)*1.8);
			}
			else if (units>=200) {
				amount = (float)(199*1.2)+ (float)((units-199)*1.5);
			}
			else {
				amount =  (float)(units*1.2);
			}
		}
		System.out.println("customer id:-"+id);
		System.out.println("customer name:-"+name);
		System.out.println("units counsumed:-"+units);
		System.out.println("Total amoutn for the cunsumed units"+amount);
		sc.close();
	}

}
