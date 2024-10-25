package jacaclass.day1;

import java.util.Scanner;

public class Anagrams {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s1=sc.nextLine().toLowerCase();
		String s2=sc.nextLine().toLowerCase();
		int a = (char)'a';
		boolean b=true;
		for(int i=a ;i<(a+26);i++) {
//			System.out.println((char)i);
			int c1=0;
			int c2=0;
			
			for(int j=0;j<s1.length();j++) {
				if(((char)i)==s1.charAt(j)) {
					c1++;
//					System.out.println(c1);
				}
			}
			for(int k=0;k<s2.length();k++) {
				if(((char)i)==s2.charAt(k)) {
					c2++;
//					System.out.println(c2);
				}
			}
			if(c1>0 && c2>0) {
				if(c1!=c2) {
					b=false;
					break;
				}
			}
		}
		if(b)System.out.println("Anagrams");
		else System.out.println(" not Anagrams");
		sc.close();
	}

}
