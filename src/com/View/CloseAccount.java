package com.View;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;

import com.Bean.OpenAccount;
import com.Dao.AccountFormDao;
import com.Dao.CashOperationDao;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CloseAccount extends JPanel implements ActionListener{

	public JPanel closeAc;
	JTextField AcNotext;
	JTextField NameText;
	JTextField BalText;
	
	JButton getInfo;
	JButton closeAcc;
	public CloseAccount() {
		setLayout(null);
		closeAc =new JPanel();
		
		closeAc.setBackground(SystemColor.control);
		closeAc.setBounds(10,10,836,538);
		 closeAc.setLayout(null);
		
		 JLabel CloseAcLabel = new JLabel("Close Account"); 
		 CloseAcLabel.setBounds(311, 10, 209, 27);
		 CloseAcLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		  closeAc.add(CloseAcLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(91, 109, 666, 315);
		panel.setBackground(SystemColor.inactiveCaption);
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		closeAc.add(panel);	
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
		  panel_1.setBounds(39, 128, 597, 138);
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
		
		  
		  	closeAcc= new JButton("Close ACcount");
		  closeAcc.setForeground(Color.BLACK);
		  closeAcc.setFont(new Font("Tahoma", Font.PLAIN, 15));
		  closeAcc.setBackground(Color.WHITE);
		  closeAcc.setBounds(251, 75, 139, 27);
		  panel_1.add(closeAcc);
		  panel.setVisible(true);
		  closeAcc.addActionListener(this);

		
		
		

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource()==  getInfo) {
			OpenAccount obj =new OpenAccount();
			obj.setACno( Integer.parseInt(AcNotext.getText()));
			CashOperationDao.getInfo(obj);
			
			NameText.setText(obj.getName());
			BalText.setText(Integer.toString(obj.getAmount()));
		}
		
		if( e.getSource()== closeAcc) {
			OpenAccount obj =new OpenAccount();
			obj.setACno(Integer.parseInt(AcNotext.getText()));
			
			int status = AccountFormDao.DeleteAccount(obj);
			if(status != 0) {
				JOptionPane.showMessageDialog(this, "Account Deleted sucessfully");
			}else {
				JOptionPane.showMessageDialog(this, "Account Deletion failed");
			}
		}
		
	}

}
