package com.View;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.Bean.OpenAccount;
import com.Dao.TableDataDao;


import java.awt.Font;
import javax.swing.JTextField;

public class FatchAllDetail extends JPanel implements ActionListener{

	/**
	 * Create the panel.
	 */
	JButton searchBtn,backBtn;
	JPanel FatchDetail;
	private JTable table;
	private JTextField searchField;
	DefaultTableModel tablemodel;
	Object TableHead[];
	Object Row[];
	JScrollPane sp ;
	
	public FatchAllDetail() {
	//	setLayout(null);	
		FatchDetail =new JPanel();
		
		FatchDetail.setBackground(SystemColor.control);
		FatchDetail.setBounds(10,10,836,538);
		FatchDetail.setLayout(null);
		
		table = new JTable();
		table.setForeground(new Color(0, 0, 0));
		//table.setBackground(SystemColor.inactiveCaption);
		//table.setFont(new Font("Tahoma", Font.PLAIN, 15));
	//	table.setBounds(21, 37, 772, 377);
	//	FatchDetail.add(table);
		
		
		tablemodel =new DefaultTableModel();
		 TableHead =new Object[] {"ACCount Number"," Name ","Father Name","Gender","Merital Status","Type Of Account","Date of Birth","Service Required","Balance"};
		
		
		tablemodel.setColumnIdentifiers(TableHead);
		
		List<OpenAccount> list = TableDataDao.table();
		for(OpenAccount x : list) {
			 Row =new Object[] {x.getACno(),x.getName(),x.getFatherName(),x.getGender(),x.getMeritalStatus(),x.getTypeOfAc(),x.getDOB(),x.getServiseRequired(),x.getAmount()};
		   tablemodel.addRow(Row);
		}
		
		table.setModel(tablemodel);
		 sp =new JScrollPane(table);
		sp.setLocation(10, 10);
		sp.setBounds(10, 118, 816, 298);		
		FatchDetail.add(sp);
		
		searchField = new JTextField();
		searchField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		searchField.setBounds(343, 43, 368, 31);
		FatchDetail.add(searchField);
		searchField.setColumns(10);
		
		searchBtn = new JButton("Search");
		searchBtn.setBackground(new Color(240, 240, 240));
		searchBtn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		searchBtn.setBounds(719, 43, 107, 31);
		FatchDetail.add(searchBtn);
		searchBtn.addActionListener(this);
		
		backBtn = new JButton("Back");
		backBtn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		backBtn.setBackground(SystemColor.menu);
		backBtn.setBounds(719, 453, 107, 31);
		FatchDetail.add(backBtn);
		backBtn.addActionListener(this);
		backBtn.setVisible(false);
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == searchBtn) {
			
			backBtn.setVisible(true);
		
			OpenAccount x =new OpenAccount();
			x.setACno(Integer.parseInt(searchField.getText()));
			
					
			List<OpenAccount> list = TableDataDao.selectedAccTable(x);			 
			tablemodel.getDataVector().removeAllElements();
			for(OpenAccount value :list) {
				
				 Row =new Object[] {value.getACno(),value.getName(),value.getFatherName(),value.getGender(),value.getMeritalStatus(),value.getTypeOfAc(),value.getDOB(),value.getServiseRequired(),value.getAmount()};
				   tablemodel.addRow(Row);
				   
			}
		}
		
		
		  if(e.getSource() == backBtn) {
		  
			  OpenAccount x =new OpenAccount();
			  
				List<OpenAccount> list = TableDataDao.table();			 
				tablemodel.getDataVector().removeAllElements();
				for(OpenAccount value :list) {
					 Row =new Object[] {value.getACno(),value.getName(),value.getFatherName(),value.getGender(),value.getMeritalStatus(),value.getTypeOfAc(),value.getDOB(),value.getServiseRequired(),value.getAmount()};
					   tablemodel.addRow(Row);
					   
				}
		  }
		 
	}
}
