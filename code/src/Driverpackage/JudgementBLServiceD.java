package Driverpackage;

/*
 * JudgementBLService������
 */
import bl.blservice.JudgementBLService;



public class JudgementBLServiceD  {
/*
 * judgementbl�Ĺ��ӿ�
 */

		public void drive(JudgementBLService judgementBLService){
			ResultMessage result1 = judgementBLService.checkRecord(0000000001);
			if(result1==ResultMessage.Exist) System.out.println("Record exists\n");
			ResultMessage result2 = judgementBLService.updateRecord(0000000001);
			if(result2==ResultMessage.Exist) System.out.println("Recordupdate exists\n");
			ResultMessage result3 = judgementBLService.submitRecord(0000000001);
			if(result3==ResultMessage.Exist) System.out.println("Recordsubmit exists\n");
		}

	}

public class Client{
		public static void main(String[] args){
			JudgementBLService judgementController = new JudgementController();
			JudgementBLServiceD driver = new JudgementBLServiceD(judgementController);
			driver.drive(judgementController);
		}
	}
