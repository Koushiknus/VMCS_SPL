package sg.edu.nus.iss.vmcs.logging;

import java.util.Date;

public class Drinks {
	
	private Date dateOfTransaction;
	private int drinkName;
	
	public Drinks(Date dateOfTransaction, int drinkName){
		this.dateOfTransaction = dateOfTransaction;
		this.drinkName = drinkName;				
	}
	
	public Date getDateOgTRansaction(){
		return dateOfTransaction;
	}
	
	public int getDrinkName(){
		return drinkName;
	}
	
	public void setDateOfTransaction(Date dateOfTransaction){
		this.dateOfTransaction = dateOfTransaction;
	}
	
	public void setAmount(int drinkName){
		this.drinkName = drinkName;
	}

}
