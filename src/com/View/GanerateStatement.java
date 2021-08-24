package com.View;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
/*import javax.swing.text.Document;*/
import javax.swing.table.TableModel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import com.Bean.OpenAccount;
import com.Bean.StatementBean;
import com.Bean.WithdrawBean;
import com.Dao.StatementDao;
import com.Dao.TableDataDao;
import com.Files.ExcelClass;
import com.Files.PdfClass;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.*;


import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;
import java.util.List;

/*import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;*/

public class GanerateStatement extends JPanel  implements ActionListener{

	/**
	 * Create the panel.
	 */
	JPanel GanerateStatement ;
	private JTable Datatable;
	JComboBox AccBox , Monthcombobox_1 , yearcombobox_2,daycombobox, endYearcombobox, EndMonthcombobox, endDaycombobox;
	 JButton SearchBtn;
	 DefaultTableModel model;
	 private JButton GmailBtn,pfdBtn,ExcelBtn;
	 Object head [];
	 Object row[];
	 
	public GanerateStatement() {
		setLayout(null);
		
		GanerateStatement = new JPanel();
		
		GanerateStatement.setBackground(SystemColor.control);
		GanerateStatement.setBounds(10,10,836, 538);
		GanerateStatement.setLayout(null);
		
		JPanel Innerpanel = new JPanel();
		Innerpanel.setBackground(SystemColor.inactiveCaption);
		Innerpanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		Innerpanel.setBounds(47, 41, 750, 438);
		GanerateStatement.add(Innerpanel);
		Innerpanel.setLayout(null);		
		  
		  JLabel ACLabel = new JLabel("Account No:"); 
		  ACLabel.setFont(new Font("Tahoma", Font.PLAIN, 16)); 
		  ACLabel.setBounds(23, 30, 103, 27);
		  Innerpanel.add(ACLabel);
	
		 
		  AccBox = new JComboBox();
		  AccBox.setEditable(true);
		  AccBox.setMaximumRowCount(7);
		  AccBox.setForeground(new Color(0, 0, 0));
		  AccBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		  AccBox.setBackground(Color.WHITE);
		  AccBox.setBounds(314, 30, 247, 27);
		  List<OpenAccount> list = StatementDao.getAccountNumber();
		  for(OpenAccount x : list){
			   AccBox.addItem(x.getACno());
		  }
		 
		  Innerpanel.add(AccBox);
		  
		  Datatable = new JTable();
		  Datatable.setFont(new Font("Tahoma", Font.PLAIN, 13));
		  
		  model =new DefaultTableModel();
		   head =new Object[] {"Transaction Date" ,"Transction Id ", "Deposit Amount", "Withdraw Amount","Account Balance"};
		   row =new Object[] {};
		  model.setColumnIdentifiers(head);
		  model.addRow(row);
		  Datatable.setModel(model);
		  
		  JScrollPane sp= new JScrollPane(Datatable);
		  sp.setFont(new Font("Tahoma", Font.PLAIN, 13));
		  sp.setBounds(10,177, 738, 253);
		  Innerpanel.add(sp);
		  
		  JLabel dateLabel = new JLabel("Transction Date From(YYYY-MM-DD)");
		  dateLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		  dateLabel.setBounds(23, 84, 263, 21);
		  Innerpanel.add(dateLabel);
		  
		  JLabel dateLabel2 = new JLabel("Transction Date To(YYYY-MM-DD)");
		  dateLabel2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		  dateLabel2.setBounds(23, 134, 247, 21);
		  Innerpanel.add(dateLabel2);
		  
		  
		  
		  LineBorder lineBorder =new LineBorder(Color.LIGHT_GRAY, 2, true);

		  SearchBtn = new JButton("Search");
		  SearchBtn.setBackground(Color.WHITE);
		  SearchBtn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		  SearchBtn.setBounds(628, 131, 93, 27);
		  SearchBtn.setBorder(lineBorder);
		  Innerpanel.add(SearchBtn);
		  SearchBtn.addActionListener(this);
		  
		  
		  String day[]= {"01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
			
			daycombobox = new JComboBox(day);
			daycombobox.setEditable(true);
			daycombobox.setBounds(498, 84, 67, 25);
			
			Innerpanel.add(daycombobox);
			
		
			
			String month[]= {"01","02","03","04","05","06","07","08","09","10","11","12"};
			Monthcombobox_1 = new JComboBox(month);
			
			Monthcombobox_1.setEditable(true);
			Monthcombobox_1.setBounds(408, 84, 80, 25);
			Innerpanel.add(Monthcombobox_1);
			
			 yearcombobox_2 = new JComboBox();
			 for(int i =2015; i<= LocalDateTime.now().getYear(); i++) {
				 yearcombobox_2.addItem(i);
			 }
			 
			yearcombobox_2.setEditable(true);
			yearcombobox_2.setBounds(314, 84, 67, 25);
			Innerpanel.add(yearcombobox_2);
			
		  //second end date
			
			  String endDay[]= {"01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
				
				endDaycombobox = new JComboBox(endDay);
				endDaycombobox.setEditable(true);
				endDaycombobox.setBounds(498, 134, 67, 25);
				
				Innerpanel.add(endDaycombobox);
				
			
				
				String EndMonth[]= {"01","02","03","04","05","06","07","08","09","10","11","12"};
				EndMonthcombobox = new JComboBox(month);
				
				EndMonthcombobox.setEditable(true);
				EndMonthcombobox.setBounds(408, 134, 80, 25);
				Innerpanel.add(EndMonthcombobox);
				
				 endYearcombobox = new JComboBox();
				 for(int i =2015; i<= LocalDateTime.now().getYear(); i++) {
					 endYearcombobox.addItem(i);
				 }
				 
				 endYearcombobox.setEditable(true);
				 endYearcombobox.setBounds(314, 134, 80, 25);
				Innerpanel.add(endYearcombobox);
				
				pfdBtn = new JButton("Generate PDF");
				pfdBtn.setFont(new Font("Tahoma", Font.PLAIN, 15));
				pfdBtn.setBackground(Color.WHITE);
				pfdBtn.setBounds(655, 494, 142, 27);
				GanerateStatement.add(pfdBtn);
				pfdBtn.addActionListener(this);
				
				 ExcelBtn = new JButton("Generate Excel File");
				ExcelBtn.setFont(new Font("Tahoma", Font.PLAIN, 15));
				ExcelBtn.setBackground(Color.WHITE);
				ExcelBtn.setBounds(474, 494, 171, 27);
				GanerateStatement.add(ExcelBtn);
				ExcelBtn.addActionListener(this);		  
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == SearchBtn) {
			StatementBean stmt =new StatementBean();
			Object ac = AccBox.getSelectedItem();
			 ac = AccBox.getSelectedItem();
			 int a = (int) ac;
			stmt.setAccNo(a);
			
			Object startDate =daycombobox.getSelectedItem();
			Object startMonth =Monthcombobox_1.getSelectedItem();
			Object startYear = yearcombobox_2.getSelectedItem();
			
			
			startDate =daycombobox.getSelectedItem();
			 startMonth =Monthcombobox_1.getSelectedItem();
			 startYear = yearcombobox_2.getSelectedItem();
			
			 
			 Object endDate =  endDaycombobox.getSelectedItem();
			 Object endMonth = EndMonthcombobox.getSelectedItem();
			 Object endYear = endYearcombobox.getSelectedItem();
			 
			 endDate =  endDaycombobox.getSelectedItem();
			  endMonth = EndMonthcombobox.getSelectedItem();
			  endYear = endYearcombobox.getSelectedItem();
			
			String finalStartDate = (startYear+"-"+startMonth+"-"+startDate);
			String finalEndDate  = (endYear+"-"+endMonth+"-"+endDate);
			
			stmt.setStartDate(finalStartDate);
			stmt.setEndDate(finalEndDate);
				
			  List<StatementBean> list = StatementDao.statementTable(stmt);
			  for(StatementBean x :list) {  
				  Object row[]= new Object[] {x.getTransactionDate(),  x.getTransctionId(),x.getDepositBal(),x.getWithdrawbal(), x.getAccountBal()};
				  model.addRow(row);			  
			  }			 
		}
		
		if(e.getSource() == pfdBtn) {
			
			StatementBean stmt =new StatementBean();
			Object ac = AccBox.getSelectedItem();
			 ac = AccBox.getSelectedItem();
			 int a = (int) ac;
			stmt.setAccNo(a);
			
			Object startDate =daycombobox.getSelectedItem();
			Object startMonth =Monthcombobox_1.getSelectedItem();
			Object startYear = yearcombobox_2.getSelectedItem();
			
			startDate =daycombobox.getSelectedItem();
			 startMonth =Monthcombobox_1.getSelectedItem();
			 startYear = yearcombobox_2.getSelectedItem();
			
			 Object endDate =  endDaycombobox.getSelectedItem();
			 Object endMonth = EndMonthcombobox.getSelectedItem();
			 Object endYear = endYearcombobox.getSelectedItem();
			 
			 endDate =  endDaycombobox.getSelectedItem();
			  endMonth = EndMonthcombobox.getSelectedItem();
			  endYear = endYearcombobox.getSelectedItem();
			
			String finalStartDate = (startYear+"-"+startMonth+"-"+startDate);
			String finalEndDate  = (endYear+"-"+endMonth+"-"+endDate);
		
			stmt.setStartDate(finalStartDate);
			stmt.setEndDate(finalEndDate);
			
			List<StatementBean> list = StatementDao.statementTable(stmt);

			int status = PdfClass.PdfMethod(list);			
			if(status >0) {
					JOptionPane.showMessageDialog(this, "PDF Downloaded in D:\\PDF_Folder\\table path");
			}else {
				JOptionPane.showMessageDialog(this, "PDF Failed");
			}

		}
	    if(e.getSource() == ExcelBtn) {
					
	    	StatementBean stmt =new StatementBean();
			Object ac = AccBox.getSelectedItem();
			 ac = AccBox.getSelectedItem();
			 int a = (int) ac;
			stmt.setAccNo(a);
			
			Object startDate =daycombobox.getSelectedItem();
			Object startMonth =Monthcombobox_1.getSelectedItem();
			Object startYear = yearcombobox_2.getSelectedItem();
			
			startDate =daycombobox.getSelectedItem();
			 startMonth =Monthcombobox_1.getSelectedItem();
			 startYear = yearcombobox_2.getSelectedItem();
	
			 Object endDate =  endDaycombobox.getSelectedItem();
			 Object endMonth = EndMonthcombobox.getSelectedItem();
			 Object endYear = endYearcombobox.getSelectedItem();
			 
			 endDate =  endDaycombobox.getSelectedItem();
			  endMonth = EndMonthcombobox.getSelectedItem();
			  endYear = endYearcombobox.getSelectedItem();
			
			String finalStartDate = (startYear+"-"+startMonth+"-"+startDate);
			String finalEndDate  = (endYear+"-"+endMonth+"-"+endDate);
		
			stmt.setStartDate(finalStartDate);
			stmt.setEndDate(finalEndDate);			
			
			  List<StatementBean> list = StatementDao.statementTable(stmt);	
			  
			 int status = ExcelClass.ExcelMethon(list);			  
			  if(status >0) {
					JOptionPane.showMessageDialog(this, "PDF Downloaded in D:\\PDF_Folder\\table path");
			  }else {
				JOptionPane.showMessageDialog(this, "PDF Failed");
			  }	  
			}
}

	
	
	
}
