package codegnan.pra.day1;

import java.util.Scanner;

public class VoteEligiblity {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int age = sc.nextInt();
		if(age>=18) System.out.println("eligible for vote");
		else System.out.println("not eligible for vote");
		sc.close();
	}

}
