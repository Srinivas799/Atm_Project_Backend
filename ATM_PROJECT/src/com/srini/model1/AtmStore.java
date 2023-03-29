package com.srini.model1;

public class AtmStore {
	private String Name;
	private long AccountNumber;
	private double Balance;
	private String Status;
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public long getAccountNumber() {
		return AccountNumber;
	}
	public void setAccountNumber(long accountNumber) {
		AccountNumber = accountNumber;
	}
	public double getBalance() {
		return Balance;
	}
	public void setBalance(double balance) {
		Balance = balance;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public AtmStore(String name, long accountNumber, double balance, String status) {
		Name = name;
		AccountNumber = accountNumber;
		Balance = balance;
		Status = status;
	}
	@Override
	public String toString() {
		return "AtmStore [Name=" + Name + ", AccountNumber=" + AccountNumber
				+ ", Balance=" + Balance + ", Status=" + Status +"]";
	}
	
	
}
