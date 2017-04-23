package sg.edu.nus.iss.vmcs.customer;

import sg.edu.nus.iss.vmcs.store.CashStoreItem;
import sg.edu.nus.iss.vmcs.store.Coin;
import sg.edu.nus.iss.vmcs.store.Store;
import sg.edu.nus.iss.vmcs.store.StoreController;
import sg.edu.nus.iss.vmcs.store.StoreItem;
import sg.edu.nus.iss.vmcs.system.MainController;
import sg.edu.nus.iss.vmcs.util.VMCSException;

public class ChangeBalancedDenomination implements ChangeGiver {
	
	private TransactionController txCtrl; 

	/**
	 * The constructor creates an instance of the object.
	 * @param txCtrl the TransactionController
	 */
	public ChangeBalancedDenomination(TransactionController txCtrl){
		this.txCtrl = txCtrl;
	}
	
	/**
	 * This method is used to reset the Refund/ Change Tray display on the
	 * Customer Panel.
	 */
	public void resetChange(){
		CustomerPanel custPanel=txCtrl.getCustomerPanel();
		if(custPanel!=null){
			custPanel.resetChange();
		}
	}
	
	/**
	 * This method manages the issuing of change to the Customer.
	 * @param changeRequired
	 * @return return TRUE if give change use case success, otherwise, return FALSE.
	 */
	public boolean giveChange(int changeRequired){
		if(changeRequired==0)
			return true;
		try{
			int changeBal=changeRequired;
			MainController mainCtrl=txCtrl.getMainController();
			StoreController storeCtrl=mainCtrl.getStoreController();
			int cashStoreSize=storeCtrl.getStoreSize(Store.CASH); 
			for(int i=cashStoreSize-1;i>=0;i--){
				StoreItem cashStoreItem=storeCtrl.getStore(Store.CASH).getStoreItem(i);
				int quantity=cashStoreItem.getQuantity();
				Coin coin=(Coin)cashStoreItem.getContent();
				int value=coin.getValue();
				int quantityRequired=0;
				while(changeBal>0&&changeBal>=value&&quantity>0){
					changeBal-=value;
					quantityRequired++;
					quantity--;
				}
				txCtrl.getMainController().getMachineryController().giveChange(i,quantityRequired);
			}
			txCtrl.getCustomerPanel().setChange(changeRequired-changeBal);
			if(changeBal>0)
				txCtrl.getCustomerPanel().displayChangeStatus(true);
		}
		catch(VMCSException ex){
			txCtrl.terminateFault();
			return false;
		}
		return true;
	}
	
	public void displayChangeStatus(){
		CustomerPanel custPanel=txCtrl.getCustomerPanel();
		if(custPanel==null)
			return;
		boolean isAnyDenoEmpty=false;
		MainController mainCtrl=txCtrl.getMainController();
		StoreController storeCtrl=mainCtrl.getStoreController();
		StoreItem[] cashStoreItems=storeCtrl.getStore(Store.CASH).getItems();
		for(int i=0;i<cashStoreItems.length;i++){
			StoreItem storeItem=cashStoreItems[i];
			CashStoreItem cashStoreItem=(CashStoreItem)storeItem;
			int quantity=cashStoreItem.getQuantity();
			if(quantity==0)
				isAnyDenoEmpty=true;
		}
		custPanel.displayChangeStatus(isAnyDenoEmpty);
	}

}
