package com.developers.validation;

import java.util.ArrayList;

import com.developers.Accounts.AccountType;
import com.developers.Accounts.BankAccount;
import com.developers.customException.BankingException;
import com.developers.customException.DuplicateAccountException;
import com.developers.customException.InvalidEmailException;

public class BankingValidations {

	public static void checkForDup(int accountNumber, double balance, String customerName, String phoneNumber, String email, String dateOfBirth, String accountType,ArrayList<BankAccount> bankAccounts) throws DuplicateAccountException, BankingException {
		BankAccount dummyAccount = new BankAccount(accountNumber);
		if(bankAccounts.contains(dummyAccount)) {
			throw new DuplicateAccountException("Account Number already Exists !!");
		}
	}
	public static AccountType validateAccountType(String accountType) throws IllegalArgumentException{
	

		return AccountType.valueOf(accountType.toUpperCase());
		
	}
	
	public static void validateEmail(String email) throws InvalidEmailException{
		
		if(email.matches("^[a-z][a-z0-9._-]*@[a-z]+\\.(com|org|net)$")) {
			System.out.println("Email Validation Successful!!");
		}
		else {
			throw new InvalidEmailException("Invalid Email!!");
		}
		
			
	}
	
}
