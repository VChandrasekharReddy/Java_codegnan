package com.codegnan.assignment1;

import java.util.Scanner;

public class Coardinates {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("enter the number:-");
		int x = sc.nextInt();
		int y = sc.nextInt();
		if(x>0) {
			if (y>0)System.out.print("The coordinate point ("+x+","+y+") lies in the First quadrant.");
			else System.out.print("The coordinate point ("+x+","+y+") lies in the Forth quadrant.");
		}else {
			if (y>0)System.out.print("The coordinate point ("+x+","+y+") lies in the Sceound quadrant.");
			else System.out.print("The coordinate point ("+x+","+y+") lies in the Third quadrant.");
			
		}
		sc.close();

	}

}
