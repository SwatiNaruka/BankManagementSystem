package com.View;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.*;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;

import com.Bean.OpenAccount;
import com.Dao.AccountFormDao;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;

import javax.swing.SwingConstants;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import java.awt.SystemColor;



public class MainContentPage extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JLabel lblAccountManager;
	private JButton CashDepositbtn;
	private JButton closebtn;
	private JButton repportBtn;
	private JButton manageBtn;
	private JButton newAccBtn;
	private JButton aboutBtn;
	private JButton fetchAlldetail;
	JButton CashWithdrawBtn;
	private JLabel headlabel;
	private JPanel HomePanel;
	private JLabel lblNewLabel;
	private JPanel OpenAccPanel;
	private JLabel lblNewLabel_1;
	private JTextField nametext;
	private JLabel fathLabel;
	private JLabel genderlabel;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel birthdatelabel;
	private JLabel servicelabel;
	private JLabel openamountLabel;
	private JTextField fatherName;
	private JTextField amountText;
	JButton OpenAccBtn;
	JComboBox daycombobox,Monthcombobox_1, yearcombobox_2 ;
	//CashDeposit cd;
	
	JRadioButton malebtn,femaleBtn, otherBtn;
	
	ButtonGroup genderGroup;
	JRadioButton SingleBtn;
	
	JPanel AProject;
	JPanel cd;
	JPanel cw;
	JPanel ca;
	 JPanel ma;
	 JPanel FatchDetail;
	 JPanel GStmt;
	
	JRadioButton MariedBtn;
	JRadioButton savingAcc,currentAcc;
	JCheckBox Atmbox, NetBankBox, MobilebankBox, checkbookBox;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				  try { MainContentPage frame = new MainContentPage(); frame.setVisible(true);
				  } catch (Exception e) { e.printStackTrace(); }
				 
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainContentPage() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1199, 667);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//this panel is for all side button
		JPanel sidePanel = new JPanel();
		sidePanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		sidePanel.setBackground(new Color(240, 240, 240));
		sidePanel.setBounds(20, 21, 289, 587);
		contentPane.add(sidePanel);
		sidePanel.setLayout(null);
		
		LineBorder lineBorder =new LineBorder(Color.LIGHT_GRAY, 2, true);
		
		lblAccountManager = new JLabel("Account Manager");
		lblAccountManager.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAccountManager.setBounds(10, 0, 155, 33);
		sidePanel.add(lblAccountManager);
		
		
		
		
		CashDepositbtn = new JButton("Cash Deposit");
		CashDepositbtn.setForeground(Color.BLACK);
		CashDepositbtn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		CashDepositbtn.setBackground(Color.WHITE);
		CashDepositbtn.setBounds(10, 54, 269, 33);
		CashDepositbtn.setBorder(lineBorder);
		sidePanel.add(CashDepositbtn);
		CashDepositbtn.addActionListener(this);
		
		CashWithdrawBtn = new JButton("Cash Withdraw");
		CashWithdrawBtn.setBackground(Color.WHITE);
		CashWithdrawBtn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		CashWithdrawBtn.setBorder(lineBorder);
		CashWithdrawBtn.setForeground(new Color(0, 0, 0));
		CashWithdrawBtn.setBounds(10, 113, 269, 33);
		sidePanel.add(CashWithdrawBtn);
		CashWithdrawBtn.addActionListener(this);
		
		closebtn = new JButton("Close Account");
		closebtn.setForeground(Color.BLACK);
		closebtn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		closebtn.setBackground(Color.WHITE);
		closebtn.setBorder(lineBorder);
		closebtn.setBounds(10, 171, 269, 33);
		sidePanel.add(closebtn);
		closebtn.addActionListener(this);
		
		repportBtn = new JButton("Generate Statement");
		repportBtn.setForeground(Color.BLACK);
		repportBtn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		repportBtn.setBackground(Color.WHITE);
		repportBtn.setBounds(10, 230, 269, 33);
		repportBtn.setBorder(lineBorder);
		sidePanel.add(repportBtn);
		repportBtn.addActionListener(this);
		
		manageBtn = new JButton("Manage Existing Account");
		manageBtn.setForeground(Color.BLACK);
		manageBtn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		manageBtn.setBackground(Color.WHITE);
		manageBtn.setBounds(10, 342, 269, 33);
		manageBtn.setBorder(lineBorder);
		sidePanel.add(manageBtn);
		manageBtn.addActionListener(this);
		
		newAccBtn = new JButton("Open New Account");
		newAccBtn.setForeground(Color.BLACK);
		newAccBtn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		newAccBtn.setBackground(Color.WHITE);
		newAccBtn.setBounds(10, 287, 269, 33);
		newAccBtn.setBorder(lineBorder);
		sidePanel.add(newAccBtn);
		newAccBtn.addActionListener(this);
		

		fetchAlldetail=new JButton("Fetch All Account Details");
		fetchAlldetail.setForeground(Color.BLACK);
		fetchAlldetail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		fetchAlldetail.setBackground(Color.WHITE);
		fetchAlldetail.setBounds(10, 396, 269, 33);
		fetchAlldetail.setBorder(lineBorder);
		sidePanel.add(fetchAlldetail);
		fetchAlldetail.addActionListener(this);
		
		aboutBtn = new JButton("About Project");
		aboutBtn.setForeground(Color.BLACK);
		aboutBtn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		aboutBtn.setBackground(Color.WHITE);
		aboutBtn.setBounds(10, 450, 269, 33);
		aboutBtn.setBorder(lineBorder);
		sidePanel.add(aboutBtn);
		aboutBtn.addActionListener(this);
		
		
		
		headlabel = new JLabel("Bank Management System");
		headlabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		headlabel.setBounds(316, 13, 328, 33);
		contentPane.add(headlabel);
		
		
		HomePanel = new JPanel();
		HomePanel.setBackground(SystemColor.inactiveCaption);
		HomePanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		HomePanel.setBounds(319, 53, 856, 558);
		contentPane.add(HomePanel);
		HomePanel.setLayout(null);
		HomePanel.setVisible(true);
		
		
		
		//importing the panel
		 CashDepositView Cd =new CashDepositView();//class of second panel 
          cd =Cd.deposit;// accessing the panel of that class
         HomePanel.add(cd);	             
         cd.setVisible(false);
		
		CashWithDrawView Cw=new CashWithDrawView();
		 cw =Cw.CashDrew;
		HomePanel.add(cw);
		cw.setVisible(false);
		
		CloseAccount ac =new CloseAccount();
		 ca =ac.closeAc;
		 HomePanel.add(ca);
		 ca.setVisible(false);
		 
		 ManageAcocunt Ma= new ManageAcocunt();
		 ma = Ma.ManageAcc;
		 HomePanel.add(ma);
		 ma.setVisible(false);
		
		FatchAllDetail ft =new FatchAllDetail();
		FatchDetail =ft.FatchDetail;
		HomePanel.add(FatchDetail);
		FatchDetail.setVisible(false);
		
		AboutProject op =new AboutProject();
		AProject = op.AboutProject;
		HomePanel.add(AProject);
		AProject.setVisible(false);
		
		GanerateStatement gs =new GanerateStatement();
		 GStmt  = gs.GanerateStatement;
		 HomePanel.add(GStmt);
		 GStmt.setVisible(false);
		
		//this panel of for open account panel
		OpenAccPanel = new JPanel();
		OpenAccPanel.setBounds(10, 10, 836, 538);
		HomePanel.add(OpenAccPanel);
		OpenAccPanel.setLayout(null);
		OpenAccPanel.setVisible(false);
		
		
		
		lblNewLabel_1 = new JLabel("Name :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(22, 23, 126, 25);
		OpenAccPanel.add(lblNewLabel_1);
		
		nametext = new JTextField();
		nametext.setFont(new Font("Tahoma", Font.PLAIN, 15));
		nametext.setBounds(176, 10, 599, 32);
		OpenAccPanel.add(nametext);
		nametext.setColumns(10);
		
		fathLabel = new JLabel("Father Name:");
		fathLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		fathLabel.setBounds(22, 79, 126, 25);
		OpenAccPanel.add(fathLabel);
		
		genderlabel = new JLabel("Gender:");
		genderlabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		genderlabel.setBounds(22, 142, 126, 25);
		OpenAccPanel.add(genderlabel);
		
		lblNewLabel_2 = new JLabel("Merital Status:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(22, 205, 126, 25);
		OpenAccPanel.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Type of Account:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(22, 266, 126, 25);
		OpenAccPanel.add(lblNewLabel_3);
		
		birthdatelabel = new JLabel("Date of Birth:");
		birthdatelabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		birthdatelabel.setBounds(22, 323, 126, 25);
		OpenAccPanel.add(birthdatelabel);
		
		servicelabel = new JLabel("Service Required:");
		servicelabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		servicelabel.setBounds(22, 382, 126, 25);
		OpenAccPanel.add(servicelabel);
		
		openamountLabel = new JLabel("Opening Amount:");
		openamountLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		openamountLabel.setBounds(22, 445, 126, 25);
		OpenAccPanel.add(openamountLabel);
		
		fatherName = new JTextField();
		fatherName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		fatherName.setColumns(10);
		fatherName.setBounds(176, 72, 599, 32);
		OpenAccPanel.add(fatherName);
		
		 malebtn = new JRadioButton("Male");
		malebtn.setFont(new Font("Tahoma", Font.PLAIN, 17));
		malebtn.setBounds(176, 143, 103, 21);
		OpenAccPanel.add(malebtn);
		//malebtn.setBorder(lineBorder);
		
		 femaleBtn = new JRadioButton("Female");
		femaleBtn.setFont(new Font("Tahoma", Font.PLAIN, 17));
		femaleBtn.setBounds(297, 143, 103, 21);
		OpenAccPanel.add(femaleBtn);
		
		 otherBtn = new JRadioButton("Other");
		otherBtn.setFont(new Font("Tahoma", Font.PLAIN, 17));
		otherBtn.setBounds(431, 143, 103, 21);
		OpenAccPanel.add(otherBtn);
		
		genderGroup =new ButtonGroup();//for select only 1 button from gender
		genderGroup.add(malebtn);
		genderGroup.add(femaleBtn);
		genderGroup.add(otherBtn);
		
	/* JPanel jp =new JPanel(); jp.add(genderGroup); HomePanel.add(jp);
	 */
		 MariedBtn = new JRadioButton("Married");
		MariedBtn.setFont(new Font("Tahoma", Font.PLAIN, 17));
		MariedBtn.setBounds(176, 204, 103, 25);
		OpenAccPanel.add(MariedBtn);
		
		SingleBtn = new JRadioButton("Single");
		SingleBtn.setFont(new Font("Tahoma", Font.PLAIN, 17));
		SingleBtn.setBounds(297, 204, 103, 25);
		OpenAccPanel.add(SingleBtn);
		
		ButtonGroup StatusGroup =new ButtonGroup();//for selection only 1 button form single or maried status
		StatusGroup.add(MariedBtn);
		StatusGroup.add(SingleBtn);
		
		
		savingAcc = new JRadioButton("Saving");
		savingAcc.setFont(new Font("Tahoma", Font.PLAIN, 17));
		savingAcc.setBounds(176, 266, 119, 25);
		OpenAccPanel.add(savingAcc);
		
		currentAcc = new JRadioButton("Current Account");
		currentAcc.setFont(new Font("Tahoma", Font.PLAIN, 17));
		currentAcc.setBounds(297, 267, 160, 25);
		OpenAccPanel.add(currentAcc);
		
		ButtonGroup ACType =new ButtonGroup();//for selection only 1 button for account type
		ACType.add(savingAcc);
		ACType.add(currentAcc);
		
		 Atmbox = new JCheckBox("ATM Card");
		Atmbox.setFont(new Font("Tahoma", Font.PLAIN, 17));
		Atmbox.setBounds(176, 375, 119, 32);
		OpenAccPanel.add(Atmbox);
		
		 NetBankBox = new JCheckBox("Net Banking");
		NetBankBox.setFont(new Font("Tahoma", Font.PLAIN, 17));
		NetBankBox.setBounds(292, 377, 119, 32);
		OpenAccPanel.add(NetBankBox);
		
		 MobilebankBox = new JCheckBox("Mobile Banking");
		MobilebankBox.setFont(new Font("Tahoma", Font.PLAIN, 17));
		MobilebankBox.setBounds(431, 377, 139, 32);
		OpenAccPanel.add(MobilebankBox);
		
		checkbookBox = new JCheckBox("Cheque Book");
		checkbookBox.setFont(new Font("Tahoma", Font.PLAIN, 17));
		checkbookBox.setBounds(597, 377, 139, 32);
		OpenAccPanel.add(checkbookBox);
		
		ButtonGroup Service =new ButtonGroup();//for selection only 1 button for service required
		Service.add(Atmbox);
		Service.add(NetBankBox);
		Service.add(MobilebankBox);
		Service.add(checkbookBox);
		
		
		amountText = new JTextField();
		amountText.setFont(new Font("Tahoma", Font.PLAIN, 15));
		amountText.setBounds(176, 438, 599, 32);
		OpenAccPanel.add(amountText);
		amountText.setColumns(10);
		
		OpenAccBtn = new JButton("Create Account");
		OpenAccBtn.addActionListener(this);
			
		OpenAccBtn.setForeground(Color.BLACK);
		OpenAccBtn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		OpenAccBtn.setBackground(Color.WHITE);
		OpenAccBtn.setBounds(678, 495, 148, 33);
		OpenAccBtn.setBorder(lineBorder);
		OpenAccPanel.add(OpenAccBtn);
		
		
		Calendar cal=Calendar.getInstance();
		System.out.println(cal.getTime());
		//System.out.println(cal.getTime());
				
		String day[]= {"01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
		
		daycombobox = new JComboBox(day);
		daycombobox.setEditable(true);
		daycombobox.setBounds(375, 323, 80, 25);
		//daycombobox.setd
		//daycombobox.addItem(cal);
		OpenAccPanel.add(daycombobox);
		
	
		
		String month[]= {"01","02","03","04","05","06","07","08","09","10","11","12"};
		Monthcombobox_1 = new JComboBox(month);
		/*
		 * for(int i =1 ; i <= 12; i++ ) { Monthcombobox_1.addItem(i); }
		 */
		Monthcombobox_1.setEditable(true);
		Monthcombobox_1.setBounds(280, 323, 80, 25);
		OpenAccPanel.add(Monthcombobox_1);
		
		
	//	String year[]= {"1990","1991","1992","1993","1994","1995","1996","1997","1998","1999","2000","2001","2002","2003","2004","2005","2006","2007","2008","2009","2010","2011","2012","2013","2014","2015","2016","2017","2018","2019","2020","2021",};
		
		
		 yearcombobox_2 = new JComboBox();
		 for(int i =1940; i<= LocalDateTime.now().getYear(); i++) {
			 yearcombobox_2.addItem(i);
		 }
		 
		yearcombobox_2.setEditable(true);
		yearcombobox_2.setBounds(185, 323, 80, 25);
		OpenAccPanel.add(yearcombobox_2);
		
		JLabel dateFormatelabel = new JLabel("Use YYYY-mm-dd");
		dateFormatelabel.setForeground(Color.GRAY);
		dateFormatelabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		dateFormatelabel.setBounds(480, 323, 148, 21);
		OpenAccPanel.add(dateFormatelabel);
		
	}

	@Override
	
	public void actionPerformed(ActionEvent e) {
		
		
		if(e.getSource()==CashDepositbtn) {
			OpenAccPanel.setVisible(false);
				cw.setVisible(false);
	            cd.setVisible(true);
	            ca.setVisible(false);
	            ma.setVisible(false);
	            FatchDetail.setVisible(false);
	            AProject.setVisible(false);
	            GStmt.setVisible(false);
		}
		
		if(e.getSource() == CashWithdrawBtn) {
			OpenAccPanel.setVisible(false);
			cd.setVisible(false);
			cw.setVisible(true);
			 ca.setVisible(false);
			 ma.setVisible(false);
			 FatchDetail.setVisible(false);
			 AProject.setVisible(false);
			 GStmt.setVisible(false);
            
		}
		
		
		if(e.getSource() == newAccBtn) {
			 ca.setVisible(false);
			cw.setVisible(false);
            cd.setVisible(false);
            OpenAccPanel.setVisible(true);
            ma.setVisible(false);
            FatchDetail.setVisible(false);
            AProject.setVisible(false);
            GStmt.setVisible(false);
		}
		
		//manageBtn
		if(e.getSource() == manageBtn) {
			 ca.setVisible(false);
				cw.setVisible(false);
	            cd.setVisible(false);
	            OpenAccPanel.setVisible(false);
	            ma.setVisible(true);
	            FatchDetail.setVisible(false);
	            AProject.setVisible(false);
	            GStmt.setVisible(false);
		}
		
		
		if(e.getSource() == closebtn) {
			
			cw.setVisible(false);
            cd.setVisible(false);
            OpenAccPanel.setVisible(false);
            ma.setVisible(false);
            ca.setVisible(true);
            FatchDetail.setVisible(false);
            AProject.setVisible(false);
            GStmt.setVisible(false);
		}
		if(e.getSource() == fetchAlldetail) {
			cw.setVisible(false);
            cd.setVisible(false);
            OpenAccPanel.setVisible(false);
            ma.setVisible(false);
            ca.setVisible(false);
            FatchDetail.setVisible(true);
            AProject.setVisible(false);
            GStmt.setVisible(false);
		}
		
		if(e.getSource() ==aboutBtn) {
			cw.setVisible(false);
            cd.setVisible(false);
            OpenAccPanel.setVisible(false);
            ma.setVisible(false);
            ca.setVisible(false);
            FatchDetail.setVisible(false);
            AProject.setVisible(true);
            GStmt.setVisible(false);
            
		}
		
		if(e.getSource() == repportBtn) {
			
			cw.setVisible(false);
            cd.setVisible(false);
            OpenAccPanel.setVisible(false);
            ma.setVisible(false);
            ca.setVisible(false);
            FatchDetail.setVisible(false);
            AProject.setVisible(false);
			 GStmt.setVisible(true);
		}
		
		if(e.getSource() == malebtn) {
			//maleBTn(femaleBtn otherBtn//malebtn
			System.out.println("male");
		}
		
		if(e.getSource() ==OpenAccBtn) {
			
			OpenAccount op=new OpenAccount();
			//set account no
			Random rm =new Random();
			int x =rm.nextInt(10001);
			op.setACno(x);
			
			op.setName(nametext.getText());
			op.setFatherName(fatherName.getText());
			
			//selection of gender
			if(malebtn.isSelected()) {
				op.setGender(malebtn.getText());
				//JOptionPane.showMessageDialog(this,malebtn.getText());
			}else if (femaleBtn.isSelected()) {
				op.setGender(femaleBtn.getText());
			}else if(otherBtn.isSelected()){
				op.setGender(otherBtn.getText());
				
			}
			
		
			
			//for marital status selection			
			if(MariedBtn.isSelected()) {
				op.setMeritalStatus(MariedBtn.getText());
				//System.out.println(MariedBtn.getText());
			}else if(SingleBtn.isSelected()) {
				op.setMeritalStatus(SingleBtn.getText());
			}
			
			//for type of ac selection
			if(savingAcc.isSelected()) {
				op.setTypeOfAc(savingAcc.getText());
			}else if(currentAcc.isSelected()) {
				op.setTypeOfAc(currentAcc.getText());
			}
			
			
			//for selection and service required//////////////////////////////////////
			if(Atmbox.isSelected()) {
				op.setServiseRequired(Atmbox.getText());
			}else if(NetBankBox.isSelected()) {
				op.setServiseRequired(NetBankBox.getText());
			}else if(MobilebankBox.isSelected()) {
				op.setServiseRequired(MobilebankBox.getText());
			}else if(checkbookBox.isSelected()) {
				op.setServiseRequired(checkbookBox.getText());
			}
			
			////set Opening amount
			op.setAmount(Integer.parseInt(amountText.getText()));
			//System.out.println(op.getAmount());
		
		///for geting combobox value
		
			Object day =daycombobox.getSelectedItem();
			Object month =	Monthcombobox_1.getSelectedItem();
			Object year =yearcombobox_2.getSelectedItem();
			
		   day=daycombobox.getSelectedItem();		   
		   month=Monthcombobox_1.getSelectedItem(); 
		   year=yearcombobox_2.getSelectedItem();
		 
		  // System.out.println("days =" +day+ "month =" +month+ "year =" +year);
		   String dob =(year+"-"+month+"-"+day); 
		   op.setDOB(dob);
		  // String d = (year+"-"+month+"-"+day);
			/*
			 * System.out.println( op.getDOB()); System.out.println("ac no "+op.getACno());
			 * System.out.println("name" +op.getName()); System.out.println("father name "
			 * +op.getFatherName()); System.out.println("gender " +op.getGender());
			 * System.out.println("merital status  " +op.getMeritalStatus());
			 * System.out.println("type of acc " +op.getTypeOfAc()); System.out.println(
			 * "date of birth " +op.getDOB()); System.out.println("service required "
			 * +op.getServiseRequired()); System.out.println("opening balance"
			 * +op.getAmount());
			 */
		   
		   int status =	AccountFormDao.submitFormData(op);
		   if(status != 0) {
			   	JOptionPane.showMessageDialog( this, "Account Created by" +op.getACno());
		   }else {
			   JOptionPane.showMessageDialog(this, "Data submition failed");
		   }
		}
	}

}
