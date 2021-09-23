package com.kt.totaleyes.message;

public enum ReturnCode {
	
	OK("0000"),
	NG("0001"),
	;
	    
	private String code;

    ReturnCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return this.code;
    }
}
