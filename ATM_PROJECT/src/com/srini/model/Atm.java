package com.srini.model;

public class Atm {
	private String Name;
	private long phoneNumber;
	private String Address;
	private long AccountNumber;
	private double Balance;
	private int Password;
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
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
	
	public int getPassword() {
		return Password;
	}
	public void setPassword(int password) {
		Password = password;
	}
	public Atm(String Name,long PhoneNumber,String Address,long AccountNumber,int Password,double Balance)
	{
		this.Name = Name;
		this.AccountNumber = AccountNumber;
		this.Address = Address;
		this.phoneNumber = PhoneNumber;
		this.Password = Password;
		this.Balance = Balance;
	}
	@Override
	public String toString() {
		return "Atm [Name=" + Name + ", phoneNumber=" + phoneNumber + ", Address=" + Address + ", AccountNumber="
				+ AccountNumber + ", Balance=" + Balance + "]";
	}
	
}
