package com.tampro.springrest01.entity;

public enum Role {
	DEVELOPER(0, "Developer"),
	TESTER(1, "Tester"),
	QA(2, "QA"),
	DBA(3,"DBA");

	private final int code;
	private final String desc;
	
	private Role(int i , String descr) {
		this.code = i;
		this.desc =descr;
	}

 

	public int getCode() {
		return code;
	}



	public String getDesc() {
		return desc;
	}
	
}
