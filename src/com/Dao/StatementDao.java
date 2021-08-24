package com.Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.Bean.OpenAccount;
import com.Bean.StatementBean;
import com.Bean.WithdrawBean;

public class StatementDao {

		static Connection con;
	 public static List<OpenAccount>  getAccountNumber() {
		 	con = DbConnection.getConnection();
		 	
		 	try {
				Statement stmt=con.createStatement();
				String  sql ="select *from AllAccount";
				ResultSet rs = stmt.executeQuery(sql);
				
				List<OpenAccount> list =new ArrayList<OpenAccount>();
				
				while(rs.next()) {
					OpenAccount x =new OpenAccount();
					x.setACno(Integer.parseInt(rs.getString(1)));
					/*
					 * x.setName(rs.getString(2)); x.setFatherName(rs.getString(3));
					 * x.setGender(rs.getString(4)); x.setMeritalStatus(rs.getString(5));
					 * x.setTypeOfAc(rs.getString(6)); x.setDOB(rs.getString(7));
					 * x.setServiseRequired(rs.getString(8));
					 * x.setAmount(Integer.parseInt(rs.getString(9)));
					 */
					list.add(x);
				}
				return list;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
	 }
	 
	 
	 public static List<StatementBean> statementTable(StatementBean x){
		 con = DbConnection.getConnection();
		 try {
				Statement stmt=con.createStatement();
				
				//String sql ="select *from finaleStatement where ((DepositDate between '"+x.getStartDate()+"' and '"+x.getEndDate()+"') or (WithdrawDate between '"+x.getStartDate()+"' and '"+x.getEndDate()+"')) and AccNo = "+x.getAccNo()+"";
				String sql = "select *from transction where (transctionDate between '"+x.getStartDate()+"' and '"+x.getEndDate()+"') and AccNo = "+x.getAccNo()+"";
				ResultSet rs = stmt.executeQuery(sql);
				
				List<StatementBean> list =new ArrayList<StatementBean>();
				while(rs.next()) {
				//	x.setDebitDate(rs.getString(4));
					//x.set
					StatementBean obj =new StatementBean();
					  obj.setAccNo(Integer.parseInt(rs.getString(1)));					  
					  obj.setTransactionDate(rs.getString(2));
					  obj.setTransctionId(Integer.parseInt(rs.getString(3)));					  
					  obj.setDepositBal(Integer.parseInt(rs.getString(4)));					  
					  obj.setWithdrawbal(Integer.parseInt(rs.getString(5)));
					  obj.setAccountBal(Integer.parseInt(rs.getString(6)));
					  
					 					
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
