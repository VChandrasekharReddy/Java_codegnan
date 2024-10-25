package codegnan.pra.day1;

import java.util.Scanner;

public class AverageOfNumbers {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m1 = sc.nextInt();
		int m2 = sc.nextInt();
		int m3 = sc.nextInt();
		int avg = (int) ((m1+m2+m3)/3) ;
		if(avg>=40) System.out.println("pass");
		else System.out.println("fail");
		sc.close();
	}

}
