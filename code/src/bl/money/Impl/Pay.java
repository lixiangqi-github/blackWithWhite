package bl.money.Impl;

import java.util.ArrayList;

import bill.PaymentBill;
import data.money.PayBill;

/**
 * ��д������������
 * @author �߳��
 *
 */
public class Pay {
	PayBill pay;
	
	public Pay(){
		pay=new PayBill();
	}
	public boolean addPaymentBill(PaymentBill[] bills) {
		if(bills==null)
			return false;
		try {
			for(int i=0;i<bills.length;i++){
				pay.insert(bills[i]);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("�������ʧ��");
			return false;
		}
		return true;
	}

	public ArrayList<PaymentBill> getPaymentBill(String[] start, String[] end) {
		ArrayList<PaymentBill> paymentBill;
		try {
			paymentBill=pay.getall(start,end);		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("��ȡ���ʧ��");
			return null;
		}
		return paymentBill;
	}
	
	public ArrayList<PaymentBill> getPaymentBill(String[] time) {
		ArrayList<PaymentBill> paymentBill;
		try {
			paymentBill=pay.getall(time);	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("��ȡ���ʧ��");
			return null;
		}
		return paymentBill;
	}
}