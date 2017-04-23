package sg.edu.nus.iss.vmcs.customer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import sg.edu.nus.iss.vmcs.store.CashStoreItem;
import sg.edu.nus.iss.vmcs.store.Coin;
import sg.edu.nus.iss.vmcs.store.Store;
import sg.edu.nus.iss.vmcs.store.StoreController;
import sg.edu.nus.iss.vmcs.store.StoreItem;
import sg.edu.nus.iss.vmcs.system.MainController;
import sg.edu.nus.iss.vmcs.util.VMCSException;

public class ChangeLargerDenominationFirst implements ChangeGiver{
	
	private TransactionController txCtrl;

	public ChangeLargerDenominationFirst(TransactionController txCtrl) {
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
	
	public boolean giveChange(int changeRequired){
		if(changeRequired==0)
			return true;
		try{
			int changeBal=changeRequired;
			MainController mainCtrl=txCtrl.getMainController();
			StoreController storeCtrl=mainCtrl.getStoreController();
			int cashStoreSize=storeCtrl.getStoreSize(Store.CASH);
			
			//sort
			ArrayList<Coin> allSortedCoins = new ArrayList<Coin>();
			HashMap<Coin, Integer> coinsQty = new HashMap<Coin, Integer>();
			for(int i=cashStoreSize-1;i>=0;i--){
				StoreItem cashStoreItem=storeCtrl.getStore(Store.CASH).getStoreItem(i);
				int quantity=cashStoreItem.getQuantity();
				Coin coin=(Coin)cashStoreItem.getContent();
				allSortedCoins.add(coin);
				coinsQty.put(coin, quantity);
			}
			
			Collections.sort(allSortedCoins, new Coin());
			
			for(int i=0; i<allSortedCoins.size();i++){
				Coin coin = allSortedCoins.get(i);
				int quantity=coinsQty.get(coin);
				int value=coin.getValue();
				int quantityRequired = 0;
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
