package com.developers.service;

import java.util.ArrayList;

import com.developers.Accounts.AccountType;
import com.developers.Accounts.BankAccount;
import com.developers.Accounts.CurrentAccount;
import com.developers.Accounts.SavingAccount;
import com.developers.customException.BankingException;
import com.developers.customException.DuplicateAccountException;
import com.developers.customException.InsufficientBalanceException;
import com.developers.customException.InvalidAccountNumberException;
import com.developers.customException.InvalidEmailException;
import com.developers.customException.MinimumDepositAmountException;
import com.developers.validation.BankingValidations;

public class AccountServiceImpl implements AccountsService {
//	public   int accountNumber ;
//	public   double balance ;
//	public   String customerName ;
//	public   String phoneNumber ;
//	public String email ;
//	String dateOfBirth;
//	String accountType;
	ArrayList<BankAccount> bankAccounts;

	public AccountServiceImpl() {
		bankAccounts = new ArrayList<>();
		BankAccount acc1 = new SavingAccount(101, 15000.0, "Rahul Verma", "9876543210", "rahul.verma@gmail.com", "1992-08-15", AccountType.SAVING,1111);
		BankAccount acc2 = new CurrentAccount(102, 25000.0, "Priya Sharma", "9123456780", "priya.sharma@gmail.com", "1988-03-22", AccountType.CURRENT,500,1111);
		BankAccount acc3 = new SavingAccount(103, 10000.0, "Amit Joshi", "9988776655", "amit.joshi@gmail.com", "1995-12-05", AccountType.SAVING,1111);
		BankAccount acc4 = new CurrentAccount(104, 50000.0, "Neha Gupta", "9012345678", "neha.gupta@gmail.com", "1990-07-11", AccountType.CURRENT,6000,1111);
		BankAccount acc5 = new SavingAccount(105, 30000.0, "Karan Mehta", "9765432101", "karan.mehta@gmail.com", "1993-11-19", AccountType.SAVING,1111);
		BankAccount acc6 = new CurrentAccount(106, 12000.0, "Sanya Kapoor", "9456123780", "sanya.kapoor@gmail.com", "1991-04-28", AccountType.CURRENT,6000,1111);
//		BankAccount acc7 = new SavingAccount(107, 18000.0, "Vikram Singh", "9871234567", "vikram.singh@gmail.com", "1987-09-03", AccountType.SAVING,1111);
//		BankAccount acc8 = new CurrentAccount(108, 40000.0, "Ritika Joshi", "9023456789", "ritika.joshi@gmail.com", "1994-06-17", AccountType.CURRENT,6000,1111);
		bankAccounts.add(acc1);
		bankAccounts.add(acc2);
		bankAccounts.add(acc3);
		bankAccounts.add(acc4);
		bankAccounts.add(acc5);
		bankAccounts.add(acc6);
//		bankAccounts.add(acc7);
//		bankAccounts.add(acc8);
		
	}

	@Override
	public String openAccount(int accountNumber, double balance, String customerName, String phoneNumber, String email,
			String dateOfBirth, String accountType) throws DuplicateAccountException, InvalidEmailException, Exception {

		BankingValidations.checkForDup(accountNumber, bankAccounts);
		BankingValidations.validateEmail(email);
		AccountType typeOfAccount = BankingValidations.validateAccountType(accountType);

		if (typeOfAccount == AccountType.CURRENT) {
			CurrentAccount curr = new CurrentAccount(accountNumber, balance, customerName, phoneNumber, email,
					dateOfBirth, typeOfAccount, 5000,1111);
			bankAccounts.add(curr);

		} else if (typeOfAccount == AccountType.SAVING) {
			SavingAccount saveAcc = new SavingAccount(accountNumber, balance, customerName, phoneNumber, email,
					dateOfBirth, typeOfAccount,1111);
			bankAccounts.add(saveAcc);

		} else {
			throw new BankingException("Unfortunate Error Occurred Please try again!");
		}

		return "Account Created successfully!!!!";

	}

