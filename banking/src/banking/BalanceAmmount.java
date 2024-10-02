package banking;

public class BalanceAmmount {
	public void balanceamount(double aa,double ua) throws InsufficientFundsException{
		if(aa<ua) {
			throw new InsufficientFundsException();
		}
	}
}
