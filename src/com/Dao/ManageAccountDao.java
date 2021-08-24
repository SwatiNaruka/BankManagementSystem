package com.Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.Bean.OpenAccount;
import com.View.ManageAcocunt;

public class ManageAccountDao {
		static Connection con;
			public static void getDetail(OpenAccount x) {
				con =DbConnection.getConnection();
				try {
					Statement stmt=con.createStatement();					
					String sql = "select *from AllAccount where AccNo = "+x.getACno()+"";
					
					ResultSet rs = stmt.executeQuery(sql);
					while(rs.next()) {
						x.setName(rs.getString(2));
						x.setFatherName(rs.getString(3));
						x.setGender(rs.getString(4));
						x.setMeritalStatus(rs.getString(5));
						x.setTypeOfAc(rs.getString(6));
						x.setDOB(rs.getString(7));
						x.setServiseRequired(rs.getString(8));
						x.setAmount(Integer.parseInt(rs.getString(9)));
						
			
					}
					
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
			public static int ModifyData(OpenAccount x) {
				con =DbConnection.getConnection();
				try {
					Statement stmt= con.createStatement();
					String sql ="update AllAccount set Name = '"+x.getName()+"',FatherName='"+x.getFatherName()+"',Gender='"+x.getGender()+"',Merital_status='"+x.getMeritalStatus()+"',TypeOfAcc='"+x.getTypeOfAc()+"',DoB='"+x.getDOB()+"',ServicRequired='"+x.getServiseRequired()+"',Amount="+x.getAmount()+" where AccNo = "+x.getACno()+"";
					
					int status = stmt.executeUpdate(sql);
					return status;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return 0;
				}
				
			}
}
