package com.tampro.springrest01.response;

public class APIResponse<T> {
	private T data;
	private String message;
	private int status;
	
	public APIResponse(T data,APIStatus apiStatus) {
		if(apiStatus == null) {
			throw new IllegalArgumentException("Apistatus must not be null");
		}
		status = apiStatus.getCode();
		message = apiStatus.getDescription();
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
	
}
