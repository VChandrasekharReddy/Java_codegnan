package com.codegnan.assignment1;

import java.util.Scanner;

public class MenuCalc {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Choose Your Option\n1)Addition \n2)Substract\n3)Multiplication\n4)Division\n:-");
		int cho=sc.nextInt();
		System.out.print("number1:-");
		int n1 = sc.nextInt();
		System.out.print("number1:-");
		int n2 = sc.nextInt();
		switch(cho) {
		case 1:
			System.out.println("The Addition of "+n1+" and "+n2+" is: "+(n1+n2));
			break;
		case 2:
			System.out.println("The Substract of "+n1+" and "+n2+" is: "+(n1-n2));
			break;
		case 3:
			System.out.println("The Multiplication of "+n1+" and "+n2+" is: "+(n1*n2));
			break;
		case 4:
			System.out.println("The Division of "+n1+" and "+n2+" is: "+(n1/n2));
			break;
		default:
			
		}
		
	sc.close();}

}
