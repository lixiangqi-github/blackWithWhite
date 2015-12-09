package bl.shipment.Impl;

import data.shipment.PlaneShipment;
import po.bills.TransportBill_Plane;
import tools.MoneyHelper;

public class AirTransport {
	PlaneShipment planeInfo;
	public AirTransport(){
		planeInfo=new PlaneShipment();
	}
	public double submitBills(TransportBill_Plane planeBill) {
		// TODO Auto-generated method stub
		try {
			boolean success=planeInfo.insert(planeBill);
			if(!success)
				return -1;
			return MoneyHelper.getFreight(planeBill.list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}
	}
	
}
