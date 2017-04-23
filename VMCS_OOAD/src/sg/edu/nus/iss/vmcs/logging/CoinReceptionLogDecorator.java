package sg.edu.nus.iss.vmcs.logging;

import java.util.ArrayList;
import java.util.Date;

import sg.edu.nus.iss.vmcs.customer.CoinReceptionDecorator;
import sg.edu.nus.iss.vmcs.store.Coin;

public class CoinReceptionLogDecorator implements CoinReceptionDecorator {
	
	private LoggerController logCtrl;
	private ArrayList<Coin> arlCoins;
	
	public CoinReceptionLogDecorator(ArrayList<Coin> arlCoins){
		this.logCtrl = new LoggerController();
		this.arlCoins = arlCoins;
	}

	@Override
	public boolean storeCash() {
		double amount = 0;
		for(int i=0;i<arlCoins.size();i++){
			Coin coin=(Coin)arlCoins.get(i);
			amount += coin.getValue();
		}
		logCtrl.addTransaction(new Transaction(new Date(), amount));
		return true;
}
}
