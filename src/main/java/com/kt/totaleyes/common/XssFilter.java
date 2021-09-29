package com.kt.totaleyes.common;

public class XssFilter {
	public static String escape(String param) {
		return param.replaceAll("<", "&lt;")
					.replaceAll(">", "&gt;");
	}
	
	public static String unescape(String param) {
		return param.replaceAll("&lt;", "<")
				.replaceAll("&gt;", ">");
	}
}
