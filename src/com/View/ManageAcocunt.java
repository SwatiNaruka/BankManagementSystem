package com.View;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;

import com.Bean.OpenAccount;
import com.Dao.CashOperationDao;
import com.Dao.ManageAccountDao;

public class ManageAcocunt extends JPanel implements ActionListener {

	/**
	 * Create the panel.
	 */
	JPanel ManageAcc;
	JTextField AcNotext;
	JButton getInfo;
	private JTextField nameField;

	JCheckBox Atmbox;
	JCheckBox NetBankBox;
	JCheckBox checkbookBox;
	JCheckBox MobilebankBox;

	JLabel lblNewLabel_1, fathLabel, openamountLabel, servicelabel, birthdatelabel, lblNewLabel_3, genderlabel,
			lblNewLabel_2;
	JTextField nametext, fatherName, amountText;
	JRadioButton otherBtn, malebtn, femaleBtn, MariedBtn, SingleBtn, savingAcc, currentAcc;
	ButtonGroup genderGroup;
	JButton modifyBtn;
	private JTextField dateTextField;

	public ManageAcocunt() {
		setLayout(null);
		ManageAcc = new JPanel();

		ManageAcc.setBackground(SystemColor.control);
		ManageAcc.setBounds(10, 10, 836, 537);
		ManageAcc.setLayout(null);

		JPanel panel = new JPanel();
		// panel.setBackground(SystemColor.inactiveCaption);
		// panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(27, 10, 785, 517);
		ManageAcc.add(panel);
		panel.setLayout(null);

		JLabel ACLabel = new JLabel("Account No:");
		ACLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		ACLabel.setBounds(34, 8, 103, 27);
		panel.add(ACLabel);

		AcNotext = new JTextField();
		AcNotext.setBounds(169, 10, 483, 27);
		panel.add(AcNotext);
		AcNotext.setColumns(10);

		LineBorder lineBorder = new LineBorder(Color.LIGHT_GRAY, 2, true);

		getInfo = new JButton("Get Info");
		getInfo.setForeground(new Color(0, 0, 0));
		getInfo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		getInfo.setBackground(new Color(255, 255, 255));
		getInfo.setBounds(661, 10, 103, 27);
		getInfo.setBorder(lineBorder);
		panel.add(getInfo);
		getInfo.addActionListener(this);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		panel_1.setBounds(10, 59, 765, 448);// 10, 10, 836, 538)
		panel.add(panel_1);
		panel_1.setLayout(null);

		lblNewLabel_1 = new JLabel("Name :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(22, 13, 90, 25);
		panel_1.add(lblNewLabel_1);

		nametext = new JTextField();
		nametext.setFont(new Font("Tahoma", Font.PLAIN, 15));
		nametext.setBounds(111, 10, 235, 32);
		panel_1.add(nametext);
		nametext.setColumns(10);

		fathLabel = new JLabel("Father Name:");
		fathLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		fathLabel.setBounds(356, 13, 113, 25);
		panel_1.add(fathLabel);

		genderlabel = new JLabel("Gender:");
		genderlabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		genderlabel.setBounds(22, 74, 126, 25);
		panel_1.add(genderlabel);

		lblNewLabel_2 = new JLabel("Merital Status:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(22, 134, 126, 25);
		panel_1.add(lblNewLabel_2);

		lblNewLabel_3 = new JLabel("Type of Account:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(22, 192, 126, 25);
		panel_1.add(lblNewLabel_3);

		birthdatelabel = new JLabel("Date of Birth:");
		birthdatelabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		birthdatelabel.setBounds(22, 254, 126, 25);
		panel_1.add(birthdatelabel);

		servicelabel = new JLabel("Service Required:");
		servicelabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		servicelabel.setBounds(22, 314, 126, 25);
		panel_1.add(servicelabel);

		openamountLabel = new JLabel("Opening Amount:");
		openamountLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		openamountLabel.setBounds(22, 366, 126, 25);
		panel_1.add(openamountLabel);

		fatherName = new JTextField();
		fatherName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		fatherName.setColumns(10);
		fatherName.setBounds(479, 10, 266, 32);
		panel_1.add(fatherName);

		malebtn = new JRadioButton("Male ");
		malebtn.setFont(new Font("Tahoma", Font.PLAIN, 17));
		malebtn.setBounds(168, 75, 103, 21);
		panel_1.add(malebtn);
		// malebtn.setBorder(lineBorder);

		femaleBtn = new JRadioButton("Female");
		femaleBtn.setFont(new Font("Tahoma", Font.PLAIN, 17));
		femaleBtn.setBounds(297, 75, 103, 21);
		panel_1.add(femaleBtn);

		otherBtn = new JRadioButton("Other");
		otherBtn.setFont(new Font("Tahoma", Font.PLAIN, 17));
		otherBtn.setBounds(423, 75, 103, 21);
		panel_1.add(otherBtn);

		genderGroup = new ButtonGroup();// for select only 1 button from gender
		genderGroup.add(malebtn);
		genderGroup.add(femaleBtn);
		genderGroup.add(otherBtn);

		// OpenAccPanel.
		// OpenAccPanel
		/*
		 * JPanel jp =new JPanel(); jp.add(genderGroup); HomePanel.add(jp);
		 */
		MariedBtn = new JRadioButton("Married");
		MariedBtn.setFont(new Font("Tahoma", Font.PLAIN, 17));
		MariedBtn.setBounds(168, 133, 103, 25);
		panel_1.add(MariedBtn);

		SingleBtn = new JRadioButton("Single");
		SingleBtn.setFont(new Font("Tahoma", Font.PLAIN, 17));
		SingleBtn.setBounds(297, 133, 103, 25);
		panel_1.add(SingleBtn);

		ButtonGroup StatusGroup = new ButtonGroup();// for selection only 1 button form single or maried status
		StatusGroup.add(MariedBtn);
		StatusGroup.add(SingleBtn);

		savingAcc = new JRadioButton("Saving");
		savingAcc.setFont(new Font("Tahoma", Font.PLAIN, 17));
		savingAcc.setBounds(168, 191, 119, 25);
		panel_1.add(savingAcc);

		currentAcc = new JRadioButton("Current Account");
		currentAcc.setFont(new Font("Tahoma", Font.PLAIN, 17));
		currentAcc.setBounds(298, 191, 160, 25);
		panel_1.add(currentAcc);

		ButtonGroup ACType = new ButtonGroup();// for selection only 1 button for account type
		ACType.add(savingAcc);
		ACType.add(currentAcc);

		Atmbox = new JCheckBox("ATM Card");
		Atmbox.setFont(new Font("Tahoma", Font.PLAIN, 17));
		Atmbox.setBounds(168, 309, 103, 32);
		panel_1.add(Atmbox);

		NetBankBox = new JCheckBox("Net Banking");
		NetBankBox.setFont(new Font("Tahoma", Font.PLAIN, 17));
		NetBankBox.setBounds(281, 309, 119, 32);
		panel_1.add(NetBankBox);

		MobilebankBox = new JCheckBox("Mobile Banking");
		MobilebankBox.setFont(new Font("Tahoma", Font.PLAIN, 17));
		MobilebankBox.setBounds(402, 309, 139, 32);
		panel_1.add(MobilebankBox);

		checkbookBox = new JCheckBox("Cheque Book");
		checkbookBox.setFont(new Font("Tahoma", Font.PLAIN, 17));
		checkbookBox.setBounds(555, 309, 139, 32);
		panel_1.add(checkbookBox);

		ButtonGroup Service = new ButtonGroup();// for selection only 1 button for service required
		Service.add(Atmbox);
		Service.add(NetBankBox);
		Service.add(MobilebankBox);
		Service.add(checkbookBox);

		amountText = new JTextField();
		amountText.setFont(new Font("Tahoma", Font.PLAIN, 15));
		amountText.setBounds(158, 363, 557, 32);
		panel_1.add(amountText);
		amountText.setColumns(10);

		modifyBtn = new JButton("Modify");
		modifyBtn.addActionListener(this);

		modifyBtn.setForeground(Color.BLACK);
		modifyBtn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		modifyBtn.setBackground(Color.WHITE);
		modifyBtn.setBounds(602, 405, 113, 33);
		modifyBtn.setBorder(lineBorder);
		panel_1.add(modifyBtn);
		
		dateTextField = new JTextField();
		dateTextField.setBounds(168, 254, 191, 24);
		panel_1.add(dateTextField);
		dateTextField.setColumns(10);

		Calendar cal = Calendar.getInstance();
		System.out.println(cal.getTime());
		// System.out.println(cal.getTime());

		String day[] = { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16",
				"17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" };

		String month[] = { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" };

		String year[] = { "1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000",
				"2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013",
				"2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", };

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == getInfo) {
			OpenAccount ap = new OpenAccount();
			ap.setACno(Integer.parseInt(AcNotext.getText()));
			ManageAccountDao.getDetail(ap);

			nametext.setText(ap.getName());
			fatherName.setText(ap.getFatherName());

			String gender = ap.getGender();
			if (gender.equals("Male")) {
				malebtn.setSelected(true);
			} else if (gender.equals("Female")) {
				femaleBtn.setSelected(true);
			} else if (gender.equals("Other")) {
				otherBtn.setSelected(true);
			}

			// married status set Jradio button
			System.out.println(ap.getMeritalStatus());
			if (ap.getMeritalStatus().equals("Married")) {
				MariedBtn.setSelected(true);
			} else if (ap.getMeritalStatus().equals("Single")) {
				SingleBtn.setSelected(true);
			}

			/// set type of account Radio
			System.out.println(ap.getTypeOfAc());
			if (ap.getTypeOfAc().equals("Saving")) {
				savingAcc.setSelected(true);
			} else if (ap.getTypeOfAc().equals("Current Account")) {
				currentAcc.setSelected(true);
			}

			System.out.println(ap.getServiseRequired());
			/// set type of service required
			if (ap.getServiseRequired().equals("ATM Card")) {
				Atmbox.setSelected(true);
			} else if (ap.getServiseRequired().equals("Net Banking")) {
				NetBankBox.setSelected(true);
			} else if (ap.getServiseRequired().equals("Mobile Banking")) {
				MobilebankBox.setSelected(true);
			} else if (ap.getServiseRequired().equals("Cheque Book")) {
				checkbookBox.setSelected(true);
			}

			// Set date of Birth

			System.out.println(ap.getDOB());
			dateTextField.setText(ap.getDOB());
			
			// String date = ap.getDOB();
			/* * char[] date = ap.getDOB().toCharArray(); int length =date.length; char day []
			 * =new char[(length+1)/4]; char month[] =new char[(length-day.length)];
			 * for(int i =0 ; i<length;i++) { if(i < day.length) { day[i] =date[i]; }else {
			 * month[i-day.length] =date[i]; } daycombobox.setSelectedItem(date[i]); }
			 * for(int i= 0; i<day.length; i++) { System.out.println(day[i]); } for(int i
			 * =0; i<month.length; i++) { System.out.println("month "+month[i]); }
			 */
			amountText.setText(Integer.toString(ap.getAmount()));

		}
		
		if(e.getSource() ==  modifyBtn) {
			OpenAccount obj =new OpenAccount();
			obj.setACno(Integer.parseInt(AcNotext.getText()));
			obj.setName(nametext.getText());
			obj.setFatherName(fatherName.getText());
			//obj.setGender();
			obj.setDOB(dateTextField.getText());
			obj.setAmount(Integer.parseInt(amountText.getText()));
			
			//selection of gender
			if(malebtn.isSelected()) {
				obj.setGender(malebtn.getText());
				//JOptionPane.showMessageDialog(this,malebtn.getText());
			}else if (femaleBtn.isSelected()) {
				obj.setGender(femaleBtn.getText());
			}else if(otherBtn.isSelected()){
				obj.setGender(otherBtn.getText());
				
			}
			
			//for marital status selection			
			if(MariedBtn.isSelected()) {
				obj.setMeritalStatus(MariedBtn.getText());
				//System.out.println(MariedBtn.getText());
			}else if(SingleBtn.isSelected()) {
				obj.setMeritalStatus(SingleBtn.getText());
			}
			//for type of ac selection
			if(savingAcc.isSelected()) {
				obj.setTypeOfAc(savingAcc.getText());
			}else if(currentAcc.isSelected()) {
				obj.setTypeOfAc(currentAcc.getText());
			}
			
			//for selection and service required//////////////////////////////////////
			if(Atmbox.isSelected()) {
				obj.setServiseRequired(Atmbox.getText());
			}else if(NetBankBox.isSelected()) {
				obj.setServiseRequired(NetBankBox.getText());
			}else if(MobilebankBox.isSelected()) {
				obj.setServiseRequired(MobilebankBox.getText());
			}else if(checkbookBox.isSelected()) {
				obj.setServiseRequired(checkbookBox.getText());
			}
			
						
			
			
			/*
			 * System.out.println(obj.getName()); System.out.println(obj.getFatherName());
			 * System.out.println(obj.getGender());
			 * System.out.println(obj.getMeritalStatus());
			 * System.out.println(obj.getTypeOfAc());
			 * System.out.println(obj.getServiseRequired());
			 * System.out.println(obj.getDOB()); System.out.println(obj.getAmount());
			 */
			
			int status = ManageAccountDao.ModifyData(obj);
			if(status  >= 0) {
				JOptionPane.showMessageDialog(this, "Changes updated");
			}else {
				JOptionPane.showMessageDialog(this, "Updation failed");
			}
		}
	}
}
