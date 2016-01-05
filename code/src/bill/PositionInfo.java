package bill;

public class PositionInfo{
	public  String ID;//寄件单号
	public String form;//运输方式
	public String date;//入库日期
	public String destination;//目的地
	public String zoneID;//区号
	public String rowID;//排号
	public String frameID;//架号
	public String positionID;//位号
	
	public PositionInfo(String ID,String date,String destination){
		this.ID=ID;
		this.destination=destination;
		this.date=date;
	}
	
	void allocate(String zoneID,String rowID,String frameID,String positionID){
		this.zoneID=zoneID;
		this.rowID=rowID;
		this.frameID=frameID;
		this.positionID=positionID;
	}
}
