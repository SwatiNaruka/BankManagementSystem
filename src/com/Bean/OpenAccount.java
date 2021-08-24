package com.Bean;

public class OpenAccount {
	private int ACno,Amount;

	//private String DOB;
	
	private String name,FatherName,Gender,MeritalStatus,TypeOfAc,ServiseRequired,DOB;
	

	public int getACno() {
		return ACno;
	}

	public void setACno(int aCno) {
		ACno = aCno;
	}

	public String getDOB() {
		return DOB;
	}

	public void setDOB(String dOB) {
		DOB = dOB;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFatherName() {
		return FatherName;
	}

	public void setFatherName(String fatherName) {
		FatherName = fatherName;
	}

	public String getGender() {
		return Gender;
	}

	public void setGender(String gender) {
		Gender = gender;
	}

	public String getMeritalStatus() {
		return MeritalStatus;
	}

	public void setMeritalStatus(String meritalStatus) {
		MeritalStatus = meritalStatus;
	}

	public String getTypeOfAc() {
		return TypeOfAc;
	}

	public void setTypeOfAc(String typeOfAc) {
		TypeOfAc = typeOfAc;
	}

	public String getServiseRequired() {
		return ServiseRequired;
	}

	public void setServiseRequired(String serviseRequired) {
		ServiseRequired = serviseRequired;
	}

	public int getAmount() {
		return Amount;
	}

	public void setAmount(int amount) {
		Amount = amount;
	}
	
}
