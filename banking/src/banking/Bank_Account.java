package banking;
public class Bank_Account {
	private String name;
	private int acctountid;
	private static int numberofacctounts=0;
	private String userid;
	private String userpassword;
	private double balance=0;
	Bank_Account(String name, String userid, String userpassword){
		numberofacctounts+=1;
		acctountid=numberofacctounts;
		this.setName(name);
		this.setUserid(userid);
		this.setUserpassword(userpassword);
	}
    //getter and setter for username
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
    
	
	//gettter and setter for the acctoutnid
	public int getAcctountid() {
		return acctountid;
	}

	public void setAcctountid(int acctountid) {
		this.acctountid = acctountid;
	}

	
	//getter and setter 
	public String getUserpassword() {
		return userpassword;
	}

	public void setUserpassword(String userpassword) {
		this.userpassword = userpassword;
	}

	
	
	//getter and setters for balance 
	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	
	//getter and setter for number of acctounts
	public static int getNumberofacctounts() {
		return numberofacctounts;
	}
	public static void setNumberofacctounts(int numberofacctounts) {
		Bank_Account.numberofacctounts = numberofacctounts;
	}
	
	
	
	//gettera and the setter for the userid
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	
	


}
