package com.developers.tester;

import java.util.Scanner;

import com.developers.service.AccountServiceImpl;
import com.developers.validation.BankingValidations;

public class TestBanking {

	public static void main(String[] args) {

		AccountServiceImpl service = new AccountServiceImpl();
		boolean exit = false;
		try (Scanner sc = new Scanner(System.in)) {
			while (!exit) {
				System.out.println("Menu\n1. Open Account\n0.Exit");

				switch (sc.nextInt()) {
				case 1:
					service.openAccount(sc.nextInt(), sc.nextDouble(), sc.next(), sc.next(), sc.next(), sc.next(),
							sc.next());
					break;
				case 0:
					exit = true;
				}
			}

		} catch (Exception e) {
			System.err.println(e);

		}
	}
}

//		CurrentAccount ca = new CurrentAccount("101",102.2,"Deependu","921114040","hello@gmail.com","2001-09-09",1000);
//		System.out.println(ca.getAccountNumber());
//		System.out.println(ca);
// String accountNumber, double balance, String customerName, String
// phoneNumber, String email, String dateOfBirth

//		boolean exit = false;
//		int counter = 0;
//		while (!exit) {
//			System.out.println(
//					"\n1. Open Saving Account\n2. Open Current Account\n3. Display Account Summary \n4. Deposit\n5. Withdraw \n6. Exit\n");
//			int choice = sc.nextInt();
//			switch (choice) {
//
//			case 1: {
//				
//				
//				System.out.println("Enter AccountNumber : ");
//				String accNumber = sc.next();
//				try {
//					DuplicateAccountValidation.checkAccount(bankAccounts, accNumber);
//				}
//				catch(DuplicateAccountException duplicateAccount) {
//					System.out.println("ERROR :"+ duplicateAccount.getMessage());
//					break;
//				}
//				System.out.println("Enter deposited balance : ");
//				double balance = sc.nextDouble();
//				System.out.println("Enter Customer name : ");
//				String customerName = sc.next();
//				System.out.println("Enter phone number : ");
//				String phoneNumber = sc.next();
//				
//				
//				bankAccounts[counter++] = OpenAccount.openSavingAccount(accNumber, balance, customerName, phoneNumber);
//
//				break;
//				
//			}
//			case 2:
//
//			{
//				System.out.println("Enter AccountNumber : ");
//				String accNumber = sc.next();
//				try {
//					DuplicateAccountValidation.checkAccount(bankAccounts, accNumber);
//					
//				}
//				catch(DuplicateAccountException duplicateAccount) {
//					System.out.println("ERROR :"+ duplicateAccount.getMessage());
//					break;
//				}
//				System.out.println("Enter deposited balance : ");
//				double balance = sc.nextDouble();
//				System.out.println("Enter Customer name : ");
//				String customerName = sc.next();
//				System.out.println("Enter phone number : ");
//				String phoneNumber = sc.next();
//				System.out.println("Enter Overdraft Limit : ");
//				double overDraftLimit = sc.nextDouble();
//				
//				bankAccounts[counter++] = OpenAccount.openCurrentAccount(accNumber, balance, customerName, phoneNumber,
//						overDraftLimit);
//				
//				
//								break;
//			}
//			case 3: {
//				System.out.println("Please enter Account Number : ");
//				String accountNumber = sc.next();
//				int found = 0;
//				for (BankAccount i : bankAccounts) {
//					if (i instanceof CurrentAccount) {
//						String compthis = ((CurrentAccount) i).getAccountNumber();
//						if (compthis.equals(accountNumber)) {
//							System.out.println(((CurrentAccount) i).toString());
//							found =1;
//						}
//
//					} else if (i instanceof SavingAccount) {
//						String compthis = ((SavingAccount) i).getAccountNumber();
//						if (compthis.equals(accountNumber)) {
//							System.out.println(((SavingAccount) i).toString());
//							found = 1;
//						}
//					}
//				}
//				if (found == 0)
//					System.out.println("INVALID ACCOUNT NUMBER");
//
//				break;
//			}
//			case 4: {
//				System.out.println("Please enter Account Number : ");
//				String accountNumber = sc.next();
//				int found = 0;
//				for (BankAccount i : bankAccounts) {
//					if (i instanceof CurrentAccount) {
//						String compthis = ((CurrentAccount) i).getAccountNumber();
//						if (compthis.equals(accountNumber)) {
//							System.out.println("Enter Deposit amount : ");
//							double amt = sc.nextDouble();
//							((CurrentAccount) i).deposit(amt);
//							found = 1;
//						}
//
//					} else if (i instanceof SavingAccount) {
//						String compthis = ((SavingAccount) i).getAccountNumber();
//						if (compthis.equals(accountNumber)) {
//							System.out.println("Enter Deposit amount : ");
//							double amt = sc.nextDouble();
//							((SavingAccount) i).deposit(amt);
//							found = 1;
//						}
//					}
//
//				}
//				if (found == 0)
//					System.out.println("INVALID ACCOUNT NUMBER");
//				break;
//			}
//
//			case 5: {
//				System.out.println("Please enter Account Number : ");
//				String accountNumber = sc.next();
//				int found = 0;
//				for (BankAccount i : bankAccounts) {
//					if (i instanceof CurrentAccount) {
//						String compthis = ((CurrentAccount) i).getAccountNumber();
//						if (compthis.equals(accountNumber)) {
//							System.out.println("Enter Withdraw amount : ");
//							double amt = sc.nextDouble();
//							((CurrentAccount) i).withdraw(amt);
//							found = 1;
//						}
//
//					} else if (i instanceof SavingAccount) {
//						String compthis = ((SavingAccount) i).getAccountNumber();
//						if (compthis.equals(accountNumber)) {
//							System.out.println("Enter withdraw amount : ");
//							double amt = sc.nextDouble();
//							((SavingAccount) i).withdraw(amt);
//							found = 1;
//						}
//					}
//
//				}
//				if (found == 0)
//					System.out.println("INVALID ACCOUNT NUMBER");
//				break;
//			}
//
//			case 6:
//				exit = true;
//				break;
//			}
//
//		}
//	}
