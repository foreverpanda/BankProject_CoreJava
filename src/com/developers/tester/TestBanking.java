package com.developers.tester;

import java.util.Scanner;

import com.developers.Accounts.AccountType;
import com.developers.service.AccountServiceImpl;
import com.developers.validation.BankingValidations;

public class TestBanking {

	public static void main(String[] args) {

		AccountServiceImpl service = new AccountServiceImpl();
		boolean exit = false;
		try (Scanner sc = new Scanner(System.in)) {
			while (!exit) {
				try {
					System.out.println("Menu\n1. Open Account\n2. Display Account Summary\n3. Deposit \n4. Withdraw\n5. Display All users\n6. Transfer amount\n7. Apply interest to all Saving Accounts\n0.Exit");

					switch (sc.nextInt()) {
					case 1:
						System.out.println("Enter Account Number :");
						int accountNumber = sc.nextInt();

						System.out.println("Enter Opening Balance :");
						double openingBalance = sc.nextDouble();
						sc.nextLine(); // consume newline

						System.out.println("Enter Customer Name :");
						String customerName = sc.nextLine();

						System.out.println("Enter Phone Number :");
						String phoneNumber = sc.nextLine();

						System.out.println("Enter Email :");
						String email = sc.nextLine();

						System.out.println("Enter Date of Birth :");
						String dateOfBirth = sc.nextLine();

						System.out.println("Enter Account Type :");
						String accountType = sc.nextLine();

//						System.out.println("Enter pass");
						service.openAccount(accountNumber, openingBalance, customerName, phoneNumber, email,
								dateOfBirth, accountType);
						break;
					case 2:
						System.out.println("Enter Account Number :");
						accountNumber = sc.nextInt();
						sc.nextLine();
						service.displayAccountSummary(accountNumber);
						break;
						
					case 3:
						System.out.println("Enter Account Number : ");
						accountNumber = sc.nextInt();
						System.out.println("Enter amount to Deposit : ");
						double amount = sc.nextDouble();
						sc.nextLine();
						service.deposit(accountNumber,amount);
						break;
						
					case 4:
						System.out.println("Enter Account Number : ");
						accountNumber = sc.nextInt();
						System.out.println("Enter amount to withdraw : ");
						 amount = sc.nextDouble();
						sc.nextLine();
						service.withdraw(accountNumber,amount);
						break;
					case 5:
						service.displayAllUsers();break;
						
					case 6:
						System.out.println("Enter Source Account Number : ");
						int sourceAccountNumber = sc.nextInt();
						System.out.println("Enter Destination Account Number : ");
						int destinationAccountNumber = sc.nextInt();
						System.out.println("Enter Transfer amount : ");
						amount = sc.nextDouble();
						System.out.println("Enter Transaction password :(Default : 1234) ");
						int password = sc.nextInt();
						service.transferFunds(sourceAccountNumber, destinationAccountNumber,amount, password);
						
						
					break;
					case 7:
						System.out.println("Enter Interest Rate : ");
						double interestRate = sc.nextDouble();
						service.applyInterest(interestRate);
						break;
					
					case 8:
//						7. Display phone numbers for customers with specified account type , having balance > specific value.
//						i/p - account type , min balance .
						System.out.println("Enter Account Type : ");
						String accType = sc.next();
						sc.nextLine();
						System.out.println("Enter Minimun Balance : ");
						amount = sc.nextDouble();
						
						service.filterAccounts(AccountType.valueOf(accType),amount);
						break;
						
					case 0:
						exit = true;
					}
				} catch (Exception e) {
					sc.nextLine();
					System.out.println(e);
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
