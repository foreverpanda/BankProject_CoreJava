package com.developers.Accounts;

import com.developers.customException.InsufficientBalanceException;

public class CurrentAccount extends BankAccount {

	private double overDraftLimit = 0;

	public CurrentAccount(int accountNumber, double balance, String customerName, String phoneNumber, String email,
			String dateOfBirth, AccountType accType, double overDraftLimit,int password) {
		super(accountNumber, balance, customerName, phoneNumber, email, dateOfBirth, accType,password);
		System.out.println("Account Created successfully");
		this.overDraftLimit = overDraftLimit;
	}

	public CurrentAccount(String email) {
		// creating dummy current account for validation
		super(0, 0, null, null, null, null, null,0);
		this.email = email;
	}

	public double useOverdraftFacility(double amount) {
		balance = balance + overDraftLimit;
		balance = balance - amount;
		overDraftLimit = balance;
		balance = 0;
return overDraftLimit;


	}

	@Override
	public double withdraw(double amount) throws InsufficientBalanceException {
		if (balance >= amount) {
			balance = balance - amount;
			return balance;
		}

		else if (amount > balance + overDraftLimit) {
			throw new InsufficientBalanceException("Withdraw Failed - Insufficient Balance!!");
		} else {
			return useOverdraftFacility(amount);
		}
		

	}

	@Override
	public String toString() {
		return "Current Account " + super.toString() + " Overfraft Limit : " + overDraftLimit;
	}

}
