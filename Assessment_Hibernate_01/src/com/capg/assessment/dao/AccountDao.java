package com.capg.assessment.dao;

import java.time.LocalDate;
import java.util.List;
import java.sql.Date;

import org.hibernate.Transaction;
import org.hibernate.Session;

import com.capg.assessment.db.AccountDB;
import com.capg.assessment.entity.AccountBean;
import com.capg.assessment.entity.TransactionBean;

public class AccountDao {
	
	public void createAccount(AccountBean bean) {
	
	    Session session = AccountDB.getSession();
	    Transaction tx = null;
	
	    try {
	        tx = session.beginTransaction();
	
	        session.save(bean);
	
	        TransactionBean trans = new TransactionBean();
	        trans.setAccountNumber(bean.getAccountNumber());
	        trans.setTransaction("Created An Account");
	        trans.setDate(Date.valueOf(LocalDate.now()));
	
	        session.save(trans);
	
	        tx.commit();
	        System.out.println("Account Created Successfully");
	
	    } catch (Exception e) {
	        if (tx != null) tx.rollback();
	        System.out.println("Transaction Failed");
	        e.printStackTrace();
	    } finally {
	        session.close();
	    }
	}
	
	public double displayBalance(long accountNumber) {
	
	    Session session = AccountDB.getSession();
	
	    try {
	        AccountBean bean = (AccountBean) session.get(AccountBean.class, accountNumber);
	
	        if (bean == null) {
	            System.out.println("Account not found");
	            return 0.0;
	        }
	
	        return bean.getBalance();
	
	    } finally {
	        session.close();
	    }
	}
	
	public void depositMoney(long accNo, double amount) {
	
	    Session session = AccountDB.getSession();
	    Transaction tx = null;
	
	    try {
	        if (amount <= 0) {
	            System.out.println("Invalid amount");
	            return;
	        }
	
	        AccountBean bean = (AccountBean) session.get(AccountBean.class, accNo);
	
	        if (bean == null) {
	            System.out.println("Account not found");
	            return;
	        }
	
	        tx = session.beginTransaction();
	
	        bean.setBalance(bean.getBalance() + amount);
	        session.update(bean);
	
	        TransactionBean trans = new TransactionBean();
	        trans.setAccountNumber(bean.getAccountNumber());
	        trans.setTransaction("Deposited " + amount + " successfully");
	        trans.setDate(Date.valueOf(LocalDate.now()));
	
	        session.save(trans);
	
	        tx.commit();
	        System.out.println("Amount deposited successfully");
	
	    } catch (Exception e) {
	        if (tx != null) tx.rollback();
	        System.out.println("Transaction Failed");
	        e.printStackTrace();
	    } finally {
	        session.close();
	    }
	}
	
	public void withdrawMoney(long accNo, double amount) {
	
	    Session session = AccountDB.getSession();
	    Transaction tx = null;
	
	    try {
	        if (amount <= 0) {
	            System.out.println("Invalid amount");
	            return;
	        }
	
	        AccountBean bean = (AccountBean) session.get(AccountBean.class, accNo);
	
	        if (bean == null) {
	            System.out.println("Account not found");
	            return;
	        }
	
	        if (bean.getBalance() < amount) {
	            System.out.println("Insufficient balance");
	            return;
	        }
	
	        tx = session.beginTransaction();
	
	        bean.setBalance(bean.getBalance() - amount);
	        session.update(bean);
	
	        TransactionBean trans = new TransactionBean();
	        trans.setAccountNumber(bean.getAccountNumber());
	        trans.setTransaction("Withdrawn amount " + amount + " successfully");
	        trans.setDate(Date.valueOf(LocalDate.now()));
	
	        session.save(trans);
	
	        tx.commit();
	        System.out.println("Amount withdrawn successfully");
	
	    } catch (Exception e) {
	        if (tx != null) tx.rollback();
	        System.out.println("Transaction Failed");
	        e.printStackTrace();
	    } finally {
	        session.close();
	    }
	}
	
	public void fundTransfer(long accNo1, long accNo2, double amount) {
	
	    Session session = AccountDB.getSession();
	    Transaction tx = null;
	
	    try {
	        if (amount <= 0) {
	            System.out.println("Invalid amount");
	            return;
	        }
	
	        AccountBean bean1 = (AccountBean) session.get(AccountBean.class, accNo1);
	        AccountBean bean2 = (AccountBean) session.get(AccountBean.class, accNo2);
	
	        if (bean1 == null || bean2 == null) {
	            System.out.println("Invalid account number");
	            return;
	        }
	
	        if (bean1.getBalance() < amount) {
	            System.out.println("Insufficient balance");
	            return;
	        }
	
	        tx = session.beginTransaction();
	
	        bean1.setBalance(bean1.getBalance() - amount);
	        bean2.setBalance(bean2.getBalance() + amount);
	
	        session.update(bean1);
	        session.update(bean2);
	
	        TransactionBean trans1 = new TransactionBean();
	        trans1.setAccountNumber(bean1.getAccountNumber());
	        trans1.setTransaction("Amount"+amount+" transferred to " + accNo2);
	        trans1.setDate(Date.valueOf(LocalDate.now()));
	
	        TransactionBean trans2 = new TransactionBean();
	        trans2.setAccountNumber(bean2.getAccountNumber());
	        trans2.setTransaction("Amount "+amount+" received from " + accNo1);
	        trans2.setDate(Date.valueOf(LocalDate.now()));
	
	        session.save(trans1);
	        session.save(trans2);
	
	        tx.commit();
	        System.out.println("Funds Transferred Successfully");
	
	    } catch (Exception e) {
	        if (tx != null) tx.rollback();
	        System.out.println("Transaction Failed");
	        e.printStackTrace();
	    } finally {
	        session.close();
	    }
	}
	
	@SuppressWarnings("unchecked")
	public List<TransactionBean> printTransactions(long accNo) {
	
	    Session session = AccountDB.getSession();
	
	    List<TransactionBean> statements = session
	            .createQuery("from TransactionBean where accountNumber = :no order by transactionId desc")
	            .setParameter("no", accNo)
	            .list();
	
	    session.close();
	
	    return statements;
	}

}
