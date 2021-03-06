package staffdata;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import Dataservice.FileHelper;
import bill.TruckPO;

import data.staff.BusInfoHelper;
import database.Database_BusInfo;

public class BusInfoImpl extends UnicastRemoteObject implements BusInfoHelper {
	public static Database_BusInfo database;
	public static boolean ready=false;
	public static String dir="ser/BusInfo.ser";
	
	protected BusInfoImpl() throws FileNotFoundException, ClassNotFoundException, IOException {
		super();
		if(!ready){
			ready=true;
			database=(Database_BusInfo) FileHelper.read(dir);
		}
	}

	public static void save() throws FileNotFoundException, IOException{
		FileHelper.write(dir, database);
	}
	
	@Override
	public void ping() throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public synchronized boolean insert(TruckPO po) throws RemoteException {
		// TODO Auto-generated method stub
		boolean bool=database.add(po);
		try {
			save();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bool;
	}

	@Override
	public synchronized boolean change(TruckPO po) throws RemoteException {
		// TODO Auto-generated method stub
		boolean bool=database.change(po);
		try {
			save();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bool;
	}

	@Override
	public synchronized boolean delete(String id) throws RemoteException {
		// TODO Auto-generated method stub
		boolean bool=database.delete(id);
		try {
			save();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bool;
	}

	@Override
	public TruckPO get(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return database.get(id);
	}

	@Override
	public boolean init() throws RemoteException {
		// TODO Auto-generated method stub
		database=new Database_BusInfo();
		return true;
	}

	@Override
	public ArrayList<TruckPO> getAll() throws RemoteException {
		// TODO Auto-generated method stub
		return database.getAll();
	}

	
}
