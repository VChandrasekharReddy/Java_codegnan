package banking;

public class UserAccount {
	public void getuser(boolean b) throws CustomerAccountNotFoundException{
		if(!b) {
			throw new CustomerAccountNotFoundException();
		}
	}

}
