package com.View;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;

import com.Bean.OpenAccount;
import com.Bean.WithdrawBean;
import com.Dao.CashOperationDao;

public class CashWithDrawView extends JPanel implements ActionListener{

	/**
	 * Create the panel.
	 */
	
	public JPanel CashDrew ;
	JTextField NameText;
	JTextField AcNotext;
	
	JTextField  BalText;
	JTextField WinthdrawAmountText;
	 JButton WithdrawBtn;
	 JButton getInfo;
	 private JTextField datetextField;
	 private JLabel datelabel;
	
	public CashWithDrawView() {
		setLayout(null);		
		CashDrew =new JPanel();
		
		CashDrew.setBackground(SystemColor.control);
		CashDrew.setBounds(10,10,836, 538);
		CashDrew.setLayout(null);
		
		  JLabel cashLabel = new JLabel("Cash WithDraw"); 
		  cashLabel.setFont(new Font("Tahoma", Font.PLAIN, 15)); 
		  cashLabel.setBounds(86, 33, 209, 27);
		  CashDrew.add(cashLabel);
		

			JPanel panel = new JPanel();
			panel.setBackground(SystemColor.inactiveCaption);
			panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			panel.setBounds(86, 80, 666, 365);
			CashDrew.add(panel);
			panel.setLayout(null);	
			
			  
			  JLabel ACLabel = new JLabel("Account No:"); 
			  ACLabel.setFont(new Font("Tahoma", Font.PLAIN, 16)); 
			  ACLabel.setBounds(18, 41, 103, 27);
			  panel.add(ACLabel);
			  
			  AcNotext = new JTextField(); 
			  AcNotext.setBounds(131, 43, 412, 27);
			  panel.add(AcNotext);
			  AcNotext.setColumns(10);
			  
			  LineBorder lineBorder =new LineBorder(Color.LIGHT_GRAY, 2, true);
			  
			  getInfo = new JButton("Get Info");
			  getInfo.setForeground(new Color(0, 0, 0));
			  getInfo.setFont(new Font("Tahoma", Font.PLAIN, 15));
			  getInfo.setBackground(new Color(255, 255, 255)); 
			  getInfo.setBounds(553, 43, 103, 27); 
			  getInfo.setBorder(lineBorder);
			  panel.add(getInfo);
			  getInfo.addActionListener(this);
			  
			  JPanel panel_1 = new JPanel();
			  panel_1.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
			  panel_1.setBounds(39, 128, 597, 199);
			  panel.add(panel_1);
			  panel_1.setLayout(null);
			  
			  JLabel nameLabel = new JLabel("Name");
			  nameLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
			  nameLabel.setBounds(10, 15, 64, 25);
			  panel_1.add(nameLabel);
			  
			  NameText = new JTextField();
			  NameText.setFont(new Font("Tahoma", Font.PLAIN, 15));
			  NameText.setBounds(68, 15, 222, 30);
			  panel_1.add(NameText);
			  NameText.setColumns(10);
		
			  
			  JLabel balanceLabel = new JLabel("Balance");
			  balanceLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
			  balanceLabel.setBounds(300, 15, 64, 25);
			  panel_1.add(balanceLabel);
			  
			  BalText = new JTextField();
			  BalText.setFont(new Font("Tahoma", Font.PLAIN, 15));
			  BalText.setColumns(10);
			  BalText.setBounds(365, 15, 222, 30);
			  panel_1.add(BalText);
			  
			  JLabel WIthDrawLabel = new JLabel("Withdraw Amount");
			  WIthDrawLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
			  WIthDrawLabel.setBounds(245, 106, 121, 25);
			  panel_1.add(WIthDrawLabel);
			  
			  
			  WinthdrawAmountText = new JTextField();
			  WinthdrawAmountText.setFont(new Font("Tahoma", Font.PLAIN, 15));
			  WinthdrawAmountText.setBounds(378, 104, 209, 30);
			  panel_1.add(WinthdrawAmountText);
			  WinthdrawAmountText.setColumns(10);
			  
			  WithdrawBtn = new JButton("Withdraw");
			  WithdrawBtn.setForeground(Color.BLACK);
			  WithdrawBtn.setFont(new Font("Tahoma", Font.PLAIN, 15));
			  WithdrawBtn.setBackground(Color.WHITE);
			  WithdrawBtn.setBounds(472, 151, 115, 27);
			  panel_1.add(WithdrawBtn);
			  
			  long millis=System.currentTimeMillis();  
			  java.sql.Date date=new java.sql.Date(millis);  
			  datetextField = new JTextField(date.toString());
			  datetextField.setFont(new Font("Tahoma", Font.PLAIN, 15));
			  datetextField.setColumns(10);
			  datetextField.setBounds(68, 104, 177, 30);
			  panel_1.add(datetextField);
			  
			  datelabel = new JLabel("Date");
			  datelabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
			  datelabel.setBounds(10, 106, 53, 25);
			  panel_1.add(datelabel);
			  panel.setVisible(true);
			  WithdrawBtn.addActionListener(this);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == getInfo) {
			OpenAccount obj =new OpenAccount();
			
			obj.setACno(Integer.parseInt(AcNotext.getText()));
			CashOperationDao.getInfo(obj);
			NameText.setText(obj.getName());
			BalText.setText(Integer.toString(obj.getAmount()));
			
			
		//	System.out.println(obj.getACno());
		}
		
		
		  if(e.getSource() == WithdrawBtn ) {
			  	OpenAccount obj =new OpenAccount();
			  	WithdrawBean withdraw = new WithdrawBean();
			  	withdraw.setAccNo(Integer.parseInt(AcNotext.getText()));
			  	withdraw.setBalance(Integer.parseInt(WinthdrawAmountText.getText()));
			  	withdraw.setDebitDate(datetextField.getText());
			  	withdraw.setDepositBalance(0);
			  	
			  	obj.setACno(Integer.parseInt(AcNotext.getText()));
			  	int bal  = Integer.parseInt(BalText.getText());
			  	int withdrawBal =Integer.parseInt(WinthdrawAmountText.getText());
			  	
			  	
			  	int subtract;
			  	if(withdrawBal <= bal) {
			  	subtract= bal-withdrawBal;
			  	obj.setAmount(subtract);
			  	
			  int status =	CashOperationDao.AddCashWithDraw(withdraw,obj);
			  if(status == 2) {
				  JOptionPane.showMessageDialog(this, "Transaction Complete");
			  }else {
				  JOptionPane.showMessageDialog(this, "Transaction Failed");
			  }
			  	
			  	}else
			  	{
			  		JOptionPane.showMessageDialog(this, "You doesn't have sufficent balance");
			  	}
			  
		  }
		 
		
	}

}
