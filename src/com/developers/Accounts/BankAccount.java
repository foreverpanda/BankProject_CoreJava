package com.developers.Accounts;

import java.time.LocalDate;

import com.developers.customException.InsufficientBalanceException;
import com.developers.customException.MinimumDepositAmountException;

public class BankAccount {
	public int accountNumber;
	public double balance;
	private String customerName;
	protected String email;
	private String phoneNumber;
	private LocalDate dateOfBirth;
	private AccountType accType;
	private int password;

	public BankAccount(int accountNumber, double balance, String customerName, String phoneNumber, String email,
			String dateOfBirth, AccountType accType, int password) {
		super();
		this.accountNumber = accountNumber;
		this.balance = balance;
		this.customerName = customerName;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.dateOfBirth = LocalDate.parse(dateOfBirth);
		this.accType = accType;
		this.password = 1234;
		
	}

	public BankAccount(int accountNumber) {
		super();
		this.accountNumber = accountNumber;
		this.balance = 0;
		this.customerName = null;
		this.phoneNumber = null;
		this.email = null;
		this.dateOfBirth = null;
	}

	public double getBalance() {
		return balance;
	}

	protected void setBalance(double amount) {
	}

	public double deposit(double amount) throws MinimumDepositAmountException {
		if (amount > 500) {
			this.balance += amount;
			return balance;
		} else {
			throw new MinimumDepositAmountException("Minumum Deposit amount is 500 !");
		}

	}

	public double withdraw(double amount) throws InsufficientBalanceException {
		if (amount >= 0 && amount <= balance) {
			balance = balance - amount;
			return balance;

		} else {
			throw new InsufficientBalanceException("Insufficient Balance !!");
		}
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public String toString() {
		return "Account Number : " + accountNumber + "\nAccount holder Name : " + customerName + "\n Date of Birth : "
				+ dateOfBirth + "\nRegistered Mobile Number : " + phoneNumber + "\nRegistered Email Id : " + email;
	}

	@Override
	public boolean equals(Object o) {
		if (accountNumber == ((BankAccount) o).accountNumber)
			return true;

		return false;
	}

}
