package com.Dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.Bean.OpenAccount;

public class AccountFormDao {
	static Connection con;
		public static int submitFormData(OpenAccount x) {
				con =DbConnection.getConnection();
				
				try {
					Statement stmt=con.createStatement();
					String sql = "insert into AllAccount value("+x.getACno()+",'"+x.getName()+"','"+x.getFatherName()+"','"+x.getGender()+"','"+x.getMeritalStatus()+"','"+x.getTypeOfAc()+"','"+x.getDOB()+"','"+x.getServiseRequired()+"',"+x.getAmount()+")";
					//insert into dept value("+d.getDept_id()+",'"+d.getDeptName()+"') ";
					int status = stmt.executeUpdate(sql);
									
					return status;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return 0;
				}
		}
		
		
	public static int DeleteAccount(OpenAccount x) {
		con =DbConnection.getConnection();
		try {
			Statement stmt =con.createStatement();
			String sql ="delete from AllAccount where AccNo = "+x.getACno()+"";
			
			int status = stmt.executeUpdate(sql);
			return status;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
			
		}	
		
}
