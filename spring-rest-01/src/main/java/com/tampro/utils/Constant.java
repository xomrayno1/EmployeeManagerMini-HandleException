package com.tampro.utils;

public class Constant {
	
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
