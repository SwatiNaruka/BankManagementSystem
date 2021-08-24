package com.View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import java.awt.Font;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.awt.Color;
import javax.swing.JTable;

public class CalenderView extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	JComboBox MonthComboBox, yearComboBox;
	private JTable table;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalenderView frame = new CalenderView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CalenderView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 323, 288);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 322, 37);
		panel.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		contentPane.add(panel);
		panel.setLayout(null);
		
		
		String month[]= {"January","Febuary","March","April","May","June","July","August","September","Octomber","November","December"};
		
		
		MonthComboBox = new JComboBox(month);
		MonthComboBox.setMaximumRowCount(5);
		MonthComboBox.setForeground(new Color(0,0,0));
		MonthComboBox.setEditable(true);
		MonthComboBox.setBackground(Color.WHITE);
		MonthComboBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		MonthComboBox.setBounds(10, 4, 140, 31);
		panel.add(MonthComboBox);
		
		
		
		yearComboBox = new JComboBox();
		yearComboBox.setMaximumRowCount(5);
		
		for(int i =2001; i <= LocalDateTime.now().getYear(); i++) {
			yearComboBox.addItem(i);
		}
		yearComboBox.setForeground(new Color(0,0,0));
		yearComboBox.setEditable(true);
		yearComboBox.setBackground(Color.WHITE);
		yearComboBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
		yearComboBox.setBounds(171, 4, 140, 31);
		panel.add(yearComboBox);
		
		
		
		JPanel TablePanel = new JPanel();
		TablePanel.setBounds(0, 47, 322, 216);
		contentPane.add(TablePanel);
		TablePanel.setLayout(null);
		
		table = new JTable();
		table.setBounds(10, 47, 350, 206);
		table.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		DefaultTableModel model =new DefaultTableModel();
		Object Head[] = new Object[] {"Sun","Mon","Tue","Wed","thu","Fri","Sat"};
		Object row[] =new Object[] {};
		model.setColumnIdentifiers(Head);
		model.addRow(row);
		table.setModel(model);
		
		JScrollPane sp =new JScrollPane(table);
		sp.setBounds(0, 0, 314, 206);
		sp.setFont(new Font("Tahoma", Font.PLAIN, 13));
		TablePanel.add(sp);
		
	
		Calendar c = Calendar.getInstance();
		//c.add(Calendar.DATE, -19);
		//c.getActualMaximum(Calendar.DATE);
		//String month = "January";
		System.out.println(c.getActualMaximum(c.DAY_OF_MONTH));
		
		int length   = c.getActualMaximum(c.DAY_OF_MONTH);
		int[] date = new int[length+1]; 
		for(int i = 1 ; i <= c.getActualMaximum(c.DAY_OF_MONTH);i++) {
			System.out.print(i+ "\t");
			date[i] = i;
			
		}
		System.out.println("");
		
		for(int i =0; i <= date.length-1; i++) {
			System.out.print(date[i]+ "\t");
		}System.out.println("");
		
		
		
		
		//System.out.println(c.getTime().getDate());
		c.add(Calendar.MONTH, 1);
		//System.out.println(c.getTime().toString());
	
		c.add(Calendar.MONTH, 1);
		//System.out.println("check "  +c.getTime());
	} 
}
