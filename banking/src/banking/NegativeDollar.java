package banking;

public class NegativeDollar{
	public void dollarSign(double a)throws NegativeDollarAmountException {
		if(a<0) {
			throw new NegativeDollarAmountException("negative dollar amount is entered ");
		}
	}

}
