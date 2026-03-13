package com.capg.assessment.service;

import java.util.List;

import com.capg.assessment.dao.AccountDao;
import com.capg.assessment.entity.AccountBean;
import com.capg.assessment.entity.*;

public class AccountService {
	
	AccountDao accDao = new AccountDao();
	
	
	public void createAccount(long accNo, String name, long mobileNo, double balance) {
		
		AccountBean bean = new AccountBean();
		
		bean.setAccountNumber(accNo);
		bean.setCustomerName(name);
		bean.setMobileNumber(mobileNo);
		bean.setBalance(balance);
		
		accDao.createAccount(bean);
		
	}
	

	public double displayBalance(long accountNumber) {
		
		return accDao.displayBalance(accountNumber);
	}


	public void depositMoney(long accNo, double amount) {
		// TODO Auto-generated method stub
		
		accDao.depositMoney(accNo,amount);
		
	}


	public void withdrawMoney(long accNo,double amount) {
		// TODO Auto-generated method stub
		accDao.withdrawMoney(accNo,amount);
	}


	public void fundTransfer(long accNo1, long accNo2, double amount) {
		// TODO Auto-generated method stub
		accDao.fundTransfer(accNo1,accNo2,amount);
	}


	public List<TransactionBean> printTransactions(long accNo) {
		// TODO Auto-generated method stub
		return accDao.printTransactions(accNo);
	}
	
}
