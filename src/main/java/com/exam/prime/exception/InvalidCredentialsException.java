package com.exam.prime.exception;

public class InvalidCredentialsException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -910390897291853324L;
	private String errorCode;
	private String errorMsg;

	public InvalidCredentialsException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public InvalidCredentialsException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
		// TODO Auto-generated constructor stub
	}

	public InvalidCredentialsException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	public InvalidCredentialsException(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public InvalidCredentialsException(Throwable arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public InvalidCredentialsException(String errorCode, String errorMsg) {
		super();
		this.errorCode = errorCode;
		this.errorMsg = errorMsg;
	}

}
