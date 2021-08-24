package com.Bean;

public class DepositBean {
	private int Accno,debidId,balance,withdrawBalance;
	private String Date;
	public int getAccno() {
		return Accno;
	}
	public void setAccno(int accno) {
		Accno = accno;
	}
	public int getDebidId() {
		return debidId;
	}
	public void setDebidId(int debidId) {
		this.debidId = debidId;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		Date = date;
	}
	public int getWithdrawBalance() {
		return withdrawBalance;
	}
	public void setWithdrawBalance(int withdrawBalance) {
		this.withdrawBalance = withdrawBalance;
	}
	
}
