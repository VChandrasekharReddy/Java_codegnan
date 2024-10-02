package banking;

public class Checking_Account  extends Bank_Account {
	private double withdrawlimit=300;

	Checking_Account(String name, String userid, String userpassword) {
		super(name, userid, userpassword);
		// TODO Auto-generated constructor stub
	}

	//getter and setter for username
		public String getName() {
			return super.getName();
		}
		public void setName(String name) {
			super.setName(name);
		}
	    
		
		//gettter and setter for the acctoutnid
		public int getAcctountid() {
			return super.getAcctountid();
		}

		public void setAcctountid(int acctountid) {
			super.setAcctountid(acctountid);
		}

		
		//getter and setter 
		public String getUserpassword() {
			return super.getUserpassword();
		}

		public void setUserpassword(String userpassword) {
			super.setUserpassword(userpassword);
		}

		
		
		//getter and setters for balance 
		public double getBalance() {
			return super.getBalance();
		}

		public void setBalance(double balance) {
			super.setBalance(balance);
		}
		
		
		//getter and setter for number of acctounts
		public static int getNumberofacctounts() {
			return getNumberofacctounts();
		}
		public static void setNumberofacctounts(int numberofacctounts) {
			setNumberofacctounts(numberofacctounts);
		}
		
		
		
		//gettera and the setter for the userid
		public String getUserid() {
			return super.getUserid();
		}
		public void setUserid(String userid) {
			super.setUserid(userid);
		}
		
	
	
	//getter and the setters for the withdrawl limit of an acctount
	public double getWithdrawlimit() {
		return withdrawlimit;
	}

	public void setWithdrawlimit(double withdrawlimit) {
		this.withdrawlimit = withdrawlimit;
	}

}
