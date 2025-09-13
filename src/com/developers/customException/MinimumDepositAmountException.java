package com.developers.customException;

@SuppressWarnings("serial")
public class MinimumDepositAmountException extends Exception {
	public MinimumDepositAmountException(String msg) {
		super(msg);
	}
}
