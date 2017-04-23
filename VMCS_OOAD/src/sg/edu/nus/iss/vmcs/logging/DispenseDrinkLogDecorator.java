package sg.edu.nus.iss.vmcs.logging;

import java.util.Date;

import sg.edu.nus.iss.vmcs.customer.DispenseDrinkComponent;
import sg.edu.nus.iss.vmcs.customer.DispenseDrinkDecorator;

public class DispenseDrinkLogDecorator extends DispenseDrinkDecorator{
	
	LoggerController logCtrl;
	
	public DispenseDrinkLogDecorator(DispenseDrinkComponent drinkComponent){
		super(drinkComponent);
		logCtrl = new LoggerController();
	}
	
	@Override
	public boolean dispenseDrink(int selectedBrand) {
		super.dispenseDrink(selectedBrand);
		logCtrl.addDrinkDispensed(new Drinks(new Date(),selectedBrand));
        return true;
	}

}
