package com.capg.assessment.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "transactions")
public class TransactionBean implements Serializable{
	
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int transactionId;
	
	
	@Column(name = "acc_no")
	private long accountNumber;
	
	@Column(name = "message")
	private String transaction;
	
	@Column(name = "date_of_transaction")
	private Date date;

	public long getAccountNumber() {
		return accountNumber;
	}
	
	public int getTransactionId() {
		return transactionId;
	}
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	public void setTransactionId(int transactionId) {
		this.transactionId=transactionId;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getTransaction() {
		return transaction;
	}

	public void setTransaction(String transaction) {
		this.transaction = transaction;
	}
	
	
	
}
