package sg.edu.nus.iss.vmcs.customer;

public class CoinReceptionDecorator implements CoinReceptionComponent {
	
	private CoinReceptionComponent coinComponent;
    public CoinReceptionDecorator(CoinReceptionComponent coinComponent) {
        this.coinComponent = coinComponent;
    }

    public boolean storeCash() {
        return coinComponent.storeCash();
    }
    
    public int getTotalInserted() {
        return coinComponent.getTotalInserted();
    }
	

}
