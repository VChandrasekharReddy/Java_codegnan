package codegnan;

import java.util.Scanner;

public class Ex {
	@SuppressWarnings("resource")
	public static void main(String[] args) throws ToLateException,ToFastException{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the age");
		int a = sc.nextInt();
		if(a<18) {
			throw new ToFastException();		
		}
		else if(a>36) {
			throw new ToLateException();
		}
		else System.out.println("get ready ....");
		sc.close();
		
	}

}
