package com.skula.camsecure.utils;

import java.io.FileInputStream;
import java.util.Properties;

public class Property {
	private static final String PROPERTIES_FILE = "./camsecure.properties";
	private static Properties properties = new Properties();
	
	static {
		try {
			properties.load(new FileInputStream(PROPERTIES_FILE));
		} catch (Exception e) {
		}
	}

	private Property() {
	}

	public static String get(String key) {
		return properties.getProperty(key);
	}
}