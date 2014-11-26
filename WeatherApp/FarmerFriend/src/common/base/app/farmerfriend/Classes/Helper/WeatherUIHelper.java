package common.base.app.farmerfriend.Classes.Helper;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import common.base.app.farmerfriend.*;
import common.base.app.farmerfriend.Classes.Result.CurrentWeatherResult;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
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

	@SuppressLint({ "SimpleDateFormat", "DefaultLocale" })
	public static void showCurrentWeatherDataOnScreen(Activity showWeather,
			List<CurrentWeatherResult> _currentWeather) {

		for (CurrentWeatherResult currentWeather : _currentWeather) {
			Field[] property = currentWeather.getClass().getDeclaredFields();
			((TextView) showWeather.findViewById(R.id.tvWeatherCity))
					.setText(currentWeather.getWeatherLocation());
			((ScrollView) showWeather.findViewById(R.id.sclvWeatherData))
					.setVisibility(View.VISIBLE);
			((ImageView) showWeather.findViewById(R.id.imgvWeatherImgage))
					.setImageDrawable(getWeatherImageNameToDisplay(showWeather,
							currentWeather.getWeatherStateId()));
			((TextView) showWeather.findViewById(R.id.tvWeatherDescription))
					.setText(currentWeather.getWeatherDescription());
			((TextView) showWeather.findViewById(R.id.tvWeatherAvgTemp))
					.setText(currentWeather.getAavarageTemperature());
			((TextView) showWeather.findViewById(R.id.tvWeatherMinTemp))
					.setText(currentWeather.getMinTemperature());
			((TextView) showWeather.findViewById(R.id.tvWeatherMaxTemp))
					.setText(currentWeather.getMaxTemperature());

			for (int i = 0; i < property.length; i++) {
				try {
					TextView valueView = new TextView(
							showWeather.getBaseContext());
					Object value = property[i].get(currentWeather);
					if (value != null) {
						if (property[i].getType().isAssignableFrom(Date.class)) {
							valueView
									.setText(new SimpleDateFormat(
											ValidationHelper
													.getDateFormatString(MiscellaneousHelper
															.toCamelCase(property[i]
																	.getName()
																	.substring(
																			1)
																	.toLowerCase())))
											.format(value).toString());

						} else {
							valueView.setText(value.toString());
						}
						TableRow rowToAdd = new TableRow(
								showWeather.getBaseContext());
						TextView attributeView = new TextView(
								showWeather.getBaseContext());

						attributeView.setText(MiscellaneousHelper
								.toCamelCase(property[i].getName().substring(1)
										.toLowerCase()));
						rowToAdd.addView(attributeView);
						rowToAdd.addView(valueView);
						((TableLayout) showWeather
								.findViewById(R.id.tbllWeatherData))
								.addView(rowToAdd);
					}
				} catch (Exception e) {
					Log.e("error", "adfdsfsd");
				}
			}
		}
	}

}
