package com.Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.Bean.OpenAccount;

public class TableDataDao {
	static Connection con;
	 public static List<OpenAccount>  table() {
		 	con = DbConnection.getConnection();
		 	
		 	try {
				Statement stmt=con.createStatement();
				String  sql ="select *from AllAccount";
				ResultSet rs = stmt.executeQuery(sql);
				
				List<OpenAccount> list =new ArrayList<OpenAccount>();
				
				while(rs.next()) {
					OpenAccount x =new OpenAccount();
					x.setACno(Integer.parseInt(rs.getString(1)));
					x.setName(rs.getString(2));
					x.setFatherName(rs.getString(3));
					x.setGender(rs.getString(4));
					x.setMeritalStatus(rs.getString(5));
					x.setTypeOfAc(rs.getString(6));
					x.setDOB(rs.getString(7));
					x.setServiseRequired(rs.getString(8));
					x.setAmount(Integer.parseInt(rs.getString(9)));
					list.add(x);
				}
				return list;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
	 }
	 
	 public static List<OpenAccount>  selectedAccTable(OpenAccount x) {
		 	con = DbConnection.getConnection();
		 	
		 	try {
				Statement stmt=con.createStatement();
				String  sql ="select *from AllAccount where AccNo = "+x.getACno()+"";
				ResultSet rs = stmt.executeQuery(sql);
				
				List<OpenAccount> list =new ArrayList<OpenAccount>();
				
				while(rs.next()) {
					OpenAccount obj =new OpenAccount();
					obj.setACno(Integer.parseInt(rs.getString(1)));
					obj.setName(rs.getString(2));
					obj.setFatherName(rs.getString(3));
					obj.setGender(rs.getString(4));
					obj.setMeritalStatus(rs.getString(5));
					obj.setTypeOfAc(rs.getString(6));
					obj.setDOB(rs.getString(7));
					obj.setServiseRequired(rs.getString(8));
					obj.setAmount(Integer.parseInt(rs.getString(9)));
					list.add(obj);
				}
				return list;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
	 }
	 
	 
}
