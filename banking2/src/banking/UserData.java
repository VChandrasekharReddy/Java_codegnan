package banking;

public class UserData implements Comparable<UserData> {
	private String uname;
	private String uid;
	private String upass;
	private int accountid;
	private double accountNumber;
	private double balance;
	private boolean block;
	
	
	public UserData(String uname, String uid, String upass ,double size) {
		this.uname = uname;
		this.uid = uid;
		this.setUpass(upass);
		accountNumber=size;
		accountid= (int)size ;
		setBlock(false);
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


	@Override
	public int compareTo(UserData o) {
		// TODO Auto-generated method stub
		return this.accountid-o.accountid;
	}


	public boolean isBlock() {
		return block;
	}


	public void setBlock(boolean block) {
		this.block = block;
	}

	   @Override
	    public String toString() {
	        return "User Name : " +uname+ "User ID : "+uid+" Account Number : "+accountNumber+"Account ID : " +accountid+" Account Balance "+ balance+" Status Blocked : "+block; 
	    }
}
