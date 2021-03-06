package ui.staff;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import bill.DriverPO;
import bl.staff.Impl.DriverManageCotroller;
import bl.staff.Impl.StaffManageController;
import bl.staff.Impl.UserManageController;
import ui.NSwing.NTableModel;
import ui.NSwing.TimePanel;
import vo.StaffVO;

public class AddDriverPanel extends JPanel{
	JLabel driverid;
	JLabel name;
	JLabel sex;
	JLabel birthday;
	JLabel validDate;
	JLabel tel;
	JLabel IDNumbers;
	JTextField usertel;
	JTextField userid;
	JTextField userpass;
	JTextField username;
	JTextField userValidTime;
	JTextField userbirthday;
	JComboBox usersex;  
    JButton okButton;
    JTable table;
    JScrollPane scrollPane;
	public AddDriverPanel(){
		this.setLayout(null);
		this.setBounds(200, 60, 1000, 615);
		
		name=new JLabel();
		name.setFont(new Font("΢���ź�",Font.BOLD,16));
		name.setBounds(120,50,40,30);
		name.setText("����");
		
		username=new JTextField();
		username.setFont(new Font("΢���ź�",Font.BOLD,16));
		username.setBounds(210,50,80,30);
		
		sex=new JLabel();
		sex.setFont(new Font("΢���ź�",Font.BOLD,16));
		sex.setBounds(340,50,40,30);
		sex.setText("�Ա�");
		
		usersex=new JComboBox();
		usersex.setFont(new Font("΢���ź�",Font.BOLD,16));
		usersex.addItem("��");
		usersex.addItem("Ů");
		usersex.setBounds(410,50,60,30);
		
		birthday=new JLabel();
		birthday.setFont(new Font("΢���ź�",Font.BOLD,16));
		birthday.setBounds(540,50,80,30);
		birthday.setText("��������");
		
		userbirthday=new JTextField();
		userbirthday.setFont(new Font("΢���ź�",Font.BOLD,16));
		userbirthday.setBounds(630,50,200,30);
		userbirthday.addFocusListener(new AgeListener());
		
		tel=new JLabel();
		tel.setFont(new Font("΢���ź�",Font.BOLD,16));
		tel.setBounds(120,110,160,30);
		tel.setText("�ֻ�����");
		
		usertel=new JTextField();
		usertel.setFont(new Font("΢���ź�",Font.BOLD,16));
		usertel.setBounds(210,110,120,30);
		
		validDate=new JLabel();
		validDate.setFont(new Font("΢���ź�",Font.BOLD,16));
		validDate.setBounds(540,110,80,30);
		validDate.setText("��ʻ֤����");
		
		 
		userValidTime=new JTextField();
		userValidTime.setFont(new Font("΢���ź�",Font.BOLD,16));
		userValidTime.setBounds(630,110,200,30);
		
		driverid=new JLabel();
		driverid.setFont(new Font("΢���ź�",Font.BOLD,16));
		driverid.setBounds(120,170,80,30);
		driverid.setText("˾�����");
		
		userid=new JTextField();
		userid.setFont(new Font("΢���ź�",Font.BOLD,16));
		userid.setBounds(210,170,200,30);
		
		IDNumbers=new JLabel();
		IDNumbers.setFont(new Font("΢���ź�",Font.BOLD,16));
		IDNumbers.setBounds(540,170,80,30);
		IDNumbers.setText("����֤��");
		
		userpass=new JTextField();
		userpass.setFont(new Font("΢���ź�",Font.BOLD,16));
		userpass.setBounds(630,170,200,30);

		
		okButton=new JButton();
		okButton.setBounds(700, 210, 40, 40);
		okButton.addActionListener(new PushListener());
		
		DriverManageCotroller staff=new DriverManageCotroller();
		ArrayList<DriverPO> staffs=staff.getAllDriver("");		
		buildTable(staffs);	
		
		
		this.add(birthday);
		this.add(userbirthday);
		this.add(name);
		this.add(username);
		this.add(sex);
		this.add(usersex);
		this.add(validDate);
		this.add(driverid);
		this.add(userid);
		this.add(IDNumbers);
		this.add(userpass);
		this.add(tel);
		this.add(usertel);
		this.add(okButton);
		this.add(userValidTime);
	}
	
	public void buildTable(ArrayList<DriverPO> staffs){
		int size=staffs.size();
		Object[][] tableData=new Object[size][7];
		for(int i=0;i<size;i++){
			DriverPO mess=staffs.get(i);
			String sex="��";
			if(!mess.isBoy)
				sex="Ů";
			tableData[i]=new Object[]{mess.ID,mess.name,sex,mess.birthday,mess.tel,mess.validData,mess.IDNumber};
		}
		Object[] columnTitle = {"˾�����" ,"����","�Ա�","��������","�ֻ�����","��ʻ֤����","����֤��"};  
		
		TableModel tableModel=new DefaultTableModel(tableData,columnTitle);
		table=new JTable(tableModel);
		DefaultTableCellRenderer r=new DefaultTableCellRenderer();   
	  	r.setHorizontalAlignment(JLabel.CENTER); 
	  	table.setDefaultRenderer(Object.class,r);
		int height=table.getRowHeight()*(size+1)+9;
		int ValidMaxHeight=250;
		if(height>=300)
			height=ValidMaxHeight;
		table.setOpaque(false); 
		table.setRowSelectionAllowed(true);
		scrollPane = new JScrollPane();
		scrollPane.setBounds(120, 280, 700, height);
		scrollPane.setOpaque(false);
		this.add(scrollPane);
		scrollPane.setViewportView(table);
	}
	 class PushListener implements ActionListener{

		public void actionPerformed(ActionEvent arg0) {
			boolean isBoy=true;
			if(((String)usersex.getSelectedItem()).equals("��")){
				
			}else{
				isBoy=false;
			}
			DriverPO d=new DriverPO(userid.getText(),username.getText(),userpass.getText(),userbirthday.getText(),
					isBoy,usertel.getText(),userValidTime.getText());
			DriverManageCotroller staff=new DriverManageCotroller();
			ArrayList<DriverPO> a=new ArrayList<DriverPO>();
			a.add(d);
			boolean suceess=staff.addNewDiver(a);
			if(suceess){
				TimePanel.makeWords("���ӳɹ�");
			}else{
				TimePanel.makeWords("����ʧ��");
			}
			removeTable();
			ArrayList<DriverPO> staffs=staff.getAllDriver("");		
			buildTable(staffs);	
		}
		 
	 }
	 class AgeListener implements FocusListener{

		@Override
		public void focusGained(FocusEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void focusLost(FocusEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		 
	 }
		public void removeTable(){
			if(scrollPane!=null)
				this.remove(scrollPane);
		}
}
