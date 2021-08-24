package com.Bean;

public class StatementBean {
		private String StartDate,EndDate,TransactionDate,name;
		
		private int depositBal,withdrawbal,AccountBal,AccNo,transctionId ;

		public String getStartDate() {
			return StartDate;
		}

		public void setStartDate(String startDate) {
			StartDate = startDate;
		}

		public String getEndDate() {
			return EndDate;
		}

		public void setEndDate(String endDate) {
			EndDate = endDate;
		}

		public String getTransactionDate() {
			return TransactionDate;
		}

		public void setTransactionDate(String transactionDate) {
			TransactionDate = transactionDate;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getDepositBal() {
			return depositBal;
		}

		public void setDepositBal(int depositBal) {
			this.depositBal = depositBal;
		}

		public int getWithdrawbal() {
			return withdrawbal;
		}

		public void setWithdrawbal(int withdrawbal) {
			this.withdrawbal = withdrawbal;
		}

		public int getAccountBal() {
			return AccountBal;
		}

		public void setAccountBal(int accountBal) {
			AccountBal = accountBal;
		}

		public int getAccNo() {
			return AccNo;
		}

		public void setAccNo(int accNo) {
			AccNo = accNo;
		}

		public int getTransctionId() {
			return transctionId;
		}

		public void setTransctionId(int transctionId) {
			this.transctionId = transctionId;
		}
		
}
