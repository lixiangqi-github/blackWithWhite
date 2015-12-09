package bl.money.Impl;

import java.util.ArrayList;

import bl.money.Service.PaidBLService;
import po.bills.ReceiveMoneyBill;

public class PaidController implements PaidBLService {
	Paid paid;
	public PaidController(){
		paid=new Paid();
	} 
	@Override
	public boolean addPaidmentBill(ReceiveMoneyBill[] bills) {
		// TODO Auto-generated method stub
		return paid.addPaidmentBill(bills);
	}

	@Override
	public ArrayList<ReceiveMoneyBill> getPaidmentBill(String[] start, String[] end) {
		// TODO Auto-generated method stub
		return paid.getPaidmentBill(start, end);
	}
	@Override
	public ArrayList<ReceiveMoneyBill> getPaidmentBill(String[] endTime) {
		// TODO Auto-generated method stub
		return paid.getPaidmentBill(endTime);
	}
	@Override
	public ArrayList<ReceiveMoneyBill> getUnmarkingBills() {
		// TODO Auto-generated method stub
		return paid.getUnmarkingBills();
	}

}
