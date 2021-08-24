package com.Bean;

public class WithdrawBean {
	private int debidId,balance,AccNo,totalBalance,depositBalance;
	private String  DebitDate ;
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
	public int getAccNo() {
		return AccNo;
	}
	public void setAccNo(int accNo) {
		AccNo = accNo;
	}
	public String getDebitDate() {
		return DebitDate;
	}
	public void setDebitDate(String debitDate) {
		DebitDate = debitDate;
	}
	public int getTotalBalance() {
		return totalBalance;
	}
	public void setTotalBalance(int totalBalance) {
		this.totalBalance = totalBalance;
	}
	public int getDepositBalance() {
		return depositBalance;
	}
	public void setDepositBalance(int depositBalance) {
		this.depositBalance = depositBalance;
	}
	
}
