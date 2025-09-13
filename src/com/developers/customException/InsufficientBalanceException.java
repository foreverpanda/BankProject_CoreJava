package com.developers.customException;

@SuppressWarnings("serial")
public class InsufficientBalanceException extends Exception {
	public   InsufficientBalanceException(String msg){
		super(msg);
	}
	
}
