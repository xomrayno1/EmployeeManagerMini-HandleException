package com.tampro.springrest01.response;
/*
 *  tạo và trả về lỗi gồm code và format
 */
public enum APIStatus {
	OK(200, "Ok"),
	ERR_BAD_REQUEST(400, "Bad Request"),
	ERR_CONFLICT(409,"Conflict"),
	CREATED(201,"Created"),
	ERR_INTERNAL_SERVER(500,"Internal Server Error"),
	ERR_CODE_EXISTS(113, "Code is exists"),
	ERR_CODE_NOT_EXISTS(114, "Code not is exists"),
	ERR_EMPLOYEE_ID_NOT_EXISTS(119,"Employee not exists "),
	ERR_EMPLOYEE_LIST_IS_EMPTY(125,"list of employee is empty "),
	ERR_TEAM_ID_NOT_EXISTS(120,"Team not exists "),
	ERR_TEAM_LIST_IS_EMPTY(122,"list of team is empty ");
	
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
