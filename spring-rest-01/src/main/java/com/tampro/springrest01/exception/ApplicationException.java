package com.tampro.springrest01.exception;

import java.util.List;

import com.tampro.springrest01.response.APIStatus;
import com.tampro.utils.Constant;

public class ApplicationException extends RuntimeException{

	private APIStatus apiStatus;
	private List<Constant.ParamError> data;
	
	
	
	
	public ApplicationException(Throwable cause) {
		super(cause);
	}
	 
	public ApplicationException(APIStatus apiStatus) {
		this.apiStatus = apiStatus;
	}
	public ApplicationException(APIStatus apiStatus, List<Constant.ParamError> data) {
		this(apiStatus);
		this.data = data;
	}

	public APIStatus getApiStatus() {
		return apiStatus;
	}

	public void setApiStatus(APIStatus apiStatus) {
		this.apiStatus = apiStatus;
	}

	public List<Constant.ParamError> getData() {
		return data;
	}

	public void setData(List<Constant.ParamError> data) {
		this.data = data;
	}
	
	public ApplicationException(APIStatus apiStatus, Exception exception) {
		// TODO Auto-generated constructor stub
		this.apiStatus = apiStatus;
		this.addSuppressed(exception);
	}
	
	
}
