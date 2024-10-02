package banking;

public class UserData {
	private String uname;
	private String uid;
	private String upass;
	private int accountid;
	private double accountNumber;
	private double balance;
	
	
	public UserData(String uname, String uid, String upass ) {
		this.uname = uname;
		this.uid = uid;
		this.setUpass(upass);
		accountNumber +=1;
		accountid +=1;
	}
	
	
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public int getAccountid() {
		return accountid;
	}
	public void setAccountid(int accountid) {
		this.accountid = accountid;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}


	public double getAccountNumber() {
		return accountNumber;
	}


	public void setAccountNumber(double accountNumber) {
		this.accountNumber = accountNumber;
	}


	public String getUpass() {
		return upass;
	}


	public void setUpass(String upass) {
		this.upass = upass;
	}

}
