package sg.edu.nus.iss.vmcs.logging;

import java.util.Date;

import sg.edu.nus.iss.vmcs.customer.DispenseDrinkDecorator;
import sg.edu.nus.iss.vmcs.store.DrinksBrand;
import sg.edu.nus.iss.vmcs.store.Store;
import sg.edu.nus.iss.vmcs.store.StoreController;
import sg.edu.nus.iss.vmcs.store.StoreItem;
import sg.edu.nus.iss.vmcs.store.StoreObject;

public class DispenseDrinkLogDecorator implements DispenseDrinkDecorator{
	
	private LoggerController logCtrl;
	private StoreController storeCtrl;
	
	public DispenseDrinkLogDecorator(StoreController storeCtrl){
		this.logCtrl = new LoggerController();
		this.storeCtrl = storeCtrl;
	}

	@Override
	public boolean dispenseDrink(int selectedBrand) {
		StoreItem drinkStoreItem=storeCtrl.getStore(Store.DRINK).getStoreItem(selectedBrand);
		StoreObject storeObject=drinkStoreItem.getContent();
		DrinksBrand drinksBrand=(DrinksBrand)storeObject;
		String drinksName=drinksBrand.getName();
		logCtrl.addDrinkDispensed(new Drinks(new Date(),drinksName));
		return false;
	}

}
