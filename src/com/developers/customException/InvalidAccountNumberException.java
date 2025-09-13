package com.developers.customException;

public class InvalidAccountNumberException extends Exception{
	public InvalidAccountNumberException(String msg) {
		super(msg);
	}
}
