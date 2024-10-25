package exam;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class AboutSet {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Set<Integer> number = new HashSet<>();
		number.add(1);
		number.add(2);
		number.add(3);
		number.add(4);
		number.add(5);
		number.add(3);
		System.out.println(number);
	}

}
