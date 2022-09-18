package com.Flipkart.Exception;

import com.google.protobuf.Message;

public class UserNotFoundException extends RuntimeException {

	public int Errorcode;
	public String message;
	public UserNotFoundException(Integer code,String msg)
	{
	   this.Errorcode = code;
	   this.message = msg;
	}
	public int getErrorcode() {
		return Errorcode;
	}
	public void setErrorcode(int errorcode) {
		Errorcode = errorcode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
