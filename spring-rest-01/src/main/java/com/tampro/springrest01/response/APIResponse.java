package com.tampro.springrest01.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
 
 
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
	
	
}
