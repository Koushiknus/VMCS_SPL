package sg.edu.nus.iss.vmcs.logging;

import java.util.Date;

public class Transaction {
	
	private Date dateOfTransaction;
	private double amount;
	
	public Transaction(Date dateOfTransaction, double amount){
		this.dateOfTransaction = dateOfTransaction;
		this.amount = amount;				
	}
	
	public Date getDateOgTRansaction(){
		return dateOfTransaction;
	}
	
	public double getAmount(){
		return amount;
	}
	
	public void setDateOfTransaction(Date dateOfTransaction){
		this.dateOfTransaction = dateOfTransaction;
	}
	
	public void setAmount(double amount){
		this.amount = amount;
	}
}
