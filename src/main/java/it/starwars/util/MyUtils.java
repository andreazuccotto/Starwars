package it.starwars.util;

public class MyUtils {

	public static String getSafeString(String s) {
		return s == null ? "" : s;
	}

}
