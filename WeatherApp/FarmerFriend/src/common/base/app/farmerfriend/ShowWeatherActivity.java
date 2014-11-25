package common.base.app.farmerfriend;

import java.io.*;
import java.lang.reflect.Field;
import java.net.*;
import java.text.SimpleDateFormat;
import java.util.*;
import common.base.app.farmerfriend.Classes.DTO.*;
import common.base.app.farmerfriend.Classes.Helper.*;
import common.base.app.farmerfriend.Classes.Parser.*;
import common.base.app.farmerfriend.Classes.Result.CurrentWeatherResult;
import android.support.v7.app.ActionBarActivity;
import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.*;
import android.widget.*;

public class ShowWeatherActivity extends ActionBarActivity {

	private static final String EXTRA_MESSAGE = "Extra_Message";
	@SuppressWarnings("unused")
	private static LocationDTO _weatherLocation;
	private IJsonParser _parser;
	private List<CurrentWeatherResult> _currentWeather;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_show_weather);
		String value = getIntent().getStringExtra(EXTRA_MESSAGE);
		TimeZone.setDefault(TimeZone.getTimeZone("Asia/Calcutta"));
		if (WeatherSharedDataHolder.CityList != null
				&& WeatherSharedDataHolder.CityList.length > 0) {
			Boolean flagToBreak = false;
			for (int i = 0; i < WeatherSharedDataHolder.CityList.length; i++) {
				if (WeatherSharedDataHolder.CityList[i].equals(value)) {
					for (LocationDTO location : WeatherSharedDataHolder.LocationList) {
						if (location.getLocationName().equals(value)) {
							_weatherLocation = location;
							flagToBreak = true;
							break;
						}
					}
				}
				if (flagToBreak)
					break;
			}
		}
		ProcessWeatherApi(value);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.show_weather, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	private void ProcessWeatherApi(String locationName) {
		String url = "http://api.openweathermap.org/data/2.5/weather?q="
				+ locationName + "&units=metric";
		(new GetWeatherData()).execute(url);
	}

	private class GetWeatherData extends AsyncTask<String, String, String> {

		@SuppressWarnings({ "unchecked", "rawtypes" })
		@Override
		protected String doInBackground(String... params) {
			// progressDialog.show();
			String urlString = params[0];
			InputStream in = null;
			try {
				URL url = new URL(urlString);
				HttpURLConnection connection = (HttpURLConnection) url
						.openConnection();
				in = new BufferedInputStream(connection.getInputStream());
			} catch (Exception e) {
				Log.e("Exception found ", e.getMessage());
			}
			if (in != null) {
				try {
					_parser = new CurrentWeatherParser();
					_currentWeather = (List<CurrentWeatherResult>) (List) _parser
							.readJsonStream(in);
				} catch (Exception e) {
				}
			}
			return null;
		}

		@Override
		protected void onPreExecute() {

		}

		@SuppressLint({ "DefaultLocale", "SimpleDateFormat" })
		@Override
		protected void onPostExecute(String result) {
			if (_currentWeather != null && _currentWeather.size() > 0) {
				for (CurrentWeatherResult currentWeather : _currentWeather) {
					Field[] property = currentWeather.getClass()
							.getDeclaredFields();
					((TextView) findViewById(R.id.tvWeatherCity))
							.setText(currentWeather.getWeatherLocation());
					((ScrollView) findViewById(R.id.sclvWeatherData))
							.setVisibility(View.VISIBLE);
					((ImageView) findViewById(R.id.imgvWeatherImgage))
							.setImageDrawable(WeatherUIHelper
									.getWeatherImageNameToDisplay(
											ShowWeatherActivity.this,
											currentWeather.getWeatherStateId()));
					((TextView) findViewById(R.id.tvWeatherDescription))
							.setText(currentWeather.getWeatherDescription());
					((TextView) findViewById(R.id.tvWeatherAvgTemp))
							.setText(currentWeather.getAavarageTemperature());
					((TextView) findViewById(R.id.tvWeatherMinTemp))
							.setText(currentWeather.getMinTemperature());
					((TextView) findViewById(R.id.tvWeatherMaxTemp))
							.setText(currentWeather.getMaxTemperature());

					for (int i = 0; i < property.length; i++) {
						try {
							TextView valueView = new TextView(getBaseContext());
							Object value = property[i].get(currentWeather);
							if (value != null) {
								if (property[i].getType().isAssignableFrom(
										Date.class)) {
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
										getBaseContext());
								TextView attributeView = new TextView(
										getBaseContext());

								attributeView.setText(MiscellaneousHelper
										.toCamelCase(property[i].getName()
												.substring(1).toLowerCase()));
								rowToAdd.addView(attributeView);
								rowToAdd.addView(valueView);
								((TableLayout) findViewById(R.id.tbllWeatherData))
										.addView(rowToAdd);
							}
						} catch (Exception e) {
							Log.e("error", "adfdsfsd");
						}
					}
				}
			}
		}
	}
}
