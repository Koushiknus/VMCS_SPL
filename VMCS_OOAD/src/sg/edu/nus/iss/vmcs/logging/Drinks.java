package sg.edu.nus.iss.vmcs.logging;

import java.util.Date;

public class Drinks {
	
	private Date dateOfTransaction;
	private String drinkName;
	
	public Drinks(Date dateOfTransaction, String drinkName){
		this.dateOfTransaction = dateOfTransaction;
		this.drinkName = drinkName;				
	}
	
	public Date getDateOgTRansaction(){
		return dateOfTransaction;
	}
	
	public String getDrinkName(){
		return drinkName;
	}
	
	public void setDateOfTransaction(Date dateOfTransaction){
		this.dateOfTransaction = dateOfTransaction;
	}
	
	public void setAmount(String drinkName){
		this.drinkName = drinkName;
	}

}
