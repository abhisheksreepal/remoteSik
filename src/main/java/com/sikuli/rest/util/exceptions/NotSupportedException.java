package com.sikuli.rest.util.exceptions;

public class NotSupportedException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1231243452;
	private String message = null;
	
	public NotSupportedException(String message) {
		super("Not Supported -"+message);
		String msg = "Not Supported -"+message;
		this.message=msg;
	}
	
	public NotSupportedException() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public NotSupportedException(Throwable cause){
		super(cause);
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return message;
	}
	
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return message;
	}
}
