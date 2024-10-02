package banking;

import java.util.ArrayList;
import java.util.Scanner;

public class Main{
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		ArrayList<Checking_Account> ac = new ArrayList<>();
		String userid , name,password;
		double amount;
		boolean db;
		int j;
		boolean b= true;
		System.out.println("1 – Create An Account ");
		System.out.println("2 – Delete An Account ");
		System.out.println("3 – Make An Account Deposit ");
		System.out.println("4 – Make An Account Withdrawal ");
		System.out.println("5 – Check An Account Balance ");
		System.out.println("6– Exit ");
		
		while(b) {		
			System.out.println();
			System.out.print("Enter your choice: - ");
			int n = sc.nextInt();
			sc.nextLine();
			switch(n) {
			
			
			//creating Account case 1
			case 1:
				System.out.print("Enter Customer Name:");
				name = sc.nextLine();
				System.out.print("Enter User ID:");
				userid = sc.nextLine();
				System.out.print("Enter User Password: ");
				password = sc.nextLine();
				try {
					PasswordValidator  validator = new  PasswordValidator();
					validator.validatePassword(password);
					ac.add(new Checking_Account(name , userid, password));
					System.out.println("Account genrated Sucessfully.......");
					System.out.println();
				}catch(InvalidPasswordFormatException e) {
					System.out.println(e);
				}
				break;
				
				
				// Deleting the account case 2
			case 2:

					if(ac.size()>0) {
					db = false;
					j=0;
					System.out.print("Enter User ID:");
					userid = sc.nextLine();
					System.out.print("Enter User Password: ");
					password = sc.nextLine();
					for (int i=0 ; i<ac.size();i++ ) {
						if(userid .equals(ac.get(i).getUserid()) && password.equals(ac.get(i).getUserpassword())) {
							j=i;
							db = true;
							break;
						}
					}
					try {
						UserAccount ua = new UserAccount();
						ua.getuser(db);
						if(db) {
							ac.remove(j);
							System.out.println("deleted....");
							System.out.println();
						}
						System.out.println();
					}catch(CustomerAccountNotFoundException e) {
						System.out.println(e);
						System.out.println();
					}
				}else {
					System.out.println("no user are registered in the bank : ");
				}
				
				
				break;
				
				
				// Making  an account deposit case 3
			case 3: 
				if(ac.size()>0) {
					System.out.print("Enter User ID:");
					userid = sc.nextLine();
					System.out.print("Enter User Password: ");
					password = sc.nextLine();
					db = false;
					j=0;
					for(int i =0 ; i<ac.size();i++) {
						if(userid .equals(ac.get(i).getUserid()) && password.equals(ac.get(i).getUserpassword())) {
							j=i;
							db = true;
							break;
						}
					}
					try {
						UserAccount ua = new UserAccount();
						ua.getuser(db);

						if(db) {
							System.out.println("Enter Amount: ");
							amount = sc.nextDouble();
							NegativeDollar ng = new NegativeDollar();
							ng.dollarSign(amount);
							ac.get(j).setBalance(ac.get(j).getBalance()+amount);
							System.out.println(ac.get(j).getBalance());
							System.out.println();
						}
					}catch(CustomerAccountNotFoundException e) {
						System.out.println(e);
						System.out.println();
					}catch (NegativeDollarAmountException e) {
						System.out.println(e);
						System.out.println();
					}
				}
				
				break;
				
				
				
				
				// making an account withdrawal case 4
			case 4:
				if(ac.size()>0) {
					System.out.print("Enter User ID:");
					userid = sc.nextLine();
					System.out.print("Enter User Password: ");
					password = sc.nextLine();
					db = false;
					j=0;
					for(int i =0 ; i<ac.size();i++) {
						if(userid .equals(ac.get(i).getUserid()) && password.equals(ac.get(i).getUserpassword())) {
							j=i;
							db = true;
							break;
						}
					}
					try {
						UserAccount ua = new UserAccount();
						ua.getuser(db);

						if(db) {
							System.out.println("Enter Amount You want to withdraw : ");
							amount = sc.nextDouble();
							NegativeDollar ng = new NegativeDollar();
							ng.dollarSign(amount);
							BalanceAmmount ba = new BalanceAmmount();
							ba.balanceamount(ac.get(j).getBalance(), amount);
							ac.get(j).setBalance(ac.get(j).getBalance()-amount);
							System.out.println(ac.get(j).getBalance());
							System.out.println();
						}
					}catch(CustomerAccountNotFoundException e) {
						System.out.println(e);
						System.out.println();
					}catch (InsufficientFundsException e) {
						System.out.println(e);
						System.out.println();
					}catch (NegativeDollarAmountException e) {
						System.out.println(e);
						System.out.println();
					}
				}
				break;
				
				
				
				
				//Check an account Balance case 5
			case 5:
				if(ac.size()>0) {
					System.out.print("Enter User ID:");
					userid = sc.nextLine();
					System.out.print("Enter User Password: ");
					password = sc.nextLine();
					db = false;
					j=0;
					for(int i =0 ; i<ac.size();i++) {
						if(userid .equals(ac.get(i).getUserid()) && password.equals(ac.get(i).getUserpassword())) {
							j=i;
							db = true;
							break;
						}
					}
					try {
						UserAccount ua = new UserAccount();
						ua.getuser(db);
						if(db) {
							System.out.println();
							System.out.println("Customer Name: " + ac.get(j).getName());
							System.out.println("Account Number:"+ ac.get(j).getAcctountid());
							System.out.println("Account Balance: "+ac.get(j).getBalance());
							System.out.println("Account Type: Checking");
							System.out.println("Account Daily Withdrawal Limit: "+ ac.get(j).getWithdrawlimit());
							System.out.println();
						}
					}catch(CustomerAccountNotFoundException e) {
						System.out.println(e);
						System.out.println();
					}
				}
				else {
					
				}
				break;
				
				//Exit case 6
			case 6:
				System.out.print("do you wan't to exit : - y for exit and n for stay ");
				char c = sc.next().charAt(0);
				if(c=='y') {
					b=false;
				}
				break;
			default:
				System.out.println("Error: Please enter a valid choice (1 thru 6) ");
				System.out.println();
			}

		}
		
		sc.close();
		
	}

}
