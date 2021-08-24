package com.View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.Image;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.awt.event.ActionEvent;

public class Login extends JFrame implements ActionListener{
	private JTextField username;
	private JTextField pass;

	/**
	 * Launch the application.
	 */
	
	JButton loginBtn;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 530, 325);
		getContentPane().setLayout(null);
		
		JLabel headLabel = new JLabel("Bank Management System");
		headLabel.setHorizontalAlignment(SwingConstants.CENTER);
		headLabel.setForeground(new Color(0, 0, 0));
		headLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		headLabel.setBounds(72, 20, 335, 30);
		getContentPane().add(headLabel);
		
		JPanel panel = new JPanel();
		panel.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel.setBounds(130, 67, 379, 162);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel userName = new JLabel("User Name:");
		userName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		userName.setBounds(10, 56, 94, 25);
		panel.add(userName);
		
	//	Calendar cl =new Calendar();
		
		username = new JTextField();
		username.setFont(new Font("Tahoma", Font.PLAIN, 15));
		username.setBounds(107, 47, 251, 34);
		panel.add(username);
		username.setColumns(10);
		
		pass = new JTextField();
		pass.setFont(new Font("Tahoma", Font.PLAIN, 15));
		pass.setBounds(107, 104, 251, 34);
		panel.add(pass);
		pass.setColumns(10);
		
		JLabel password = new JLabel("Password:");
		password.setFont(new Font("Tahoma", Font.PLAIN, 16));
		password.setBounds(10, 103, 84, 34);
		panel.add(password);
		
		loginBtn = new JButton("Login");		
		loginBtn.setForeground(new Color(0, 0, 0));
		loginBtn.setBackground(new Color(255, 255, 255));
		loginBtn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		loginBtn.setBounds(390, 243, 86, 30);
		getContentPane().add(loginBtn);
		loginBtn.addActionListener(this);
		
		
		  JLabel lblNewLabel = new JLabel(""); Image img = new
		  ImageIcon(this.getClass().getResource("/UserPass.png")).getImage();
		  lblNewLabel.setIcon(new ImageIcon(img)); 
		  lblNewLabel.setBounds(12, 0, 272,264); 
		  getContentPane().add(lblNewLabel);
		 
		
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() ==loginBtn ) {
			String name = username.getText();
			String pass1=pass.getText(); 
			if(name.equals("admin") && pass1.equals("1234")) {
				//JOptionPane.showMessageDialog(this, "login success");
				MainContentPage frame = new MainContentPage();
				frame.setVisible(true);
			}else {
				JOptionPane.showMessageDialog(this, "login failed");
			}			
		}
	}
}
