package com.AppDevelopement.Dev.exception;

public class UserNotFoundCustomException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	public UserNotFoundCustomException(String msg) {
		
		super(msg);
	}

}
