package com.View;

import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;

import com.Bean.DepositBean;
import com.Bean.OpenAccount;
import com.Dao.CashOperationDao;

import javax.swing.border.CompoundBorder;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.border.BevelBorder;

public class CashDepositView extends JPanel implements ActionListener{

	/**
	 * Create the panel.
	 */
	public JPanel deposit;
	private JTextField AcNotext;
	private JTextField NameText;
	private JTextField BalText;
	private JTextField DepositAmountText;

	 JButton getInfo,DepositBtn;
	 private JTextField dateTextField;
	 
	public CashDepositView() {
		setLayout(null);		
		deposit =new JPanel();
		
		deposit.setBackground(SystemColor.control);
		deposit.setBounds(10,10,836, 538);
		deposit.setLayout(null);
		
		  JLabel cashLabel = new JLabel("Cash Deposit"); 
		  cashLabel.setFont(new Font("Tahoma", Font.PLAIN, 15)); 
		  cashLabel.setBounds(86, 33, 209, 27);
		  deposit.add(cashLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.inactiveCaption);
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(86, 80, 666, 397);
		deposit.add(panel);
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
		  
		  JLabel DepoBalLabel = new JLabel("Deposit Amount");
		  DepoBalLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		  DepoBalLabel.setBounds(248, 91, 116, 25);
		  panel_1.add(DepoBalLabel);
		  
		  DepositAmountText = new JTextField();
		  DepositAmountText.setFont(new Font("Tahoma", Font.PLAIN, 15));
		  DepositAmountText.setBounds(365, 89, 222, 30);
		  panel_1.add(DepositAmountText);
		  DepositAmountText.setColumns(10);
		  
		  DepositBtn = new JButton("Deposit");
		  DepositBtn.setForeground(Color.BLACK);
		  DepositBtn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		  DepositBtn.setBackground(Color.WHITE);
		  DepositBtn.setBounds(497, 145, 90, 27);
		  panel_1.add(DepositBtn);
		  
		  JLabel dateLavel = new JLabel("Date");
		  dateLavel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		  dateLavel.setBounds(10, 91, 44, 25);
		  panel_1.add(dateLavel);
		  
		  dateTextField = new JTextField();
		  long millis=System.currentTimeMillis();  
		  java.sql.Date date=new java.sql.Date(millis);  
		  dateTextField.setText(date.toString());
		  dateTextField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		  dateTextField.setBounds(56, 91, 182, 26);
		  panel_1.add(dateTextField);
		  dateTextField.setColumns(10);
		  panel.setVisible(true);
		  DepositBtn.addActionListener(this);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==getInfo) {
		
		OpenAccount obj =new OpenAccount();
		obj.setACno(Integer.parseInt(AcNotext.getText()));
		
		CashOperationDao.getInfo(obj);
		NameText.setText(obj.getName());
		//String sst = obj.getAmount();
		BalText.setText(Integer.toString(obj.getAmount()));
		
		}
		
		if(e.getSource()== DepositBtn) {
			OpenAccount obj =new OpenAccount();
			DepositBean deposit=new DepositBean();
			
			deposit.setAccno(Integer.parseInt(AcNotext.getText()));
			deposit.setDate(dateTextField.getText());
			deposit.setBalance(Integer.parseInt(DepositAmountText.getText()));
			
			deposit.setWithdrawBalance(0);
			int bal =Integer.parseInt( BalText.getText());
			int depositbal =Integer.parseInt(DepositAmountText.getText());
			int sum = bal+depositbal;
			obj.setAmount(sum);
			
			obj.setACno(Integer.parseInt(AcNotext.getText()));
			int status = CashOperationDao.AddCashDeposit(deposit,obj);
			//CashOperationDao.AddCashDeposit(deposit, obj)
											
			if(status == 2) {
				JOptionPane.showMessageDialog(this, "Transaction Complete");
			}else {
				JOptionPane.showMessageDialog(this, "Transaction failed");
			}
			
			
		}
		
	}
}
