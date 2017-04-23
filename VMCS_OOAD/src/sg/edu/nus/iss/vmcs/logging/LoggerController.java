package sg.edu.nus.iss.vmcs.logging;

public class LoggerController {
	
	AuditTrail audit;
	
	public LoggerController(){
		audit = new AuditTrail();
	}
	
	public void addTransaction(Transaction transaction){
		audit.addTransaction(transaction);
	}
	
	public void addDrinkDispensed(Drinks drink){
		audit.addDrinks(drink);
	}

}
