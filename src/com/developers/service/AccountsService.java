package com.developers.service;

import com.developers.customException.BankingException;
import com.developers.customException.DuplicateAccountException;
import com.developers.customException.InsufficientBalanceException;
import com.developers.customException.InvalidAccountNumberException;
import com.developers.customException.MinimumDepositAmountException;

public interface AccountsService {
	
	

	
	
	
	public String openAccount(int accountNumber, double balance, String customerName, String phoneNumber, String email, String dateOfBirth, String accountType) throws DuplicateAccountException,Exception;
//	String accountNumber, double balance, String customerName, String phoneNumber, String email, String dateOfBirth

	public void transferFunds(int sourceAccountNumber, int destAccountNumber,double amount,int password)throws InvalidAccountNumberException,InsufficientBalanceException,MinimumDepositAmountException;
	public void closeAccount() throws InvalidAccountNumberException;
	public void applyInterest() throws InvalidAccountNumberException;
	public void deleteAccounts() throws InvalidAccountNumberException ;
	public void displayAccountSummary(int accountNumber) throws InvalidAccountNumberException;
	public void deposit(int accountNumber,double amount) throws InvalidAccountNumberException, MinimumDepositAmountException;
	public void withdraw(int accountNumber,double amount) throws InvalidAccountNumberException,InsufficientBalanceException, BankingException;

	void displayAllUsers();
}

