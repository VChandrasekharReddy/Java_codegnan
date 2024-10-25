package com.codegnan.assignment1;

import java.util.Scanner;

public class Areas {
	static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Choose Your Option\n1)REctangel \n2)Square\n3)cube\n4)cuboide\n4)cuboide\n5)circle\n6)Spear\n:-");
		int cho=sc.nextInt();
		switch(cho) {
		case 1:
			System.out.print("enter the height of the rectangle:-");
			int h = sc.nextInt();
			System.out.print("enter the Width of the rectangle:-");
			int w = sc.nextInt();
			System.out.println("The Area of the Rectangel is "+ (h*w));
			break;
		case 2:
			System.out.print("enter the side of the Square:-");
			int s = sc.nextInt();
			System.out.println("The Area of the Square is "+ (s*s));
			break;
		case 3:
			System.out.print("enter the side of the cube:-");
			int s1 = sc.nextInt();
			System.out.println("The Area of the Cube is "+ s1*s1*s1);
			break;
		case 4:
			System.out.print("enter the height of the cuboid:-");
			int h1 = sc.nextInt();
			System.out.print("enter the breadth of the duboid:-");
			int b = sc.nextInt();
			System.out.print("enter the depth of the cuboid:-");
			int d = sc.nextInt();
			System.out.println("The Area of the cuboid is "+ (d*b*h1));
			break;
		case 5:
			System.out.print("enter the radius of the Circle:-");
			int r = sc.nextInt();
			System.out.println("The Area of the Rectangel is "+ (Math.PI*r*r));
			break;
		case 6:
			System.out.print("enter the height of the rectangle:-");
			int r1 = sc.nextInt();
			System.out.println("The Area of the Rectangel is "+ (4*Math.PI*r1*r1));
			break;
		default:
			System.out.println("You didn't choose among the options :");
			
			
		}
		
	sc.close();}

}
