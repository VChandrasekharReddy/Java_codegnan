package banking;

public class NegativeDollarAmountException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NegativeDollarAmountException( String msg) {
		super(msg);
	}
}
