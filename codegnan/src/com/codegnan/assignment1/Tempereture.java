package com.codegnan.assignment1;

import java.util.Scanner;

public class Tempereture {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the temperature in *C cel");
		int t = sc.nextInt();
		if(t>=40) System.out.println("Its Very Hot");
		else if(t>30) System.out.println("Its Hot");
		else if(t>20) System.out.println("Normal in Temp");
		else if(t>10) System.out.println(" Cold weather");
		else if (t>0) System.out.println("Very Cold weather");
		else System.out.println("Freezing weather");
		sc.close();
	}

}
