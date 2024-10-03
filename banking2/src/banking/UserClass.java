package banking;

import java.util.Iterator;
import java.util.Scanner;

public class UserClass extends Data{
	NegativeDollar doller = new NegativeDollar();
	BalanceAmmount balance = new BalanceAmmount();
	Scanner sc = new Scanner(System.in);
	String userId,pass;
	int index =0;
	
	
	public void userRegister() throws InvalidPasswordFormatException {
		
			System.out.print("Enter the username : ");
			String uname = sc.nextLine();
			System.out.print("Enter the user id : ");
			String uid = sc.nextLine();
			System.out.print("Enter the password : ");
			String upass = sc.nextLine();
			if(upass.length()>8 && upass.contains("*")) {
				user.add(new UserData(uname,uid,upass,(double)(user.size()+1)));
			}
			else throw new InvalidPasswordFormatException();			
	}
	
	
	
	
	//user login function perform the login operation in this function
	public void userLogin()throws InvalidPasswordFormatException  {
		System.out.print("Enter the user id: ");
		String uid = sc.nextLine();
		System.out.print("Enter the password : ");
		String upass = sc.nextLine();
		if(upass.length()>8 && upass.contains("*")) {
			Iterator<UserData> userdata = user.iterator();
			index =0;
			while(userdata.hasNext()) {
				UserData userd = userdata.next();
				if(userd.getUid().equals(uid) && userd.getUpass().equals(upass)){
					if(userd.isBlock()) {
						System.out.println("your Account is in hold state or blocked by the bank officials please contace the bank ");
					}else {
						userId = uid;
						pass=upass;
						userInterface(uid , upass);
					}
					
				}
				index++;
			}
		}
		else throw new InvalidPasswordFormatException();
	}
	public void userInterface( String userid , String password) {
		boolean b = true;
		while(b) {
			System.out.println("choose your options\n 1) for account details\n 2) for amount withdrawl \n 3) for amount diposit\n 4) for statement \n 5) for logout \n 6) for delate account  ");
			int n = sc.nextInt();
			sc.nextLine();
			switch(n) {
			case 1:
				Iterator<UserData> userdata = user.iterator();
				while(userdata.hasNext()) {
					UserData userd = userdata.next();
					if(userd.getUid().equals(userid) && userd.getUpass().equals(password)){
						System.out.println("Account holder Name : \t"+userd.getUname());
						System.out.println("Account holder ID : \t"+userd.getUid());
						System.out.println("Account ID : \t"+userd.getAccountid());
						System.out.println("Account Number : \t"+userd.getAccountNumber());
						System.out.println();
					}
				}
			break;
			case 2:
				System.out.print("Enter the amount you want to Withdraw");
				double  a= sc.nextDouble();
				if(a>0) {

					try {
						doller.dollarSign(a);
						balance.balanceamount(user.get(index).getBalance(), a);
						user.get(index).setBalance(user.get(index).getBalance()-a);
						System.out.println("sucessfully withdraw the amounet \n take the amount : \n thanks you \n have a nice day \n");
					} catch (NegativeDollarAmountException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}catch (InsufficientFundsException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
				break;
			case 3 :
				System.out.print("Enter the amount you want to diposit into account:");
				double  d= sc.nextDouble();

					try {
						doller.dollarSign(d);
						
						user.get(index).setBalance(user.get(index).getBalance()+d);
						System.out.println("sucessfully diposities sucessfully in the amounet ");
					} catch (NegativeDollarAmountException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				break;
			case 4:
				UserData userstate = user.get(index);
				System.out.println("Account holder Name : \t\t\t"+userstate.getUname());
				System.out.println("Account holder ID : \t\t\t"+userstate.getUid());
				System.out.println("Account ID : \t\t\t"+userstate.getAccountid());
				System.out.println("Account Number : \t\t\t"+userstate.getAccountNumber());
				System.out.println("Account  Balance left in the account  : \t"+userstate.getBalance());
				System.out.println();
				break;
			case 5:
				b= false;
				
				break;
			case 6 :
				System.out.print("Do you want to delete the account \n then press 'y' for YES and 'n' for NO \n    :-");
				char c = sc.next().charAt(0);
				if(c=='y') {
					
					Iterator<UserData> uu = user.iterator();
					while(uu.hasNext()) {
						UserData userd = uu.next();
						if(userd.getUid().equals(userId) && userd.getUpass().equals(pass)){
							uu.remove();
							b= false;
						}
					}
				}
				
				break;
			}
			
			
		}
		
	}

}
