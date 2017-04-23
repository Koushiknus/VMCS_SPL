package sg.edu.nus.iss.vmcs.customer;

public class DispenseDrinkDecorator implements DispenseDrinkComponent{
	
	private DispenseDrinkComponent drinkComponent;
    public DispenseDrinkDecorator(DispenseDrinkComponent drinkComponent) {
        this.drinkComponent = drinkComponent;
    }

    public boolean dispenseDrink(int selectedBrand){
        return drinkComponent.dispenseDrink(selectedBrand);
    }

}
