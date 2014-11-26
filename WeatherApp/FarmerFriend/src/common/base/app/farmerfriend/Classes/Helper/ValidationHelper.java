package common.base.app.farmerfriend.Classes.Helper;

import java.util.ArrayList;
import java.util.List;

import common.base.app.farmerfriend.Classes.DTO.WeatherDetailsDTO;
import common.base.app.farmerfriend.Classes.Result.CurrentWeatherResult;

public class ValidationHelper {

	public static String getDateFormatString(String attribute) {
		if (attribute.equalsIgnoreCase("Weather Date "))
			return "EEE, dd MMM";
		else
			return "K:mm:ss";
	}

	public static List<CurrentWeatherResult> convertToWeatherList() {

		List<CurrentWeatherResult> convertedList = new ArrayList<CurrentWeatherResult>();
		for (WeatherDetailsDTO weatherDetails : WeatherSharedDataHolder.WeatherDetailsList) {
			CurrentWeatherResult weatherDetailsToAdd = new CurrentWeatherResult(
					weatherDetails);
			convertedList.add(weatherDetailsToAdd);
		}
		return convertedList;
	}
}
