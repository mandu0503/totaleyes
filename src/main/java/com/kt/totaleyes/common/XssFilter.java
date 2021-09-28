package com.kt.totaleyes.common;

public class XssFilter {
	public static String XssReplace(String param) {
		param = param.replaceAll("<", "&lt;");
		param = param.replaceAll(">", "&gt;");
		return param;
	}
	
	public static String ReXssReplace(String param) {
		param = param.replaceAll("&lt;", "<");
		param = param.replaceAll("&gt;", ">");
		return param;
	}
}
