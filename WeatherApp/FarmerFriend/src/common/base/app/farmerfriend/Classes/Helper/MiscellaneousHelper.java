package common.base.app.farmerfriend.Classes.Helper;

import common.base.app.farmerfriend.Classes.DTO.WeatherConditionCodes;

import android.annotation.SuppressLint;

public class MiscellaneousHelper {
	
	public static String toCamelCase(String s) {
		String[] parts = s.split("_");
		String camelCaseString = "";
		for (String part : parts) {
			camelCaseString += toProperCase(part);
			camelCaseString += " ";
		}
		return camelCaseString;
	}

	@SuppressLint("DefaultLocale")
	private static String toProperCase(String s) {
		return s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase();
	}

	public static boolean contains(String test) {

	    for (WeatherConditionCodes c : WeatherConditionCodes.values()) {
	        if (c.name().equals(test)) {
	            return true;
	        }
	    }
	    return false;
	}
	
	public static String getValue(String test) {
	    for (WeatherConditionCodes c : WeatherConditionCodes.values()) {
	        if (c.name().equals(test)) {
	            return c.toString();
	        }
	    }
	    return null;
	}
}
