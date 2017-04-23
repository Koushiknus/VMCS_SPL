package sg.edu.nus.iss.vmcs.customer;

import java.util.ArrayList;

public interface CoinReceptionComponent {
	
	public ArrayList<CoinReceptionDecorator> decoratorsList = new ArrayList<CoinReceptionDecorator>();
	public boolean storeCash();

}
