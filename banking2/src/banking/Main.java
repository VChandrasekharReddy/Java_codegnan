package banking;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		UserClass user = new UserClass();
		EmployeeClass emp = new EmployeeClass();
		Scanner sc = new Scanner(System.in);
		boolean b = true;
		while(b) {
			System.out.println("1) User Register : ");
			System.out.println("2) Employee Register : ");
			System.out.println("3) User Login : ");
			System.out.println("4) Employee Login : ");
			System.out.println("5) shut down : ");
			int n = sc.nextInt();
			switch(n) {
			case 1 : 
				try {
					user.userRegister();
				} catch (InvalidPasswordFormatException e) {
					// TODO Auto-generated catch block
					System.out.println(e);
				}
				System.out.println();
				System.out.println();
				break;
			case 2 : 
				try {
					emp.empRegistration();
				} catch (InvalidPasswordFormatException e) {
					// TODO Auto-generated catch block
					System.out.println(e);
				}
				break;
			case 3 : 
				try {
					user.userLogin();
				} catch (InvalidPasswordFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println();
				System.out.println();
				break;
			case 4 : 
				try {
					emp.empLogin();
				} catch (InvalidPasswordFormatException e) {
					// TODO Auto-generated catch block
					System.out.println(e);
				}
				break;
			case 5 : 
				b= false;				
				break;
			default:
				
			}

		}
		sc.close();
	}


}
