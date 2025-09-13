package com.developers.service;

import java.util.ArrayList;

import com.developers.Accounts.BankAccount;
import com.developers.customException.DuplicateAccountException;

public interface AccountsService {
//	public static final int accountNumber = 0;
//	public static final double balance = 0;
//	public static final String customerName = "";
//	public static final String phoneNumber = "";
//	public static final String email = "";
//	String dateOfBirth;
//	String accountType;
//	
//	
	
	
	
	public String openAccount(int accountNumber, double balance, String customerName, String phoneNumber, String email, String dateOfBirth, String accountType) throws DuplicateAccountException,Exception;
//	String accountNumber, double balance, String customerName, String phoneNumber, String email, String dateOfBirth

	public void transferFunds();
	public void closeAccount();
	public void applyInterest();
	public void deleteAccounts();
	public void displayAccountSummary();
	public void deposit(double amount);
	public void withdraw(double amount);
}

