package sg.edu.nus.iss.vmcs.logging;

import java.util.ArrayList;

public class AuditTrail {
	
	private ArrayList<Transaction> transactionList = new ArrayList<Transaction>();
	private ArrayList<Drinks> drinksDispensed = new ArrayList<Drinks>();
	
	public void addTransaction(Transaction transaction){
		transactionList.add(transaction);
	}
	
	public void addDrinks(Drinks drink){
		drinksDispensed.add(drink);
	}

}
