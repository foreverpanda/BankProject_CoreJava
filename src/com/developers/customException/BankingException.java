package com.developers.customException;

public class BankingException extends Exception{
	public BankingException(String msg){
		super(msg);
	}
}
