package common.base.app.farmerfriend.Classes.Helper;

import common.base.app.farmerfriend.*;
import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.*;

public class WeatherUIHelper {

	public static void fillStateSelectionSpinner(Spinner stateSelector,
			StartWeatherActivity listner) {
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
				listner, R.array.stateListForSpinner,
				android.R.layout.simple_spinner_item);
		stateSelector.setAdapter(adapter);
		stateSelector.setOnItemSelectedListener(listner);
	}

	public static void fillCitySelectionAutoComplete(
			AutoCompleteTextView citySelector, Context context,
			StartWeatherActivity listner) {
		WeatherSharedDataHolder.CityList = WeatherDatabaseHandler
				.GetCityListToBind(context);
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(listner,
				android.R.layout.simple_dropdown_item_1line,
				WeatherSharedDataHolder.CityList);
		citySelector.setAdapter(adapter);
		citySelector.setOnItemClickListener(listner);
	}

	public static Drawable getWeatherImageNameToDisplay(Activity showeather,
			String weatherId) {
		int num = Integer.valueOf(weatherId);
		Drawable drawable = null;
		if (isBetween(num, 200, 232)) {
			drawable = showeather.getResources().getDrawable(
					showeather.getResources().getIdentifier("ic_11d",
							"drawable", showeather.getPackageName()));
		} else if (isBetween(num, 300, 321)) {
			drawable = showeather.getResources().getDrawable(
					showeather.getResources().getIdentifier("ic_09d",
							"drawable", showeather.getPackageName()));
		} else if (isBetween(num, 500, 504)) {
			drawable = showeather.getResources().getDrawable(
					showeather.getResources().getIdentifier("ic_10d",
							"drawable", showeather.getPackageName()));
		} else if (isBetween(num, 511, 511)) {
			drawable = showeather.getResources().getDrawable(
					showeather.getResources().getIdentifier("ic_13d",
							"drawable", showeather.getPackageName()));
		} else if (isBetween(num, 520, 531)) {
			drawable = showeather.getResources().getDrawable(
					showeather.getResources().getIdentifier("ic_09d",
							"drawable", showeather.getPackageName()));
		} else if (isBetween(num, 600, 322)) {
			drawable = showeather.getResources().getDrawable(
					showeather.getResources().getIdentifier("ic_13d",
							"drawable", showeather.getPackageName()));
		} else if (isBetween(num, 701, 781)) {
			drawable = showeather.getResources().getDrawable(
					showeather.getResources().getIdentifier("ic_50d",
							"drawable", showeather.getPackageName()));
		} else if (isBetween(num, 800, 800)) {
			drawable = showeather.getResources().getDrawable(
					showeather.getResources().getIdentifier("ic_01d",
							"drawable", showeather.getPackageName()));
		} else if (isBetween(num, 801, 801)) {
			drawable = showeather.getResources().getDrawable(
					showeather.getResources().getIdentifier("ic_02d",
							"drawable", showeather.getPackageName()));
		} else if (isBetween(num, 802, 802)) {
			drawable = showeather.getResources().getDrawable(
					showeather.getResources().getIdentifier("ic_03d",
							"drawable", showeather.getPackageName()));
		} else if (isBetween(num, 803, 804)) {
			drawable = showeather.getResources().getDrawable(
					showeather.getResources().getIdentifier("ic_04d",
							"drawable", showeather.getPackageName()));
		}
		return drawable;
	}

	private static boolean isBetween(int x, int lower, int upper) {
		return lower <= x && x <= upper;
	}
	
}
