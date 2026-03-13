package com.capg.assessment.entity;

import java.io.Serializable;

import javax.persistence.*;


@Entity
@Table(name = "Accounts")
public class AccountBean implements Serializable{
	
	@Id
	@Column(name = "acc_no")
	private long accountNumber;
	
	@Column(name = "name")
	private String customerName;
	
	@Column(name = "mobile_no")
	private long mobileNumber;
	
	@Column(name = "balance")
	private double balance;
	
	public AccountBean() {
		
	}
	
	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	
	
}
