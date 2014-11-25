package common.base.app.farmerfriend.Classes.Helper;

public class ValidationHelper {

	public static String getDateFormatString(String attribute) {
		if (attribute.equalsIgnoreCase("Weather Date "))
			return "EEE, dd MMM";
		else
			return "K:mm:ss";
	}
}
