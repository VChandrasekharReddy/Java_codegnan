package exam;

import java.util.Scanner;

public class Something {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine().toUpperCase();
		String a = "QWERTYUIOP";
		String b = "ASDFGHJKL ";
		String c = " ZXCVBMN  ";
		char start = 'Q';
		int sx=0,sy=0,ex=0,ey=0,td=0;
		for( int i=0;i<s.length();i++) {
			char end = s.charAt(i);
			if(end == 'W' || end == 'E' || end == 'R' || end == 'T' || end == 'Y'|| end == 'U' || end == 'I' || end == 'O' || end == 'P' || end == 'Q') {
				ex=0;
				ey=a.indexOf(s.charAt(i));				
			}
			else if(end == 'A' || end == 'S' || end == 'D' || end == 'F' || end == 'G' || end == 'H'|| end == 'J' || end == 'K' || end == 'L') {
				ex=1;
				ey=b.indexOf(s.charAt(i));				
			}
			else {
				ex = 2;
				ey =1+c.indexOf(s.charAt(i));
			}
			System.out.println(end+" :- ex: "+ex+" ey: "+ey);

			
		}
		
	}
}