	@Override
	public void displayAccountSummary(int accountNumber) throws InvalidAccountNumberException {
		BankAccount dummyAccount = new BankAccount(accountNumber);
		int index = bankAccounts.indexOf(dummyAccount);
		if (index != -1) {
			System.out.println(bankAccounts.get(index));
		} else {
			throw new InvalidAccountNumberException("Invalid Account number ---");
		}

	}

	@Override
	public void deposit(int accountNumber, double amount)
			throws InvalidAccountNumberException, MinimumDepositAmountException {
		BankAccount dummyAccount = new BankAccount(accountNumber);
		int index = bankAccounts.indexOf(dummyAccount);
		if (index == -1) {
			throw new InvalidAccountNumberException("Invalid Account Number !!!");
		}
		BankAccount ref = bankAccounts.get(index);
		ref.deposit(amount);
		System.out.println("Amount Deposited Successfully");
		System.out.println("Current Balance : " + ref.getBalance());
	}

	@Override
	public void withdraw(int accountNumber, double amount)
			throws InsufficientBalanceException, InvalidAccountNumberException {
		BankAccount dummyAccount = new BankAccount(accountNumber);
		int index = bankAccounts.indexOf(dummyAccount);
		if (index == -1) {
			throw new InvalidAccountNumberException("Invalid Account Number !!!");
		}

		BankAccount ref = bankAccounts.get(index);

		if (ref instanceof CurrentAccount) {
			double balance = ((CurrentAccount) ref).withdraw(amount);
			System.out.println("Remaining Overdraft/Balace : "+ balance);
		} else if (ref instanceof SavingAccount) {
			System.out.println("Remaining Balance : " + ref.withdraw(amount));
		}
		System.out.println("Transaction successful!");

	}

	@Override
	public void displayAllUsers() {
		for(BankAccount i : bankAccounts) {
			if( i instanceof SavingAccount) {
				System.out.println((SavingAccount)i);
			}
			else if( i instanceof CurrentAccount) {
				System.out.println((CurrentAccount)i);
			}
			System.out.println("\n");

		}
	}
	@Override
	public void transferFunds(int sourceAccountNumber, int destAccountNumber, double amount,int password) throws InvalidAccountNumberException, InsufficientBalanceException, MinimumDepositAmountException{
		// TODO Auto-generated method stub
		BankAccount source = new BankAccount(sourceAccountNumber);
		BankAccount dest = new BankAccount(destAccountNumber);
		int sourceIndex = bankAccounts.indexOf(source);
		int destIndex = bankAccounts.indexOf(dest);
		
		if(sourceIndex == -1) {
			throw new InvalidAccountNumberException("Invalid Source Account Number--");
		}
		if(destIndex == -1) {
			throw new InvalidAccountNumberException("Invalid Destination Account Number--");
		}
		withdraw(sourceAccountNumber,amount);
		deposit(destAccountNumber,amount);
		System.out.println("Transfer Successful");
		

	}

	@Override
	public void closeAccount(int accountNumber)throws InvalidAccountNumberException {
		BankAccount dummy = new BankAccount(accountNumber);
		int index = bankAccounts.indexOf(dummy);
		if(index == -1)
			throw new InvalidAccountNumberException("Invalid Account number ");
		BankAccount ref = bankAccounts.get(index);
		
		bankAccounts.remove(ref);
		System.out.println("Account Deleted Successfully");
		
		
		
		
	}

	@Override
	public void applyInterest(double interest) {
		AccountType accType = AccountType.valueOf("SAVING");
		for(BankAccount i : bankAccounts)
		{
			if(i.getAccountType().equals(accType)) {
				System.out.println("ASppls");

				((SavingAccount)i).applyInterest(interest);
			}
			
		}
		System.out.println("Interest of "+interest+" applied on all the SAVING accounts");
		

	}

	public void filterAccounts(AccountType accType, double amount) {
		for(BankAccount i : bankAccounts)
		{
			if((i.getAccountType().equals(accType)) && (i.getBalance() > amount )) {
				System.out.println(i);

//				((SavingAccount)i).applyInterest(interest);
			}
			
		}
//		System.out.println("Interest/ of "+interest+" applied on all the SAVING accounts");
		

		
	}


}
