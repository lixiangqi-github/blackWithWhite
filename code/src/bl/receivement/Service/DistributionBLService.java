package bl.receivement.Service;

import po.bills.AllocateBill;
import po.bills.ArrivementBill;
import po.bills.ArrivementBill_Shop;

/**
 * 接收与派件
 * @author 倪辰皓
 *
 */
public interface DistributionBLService {

	/**
	 * 接收
	 * @param arrive 营业厅到达单
	 * @return
	 */
	public boolean receive(ArrivementBill_Shop arrive);
	
	/**
	 * 派件
	 * @param time 时间
	 * @param deliveryMan 快递员
	 * @param ID  IDs
	 * @return
	 */
	public boolean distribution(AllocateBill[] bills);
}
