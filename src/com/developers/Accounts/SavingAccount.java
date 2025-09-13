package com.developers.Accounts;


public class SavingAccount extends BankAccount {
	private double interestRate = 5;

	public SavingAccount(int accountNumber, double balance, String customerName, String phoneNumber, String email,
			String date, AccountType accType,int password) {

//		String accountNumber, double balance, String customerName, String phoneNumber, String email, String dateOfBirth
		super(accountNumber, balance, customerName, phoneNumber, email, date, accType,password);
		System.out.println("Savings Account created SUCCESSFULLY");

	}

	public SavingAccount(String email) {
		// creating dummy current account for validation
		super(0, 0, null, null, null, null,null,0);
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
	public String toString() {
		return "Savings Account " + super.toString();
	}

}
