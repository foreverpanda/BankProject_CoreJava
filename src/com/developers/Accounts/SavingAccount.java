package com.developers.Accounts;

import com.developers.customException.MinimumDepositAmountException;

public class SavingAccount extends BankAccount {
	private double interestRate = 5;

	public SavingAccount(int accountNumber, double balance, String customerName, String phoneNumber, String email,
			String date, AccountType accType) {

//		String accountNumber, double balance, String customerName, String phoneNumber, String email, String dateOfBirth
		super(accountNumber, balance, customerName, phoneNumber, email, date, accType);
		System.out.println("Savings Account created SUCCESSFULLY");

	}

	public SavingAccount(String email) {
		// creating dummy current account for validation
		super(0, 0, null, null, null, null,null);
		this.email = email;
	}

	public void applyInterest() {
		double balance = getBalance();
		balance = balance + (balance * interestRate / 100);
		setBalance(balance);
		System.out.println("InterestRate applied: " + interestRate);
		System.out.println("Updated Balance: " + getBalance());
	}

	@Override
	public double deposit(double amount) throws MinimumDepositAmountException {
		if (amount < 500)
			throw new MinimumDepositAmountException("Minimum Deposit Amount is 500");
		this.balance += amount;
		System.out.println("Amount deposited Successfully");
		return balance;

	}

	@Override
	public String toString() {
		return "Savings Account " + super.toString();
	}

}
