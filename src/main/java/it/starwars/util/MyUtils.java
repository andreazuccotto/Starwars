package it.starwars.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class MyUtils {

	private static final Properties properties = new Properties();
	private static final String PROPERTIES_PATH = "/home/pi/properties/config.properties";

	static {
		InputStream input = null;
		try {
			input = new FileInputStream(PROPERTIES_PATH);
			properties.load(input);
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static String getSafeString(String s) {
		return s == null ? "" : s;
	}

	public static String getProperties(String prop) {
		return properties.getProperty(prop);
	}

}
