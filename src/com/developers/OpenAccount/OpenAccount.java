package com.developers.OpenAccount;

import java.util.Scanner;

import com.developers.Accounts.BankAccount;
import com.developers.Accounts.CurrentAccount;
import com.developers.Accounts.SavingAccount;

public class OpenAccount {
	static Scanner sc = new Scanner(System.in);

	public static BankAccount openSavingAccount(String accNumber, double balance, String customerName, String phoneNumber) {
		boolean exit = false;
		SavingAccount s = new SavingAccount(accNumber,balance,customerName,phoneNumber); 
		System.out.println("\n---Savings Account Created Successfully---\n");
		interactWithAccount(s);

		return s;
	}
	
	
	public static BankAccount openCurrentAccount(String accNumber, double balance, String customerName, String phoneNumber, double overDraftLimit) {
		boolean exit = false;
		CurrentAccount s = new CurrentAccount(accNumber,balance,customerName,phoneNumber,overDraftLimit); 
		System.out.println("\n---Current Account Created Successfully---\n");
		interactWithAccount(s);
		return s;
	}
	
	private static void interactWithAccount(BankAccount s) {
		boolean exit = false;
		while(!exit) {
			System.out.println("\n1. Check Balance\n2. Withdraw Amount\n3. Account Summary\n4. Deposit Amount\n5. Exit\n");
			int choice = sc.nextInt();
			switch (choice) {
			case 1: System.out.println("Account Balance : "+s.getBalance()); break;
			case 2 : System.out.println("Enter Amount to withdraw : ");
			s.withdraw(sc.nextDouble());break;
			case 3: System.out.println(s.toString());; break;
			case 4: System.out.println("Enter deposit amount : ");
			s.deposit(sc.nextDouble());break;
			case 5 : exit=true;
			}

		}
	}

}
