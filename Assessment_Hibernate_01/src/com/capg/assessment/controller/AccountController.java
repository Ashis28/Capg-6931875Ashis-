package com.capg.assessment.controller;

import java.util.List;
import java.util.Scanner;

import com.capg.assessment.entity.TransactionBean;
import com.capg.assessment.service.AccountService;

public class AccountController {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int flag=1;
		
		System.out.println("Welcome to ABC Bank!");
		
		AccountService as = new AccountService();
		
		while(flag!=-1) {
			System.out.println("---------Select An Option-----------");
			
			
			System.out.println("1. Create a New Account");
			System.out.println("2. Show Account Balance");
			System.out.println("3. Deposit Money");
			System.out.println("4. Withdraw Money");
			System.out.println("5. Fund Transfer");
			System.out.println("6. Print Transactions");
			System.out.println("7. Exit");
			
			int choice = sc.nextInt();
			
			switch(choice) {
				case 1:
					System.out.println("Enter Account Number: ");
					long accNo= sc.nextLong();
					
					sc.nextLine();
					
					System.out.println("Enter Account Holder Name: ");
					String name = sc.nextLine();
					
										
					System.out.println("Enter Mobile Number: ");
					long mobileNo=sc.nextLong();
					
					System.out.println("Enter initial balance (Ex. 1000.00)");
					double balance = sc.nextDouble();
					
					as.createAccount(accNo,name,mobileNo,balance);
					break;
					
				case 2:
					
					System.out.println("Enter acc No: ");
					long accountNumber=sc.nextLong();
					double bal = as.displayBalance(accountNumber);
					
					System.out.println("Current Balance: "+bal);
					break;
					
				case 3:
					System.out.println("Enter Acc No for depositing money: ");
					accNo = sc.nextLong();
					
					System.out.println("Enter Money to deposit: ");
					double amount = sc.nextDouble();
					
					as.depositMoney(accNo,amount);
					
					break;
					
				case 4:
					System.out.println("Enter Acc No for withdrawing money: ");
					accNo = sc.nextLong();
					
					System.out.println("Enter Amount for withdraw: ");
					amount = sc.nextDouble();
					as.withdrawMoney(accNo,amount);
					
					break;
					
				case 5:
					System.out.println("Enter Source Acc No: ");
					long accNo1 = sc.nextLong();
					
					System.out.println("Enter Target Acc No: ");
					long accNo2 = sc.nextLong();
					
					System.out.println("Enter Amount for Transfer: ");
					amount = sc.nextDouble();
					as.fundTransfer(accNo1,accNo2,amount);
					break;
					
				case 6:
					System.out.println("Enter Account Number for statement: ");
					accNo = sc.nextLong();
					
					System.out.println("Transaction History: ");
					List<TransactionBean> list = as.printTransactions(accNo);
					
					if(list == null || list.isEmpty()) {
					    System.out.println("No transactions found");
					} else {
					    for(TransactionBean bean : list) {
					        System.out.println("Transaction Id: " + bean.getTransactionId()
					                + " -> " + bean.getTransaction()
					                + " on " + bean.getDate());
					    }
					}
					break;
				case 7:
					System.out.println("Thank You For Using Our Services!");
					System.out.println("Exiting......");
					flag=-1;
					break;
				default:
					System.out.println("Invalid Option Selected");
					break;
				
			}

		}
		
	}
}
