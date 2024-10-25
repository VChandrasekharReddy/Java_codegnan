package jacaclass.day1;

import java.util.Scanner;

public class Tokens {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s=sc.nextLine();
		int start =0;
		int c=0;
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i)==' ' || s.charAt(i)=='!' || s.charAt(i)==',' || s.charAt(i)=='.' || s.charAt(i)=='_' || s.charAt(i)==((char) 39) || s.charAt(i)=='@'|| i==s.length()-1) {
				if(i-start>0) {
					System.out.println(s.substring(start,i));
					c++;
					start=i+1;
				}
			}
			
		}
		System.out.println(c);
		sc.close();
	}

}
