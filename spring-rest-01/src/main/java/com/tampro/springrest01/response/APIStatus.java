package com.tampro.springrest01.response;

public enum APIStatus {
	OK(200, "Ok"),
	ERR_BAD_REQUEST(400, "Bad Request"),
	ERR_CONFLICT(409,"Conflict"),
	CREATED(201,"Created"),
	ERR_INTERNAL_SERVER(500,"Internal Server Error"),
	ERR_CODE_EXISTS(113, "Code is exists"),
	ERR_EMPLOYEE_ID_NOT_EXISTS(119,"Employee not exists ");
	
	
	private final int code ;
	private final String description;

	private APIStatus(int i, String descr) {
		// TODO Auto-generated constructor stub
		code = i;
		description = descr;
		 
	}

	public int getCode() {
		return code;
	}

	public String getDescription() {
		return description;
	}
 
	
	
}