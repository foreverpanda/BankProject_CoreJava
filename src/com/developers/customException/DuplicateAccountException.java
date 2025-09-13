package com.developers.customException;

@SuppressWarnings("serial")
public class DuplicateAccountException extends Exception{
	public DuplicateAccountException(String msg) {
		super(msg);
	}
}
