package sg.edu.nus.iss.vmcs.customer;

public interface ChangeGiver {
	
	public static final int LargerDenominationFirst = 1;
	public static final int BalancedDenominations = 2;
	
	public void resetChange();
	public boolean giveChange(int changeRequired);
	public void displayChangeStatus();

}
