package com.developers.service;

import java.util.ArrayList;

import com.developers.Accounts.AccountType;
import com.developers.Accounts.BankAccount;
import com.developers.Accounts.CurrentAccount;
import com.developers.Accounts.SavingAccount;
import com.developers.customException.BankingException;
import com.developers.customException.DuplicateAccountException;
import com.developers.customException.InvalidEmailException;
import com.developers.validation.BankingValidations;

public class AccountServiceImpl implements AccountsService {

	ArrayList<BankAccount> bankAccounts ;
	
	public AccountServiceImpl() {
		bankAccounts = new ArrayList<>();
	}

	@Override
	public String  openAccount(int accountNumber, double balance, String customerName, String phoneNumber, String email,
			String dateOfBirth, String accountType)
			throws DuplicateAccountException, InvalidEmailException, Exception {

		// Checking for duplicates
		BankingValidations.checkForDup(accountNumber, balance, customerName, phoneNumber, email, dateOfBirth,
				accountType, bankAccounts);
		System.out.println("No Duplicate Account Number found");
		System.out.println("Proceeding with email validation");
		BankingValidations.validateEmail(email);
		System.out.println("Email Validation Completed");
		System.out.println("Proceeding with Account Type Validation");
		AccountType typeOfAccount = BankingValidations.validateAccountType(accountType);
		System.out.println("-----Completed with account validation------");
		System.out.println("Creating bank account");
		if (typeOfAccount == AccountType.CURRENT) {
			CurrentAccount curr = new CurrentAccount(accountNumber, balance, customerName, phoneNumber, email,
					dateOfBirth, typeOfAccount, 5000);
			bankAccounts.add(curr);

		} else if (typeOfAccount == AccountType.SAVING) {
			SavingAccount saveAcc = new SavingAccount(accountNumber, balance, customerName, phoneNumber, email,
					dateOfBirth, typeOfAccount);
			bankAccounts.add(saveAcc);

		} else {
			throw new BankingException("Unfortunate Error Occurred Please try again!");
		}

		return "Account Created successfully!!!!";

	}

	@Override
	public void displayAccountSummary() {

	}

	@Override
	public void deposit(double amount) {

	}

	@Override
	public void withdraw(double amount) {

	}

	@Override
	public void transferFunds() {
		// TODO Auto-generated method stub

	}

	@Override
	public void closeAccount() {
		// TODO Auto-generated method stub

	}

	@Override
	public void applyInterest() {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAccounts() {
		// TODO Auto-generated method stub

	}

}
