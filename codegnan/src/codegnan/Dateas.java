package codegnan;

import java.time.LocalDateTime;
import java.util.Scanner;

public class Dateas {

	public int[] returnArray(String a) {
		
		if(a.length()>0) {
			
		}
		return null;
		
	}
	public static void main(String[] args) {
		Dateas d = new Dateas();
		Scanner sc = new Scanner(System.in);
		String a=sc.nextLine();
		String b = sc.nextLine();
		String c = sc.nextLine();
		int[] arra= d.returnArray(a);
		int[] arrb = d.returnArray(b);
		int[] arrc =  d.returnArray(c);
		
	}
}
