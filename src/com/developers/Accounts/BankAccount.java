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

	public BankAccount(int accountNumber, double balance, String customerName, String phoneNumber, String email,
			String dateOfBirth, AccountType accType) {
		super();
		this.accountNumber = accountNumber;
		this.balance = balance;
		this.customerName = customerName;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.dateOfBirth = LocalDate.parse(dateOfBirth);
		this.accType = accType;
		
	}

	public BankAccount(int accountNumber) {
		super();
		System.out.println("Dummy account created");
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
		if (amount < 500) {
			this.balance += amount;
			System.out.println("Amount deposited Successfully");
			return balance;
		} else {
			throw new MinimumDepositAmountException("Minumum Deposit amount is 500 !");
		}

	}

	public void withdraw(double amount) throws InsufficientBalanceException {
		if (amount >= 0 && amount <= balance) {
			balance = balance - amount;
			System.out.println("Withdrawal successfull ");
			System.out.println("Remaining Balance : " + balance);

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
