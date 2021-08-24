package com.Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.Bean.DepositBean;
import com.Bean.OpenAccount;
import com.Bean.WithdrawBean;

public class CashOperationDao {
		static Connection con;
		public static void getInfo(OpenAccount x) {
			con = DbConnection.getConnection( );
			try {
				Statement stmt=con.createStatement();
				String sql = "select  Name, Amount  from AllAccount where AccNo = "+x.getACno()+"";
				
				ResultSet rs = stmt.executeQuery(sql);
				while(rs.next()) {
					x.setName(rs.getString(1));
					x.setAmount(Integer.parseInt(rs.getString(2)));
				}				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();				
			}
		}
	public static int CashUpdation(OpenAccount x) {
		////AddCashDeposit(deposit);
		
		con = DbConnection.getConnection( );
		try {
			Statement stmt=con.createStatement();
			String sql = "update AllAccount set Amount = "+x.getAmount()+" where AccNo = "+x.getACno()+"";
				int status=	stmt.executeUpdate(sql);				
				return status;		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();	
			return 0;
		}
		
	}
	
	public static int AddCashDeposit(DepositBean deposit, OpenAccount x) {
		try {
			Statement stmt=con.createStatement();
		//	String sql ="insert into cashDeposit values(0,"+deposit.getBalance()+",'"+deposit.getDate()+"',"+deposit.getAccno()+")";
			String sql1 = "insert into transction(AccNo,transctionDate,depositAmount,withdrawAmount,Balance) values("+deposit.getAccno()+",'"+deposit.getDate()+"',"+deposit.getBalance()+","+deposit.getWithdrawBalance()+" ,"+x.getAmount()+")"; 
			
			int status =stmt.executeUpdate(sql1);
			int result =CashUpdation(x);
				if(result == 1) {
					status++;
				}
			return status;		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();	
			return 0;
		}
	}
	
	/**/
	
	public static int AddCashWithDraw(WithdrawBean withdraw, OpenAccount x) {
		try {
			Statement stmt=con.createStatement();
			//String sql ="insert into cashwithdraw values(0,"+withdraw.getBalance()+",'"+withdraw.getDebitDate()+"',"+withdraw.getAccNo()+")";
			String sql = "insert into transction(AccNo,transctionDate,withdrawAmount,depositAmount,Balance) values("+withdraw.getAccNo()+",'"+withdraw.getDebitDate()+"',"+withdraw.getBalance()+", "+withdraw.getDepositBalance()+","+x.getAmount()+")";
			
			int status =stmt.executeUpdate(sql);
			int result =CashUpdation(x);
				if(result == 1) {
					status++;
				}
			return status;		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();	
			return 0;
		}
	}
		
}
