package sg.edu.nus.iss.vmcs.customer;

import java.util.ArrayList;

public interface DispenseDrinkComponent {
	
	public ArrayList<DispenseDrinkDecorator> decoratorsList = new ArrayList<DispenseDrinkDecorator>();
	public boolean dispenseDrink(int selectedBrand);

}
