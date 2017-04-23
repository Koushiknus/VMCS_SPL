package sg.edu.nus.iss.vmcs.logging;

import java.util.Date;

import sg.edu.nus.iss.vmcs.customer.CoinReceptionComponent;
import sg.edu.nus.iss.vmcs.customer.CoinReceptionDecorator;

public class CoinReceptionLogDecorator extends CoinReceptionDecorator {
	
	LoggerController logCtrl;
	public CoinReceptionLogDecorator(CoinReceptionComponent coinComponent){
		super(coinComponent);
		logCtrl = new LoggerController();
	}

	@Override
	public boolean storeCash() {
		return super.storeCash();
	}
	
	@Override
	public int getTotalInserted() {
		int total = super.getTotalInserted();
		logCtrl.addTransaction(new Transaction(new Date(), total));
        return total;
	}
}
