package banking;

import java.util.Iterator;
import java.util.Scanner;

public class EmployeeClass extends Data{
	Scanner sc = new Scanner(System.in);
	String empid,pass;
	int index =0;
	//registration function for the employee
	public void empRegistration()throws InvalidPasswordFormatException  {
		System.out.print("Enter name of the employee: ");
		String empname = sc.nextLine();
		System.out.print("Enter employee id: ");
		String empid = sc.nextLine();
		System.out.print("Enter the password:  ");
		String upass =sc.nextLine();
		if(upass.length()>8 && upass.contains("*")) {
			emp.add(new EmployeeData(empname,empid,upass));
			System.out.println("registration sucessfully");
		}
		else throw new InvalidPasswordFormatException();	
	}
	
	//login function for employee;
	public void empLogin() throws InvalidPasswordFormatException{
		System.out.print("Enter the empID: -");
		String empidl=sc.nextLine();
		System.out.print("Enter the employee password: -");
		String passl =sc.nextLine();
		if(passl.length()>8 && passl.contains("*")) {
			Iterator<EmployeeData> empdata = emp.iterator();
			index =0;
			while(empdata.hasNext()) {
				EmployeeData empd = empdata.next();
				if(empd.getEid().equals(empidl) && empd.getEpassword().equals(passl)){
					empid=empidl;
					pass = passl;
					empInterface();
					
				}
				index++;
			}
		}
		else throw new InvalidPasswordFormatException();
	}
	
	
	
	
	
	//interface of the employee form here
	public void empInterface() {
		
		System.out.println("\n\nwelcome Mr."+emp.get(index).getEname()+"\n");
		UserData data;
		int n;
		int count =0;
		boolean bb=true;
		while(bb) {
			System.out.println("1) my details\n2)list all the employees\n3)search by accoun Holder  name \n4) serach by account id\n5)search by account number\n6)block the user\n7) Log Out\n8) Delete Account ");
			System.out.print("Enter your chooise: - ");
			n =sc.nextInt();
			sc.nextLine();
			System.out.println("\n");
			switch(n) {
			case 1:
				System.out.println("Employuee Name : \t"+emp.get(index).getEname());
				System.out.println("Employee ID : \t"+emp.get(index).getEid());
				System.out.println();
				break;
			case 2:
				Iterator<UserData> userdata = user.iterator();
				while(userdata.hasNext()) {
					data = userdata.next();
					System.out.println(data);
				}
				
				break;
			case 3:
				System.out.print("Enter the account holder name:  ");
				String ahn = sc.nextLine();
				count =0 ;
				Iterator<UserData> userx = user.iterator();
				while(userx.hasNext()) {
					data=userx.next();
					if(data.getUname().equals(ahn)) {
						count++;
						System.out.println(data);
					}
				}
				if(count==0) {
					System.out.println("No Account Found");
				}
				
				break;
			
				
			case 4 :
				System.out.print("Enter the account holder id:  ");
				String ahid = sc.nextLine();
				count =0;
				Iterator<UserData> usern = user.iterator();
				while(usern.hasNext()) {
					data=usern.next();
					if(data.getUid().equals(ahid)) {
						System.out.println(data);
						count++;
					}
				}
				if(count==0) {
					System.out.println("No Account Found");
				}				
				break;
				
			case 5 :
				System.out.print("Enter the account Number:  ");
				double acnum = sc.nextDouble();
				count =0;
				Iterator<UserData> useri = user.iterator();
				while(useri.hasNext()) {
					data=useri.next();
					if(data.getAccountNumber()==acnum) {
						System.out.println(data);
						count++;
					}
				}
				if(count==0) {
					System.out.println("No Account Found");
				}
				
				break;
				
			case 6:
				System.out.println("Enter the account number and id to block or in hold state");
				System.out.print("Account Number : ");
				double anum = sc.nextDouble();
				sc.nextLine();
				System.out.print("Account Id : ");
				String aid = sc.nextLine();
				for(int i=0;i<user.size();i++) {
					if((user.get(i).getAccountNumber()==anum )&&(user.get(i).getUid().equals(aid))) {
						user.get(i).setBlock(true);
						System.out.println("\noperation performs sucessfully .......");
					}
				}
				break;
			case 7:
				bb=false;
				break;
			}
			
		}
	}
	
	
	
	
	

}
