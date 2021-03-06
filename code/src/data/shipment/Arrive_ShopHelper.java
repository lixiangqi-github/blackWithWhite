package data.shipment;

import java.rmi.RemoteException;
import java.util.ArrayList;

import bill.ArrivementBill_Shop;
import remoteInterface.Client_Helper;

public interface Arrive_ShopHelper extends Client_Helper {
	public boolean insert(ArrivementBill_Shop bill) throws RemoteException;
	
	public boolean delete(String id) throws RemoteException;
	
	public boolean change(ArrivementBill_Shop bill) throws RemoteException;
	
	public ArrivementBill_Shop get(String id) throws RemoteException;
	
	public boolean init() throws RemoteException;
	
	public ArrayList<ArrivementBill_Shop> getUnjudged() throws RemoteException;
}
