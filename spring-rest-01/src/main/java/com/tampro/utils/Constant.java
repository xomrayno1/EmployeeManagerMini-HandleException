package com.tampro.utils;

public class Constant {
	
	 //define sort key employee
    public static final int SORT_BY_EMPLOYEE_FIRST_NAME= 1;
    public static final int SORT_BY_EMPLOYEE_DATE_OF_BIRTH = 2;
    public static final int SORT_BY_EMPLOYEE_CODE = 3;
	
	public enum ParamError{
		CODE("code", "Invalid Code");
		
		
		private final String code;
		private final String desrci;
		
		private ParamError(String code, String desrci) {
			this.code = code;
			this.desrci = desrci;
		}
		public String getCode() {
			return code;
		}
		public String getDesrci() {
			return desrci;
		}
		
		
		
	}

}
