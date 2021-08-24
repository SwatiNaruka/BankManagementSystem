package com.View;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

import java.awt.SystemColor;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

public class AboutProject extends JPanel {

	/**
	 * Create the panel.
	 */
	JPanel AboutProject;
	JLabel headlabel;
	
	
	public AboutProject() {
		setLayout(null);
		AboutProject =new JPanel();
		
		AboutProject.setBackground(SystemColor.control);
		AboutProject.setBounds(10,10,836, 538);
		AboutProject.setLayout(null);
	
		LineBorder lineBorder =new LineBorder(Color.LIGHT_GRAY, 2, true);
		
		headlabel = new JLabel("Detail of Bank Management System Project");
		headlabel.setForeground(new Color(100, 149, 237));
		headlabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		headlabel.setBounds(184, 10, 419, 33);
		AboutProject.add(headlabel);
		
		JTextArea textArea = new JTextArea();
		textArea.setToolTipText("");
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
		textArea.setBackground(new Color(255, 255, 255));
		textArea.setBounds(341, 84, 394, 376);
		textArea.setBorder(lineBorder);
		AboutProject.add(textArea);
		
		JLabel lblNewLabel = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/Bank.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		lblNewLabel.setBounds(59, 93, 272, 264);
		AboutProject.add(lblNewLabel);
		
		
		
		
	}
	}
