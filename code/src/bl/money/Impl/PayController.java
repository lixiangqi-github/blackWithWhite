package bl.money.Impl;

import java.util.ArrayList;

import bill.PaymentBill;
import bl.money.Service.PayBLService;

public class PayController implements PayBLService {
	Pay pay;
	public PayController(){
		pay=new Pay();
	}
	@Override
	public boolean addPaymentBill(PaymentBill[] bills) {
		// TODO Auto-generated method stub
		return pay.addPaymentBill(bills);
	}
	@Override
	public ArrayList<PaymentBill> getPaymentBill(String[] start, String[] end) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ArrayList<PaymentBill> getPaymentBill(String[] endTime) {
		// TODO Auto-generated method stub
		return null;
	}

}