package com.java.jdbc.util;

import java.util.ResourceBundle;

public class DBPropertyUtil {
	public static String getConnectionString(String propertyFile) {
		ResourceBundle rb=ResourceBundle.getBundle(propertyFile);
		String connString=rb.getString("url");
		return connString;
	}

}
