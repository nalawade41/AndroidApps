package common.base.app.farmerfriend.DALC;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import android.content.ContentValues;
import android.database.Cursor;
import common.base.app.farmerfriend.Classes.DTO.*;
import common.base.app.farmerfriend.Classes.Result.CurrentWeatherResult;

public class WeatherDetailsDALC {

	public static ContentValues createContentValuesToInsert(
			CurrentWeatherResult rowData) {
		ContentValues values = new ContentValues();
		values.put("LocationName",
				((CurrentWeatherResult) rowData).getLocationName());
		values.put("WeatherLocationID", ((CurrentWeatherResult) rowData)
				.getWeatherLocationId().toString());
		values.put("WeatherDate", ((CurrentWeatherResult) rowData)
				.getWeatherDate().toString());
		values.put("Sunrise", ((CurrentWeatherResult) rowData).getSunrise()
				.toString());
		values.put("Sunset", ((CurrentWeatherResult) rowData).getSunset()
				.toString());
		values.put("Temperature",
				((CurrentWeatherResult) rowData).getAavarageTemperature());
		values.put("MinTemperature",
				((CurrentWeatherResult) rowData).getMinTemperature());
		values.put("MaxTemperature",
				((CurrentWeatherResult) rowData).getMaxTemperature());
		values.put("Humidity", ((CurrentWeatherResult) rowData).getHumidity());
		values.put("Pressure", ((CurrentWeatherResult) rowData).getPressure());
		values.put("PressureGround",
				((CurrentWeatherResult) rowData).getGroundLevel());
		values.put("PressureSea",
				((CurrentWeatherResult) rowData).getSeaLevel());
		values.put("WindSpeed", ((CurrentWeatherResult) rowData).getWindSpeed());
		values.put("WindDegree",
				((CurrentWeatherResult) rowData).getWindDirection());
		values.put("ConditionCode",
				((CurrentWeatherResult) rowData).getWeatherStateId());
		values.put("Clouds",
				((CurrentWeatherResult) rowData).getCloudsPrercent());
		values.put("WeatherDateFrom", ((CurrentWeatherResult) rowData)
				.getWeatherFromDate().toString());
		values.put("WeatherDateTo", ((CurrentWeatherResult) rowData)
				.getWeatherToDate().toString());
		values.put("IsValidData", "0");
		values.put("WeatherTypeID", "0");
		values.put("DateAdded", (new Date()).toString());
		return values;
	}

	@SuppressWarnings("deprecation")
	public static List<Object> getAllData(Cursor reader) {
		List<Object> dataToReturn = new ArrayList<Object>();
		int weatherDetailsIDIndex = reader.getColumnIndex("WeatherDetailsID");
		int locationNameIndex = reader.getColumnIndex("LocationName");
		int weatherLocationIDIndex = reader.getColumnIndex("WeatherLocationID");
		int weatherDateIndex = reader.getColumnIndex("WeatherDate");
		int sunriseIndex = reader.getColumnIndex("Sunrise");
		int sunsetIndex = reader.getColumnIndex("Sunset");
		int temperatureIndex = reader.getColumnIndex("Temperature");
		int minTemeratureIndex = reader.getColumnIndex("MinTemperature");
		int maxTemperatureIndex = reader.getColumnIndex("MaxTemperature");
		int humidityIndex = reader.getColumnIndex("Humidity");
		int pressureIndex = reader.getColumnIndex("Pressure");
		int pressureGroundIndex = reader.getColumnIndex("PressureGround");
		int pressureSeaIndex = reader.getColumnIndex("PressureSea");
		int conditionCodeIndex = reader.getColumnIndex("ConditionCode");
		int windSpeedIndex = reader.getColumnIndex("WindSpeed");
		int windDegreeIndex = reader.getColumnIndex("WindDegree");
		int cloudsIndex = reader.getColumnIndex("Clouds");
		int weatherDateFromIndex = reader.getColumnIndex("WeatherDateFrom");
		int weatherDateToIndex = reader.getColumnIndex("WeatherDateTo");
		int isValidDataIndex = reader.getColumnIndex("IsValidData");
		int weatherTypeIDIndex = reader.getColumnIndex("WeatherTypeID");
		int dateAddedIndex = reader.getColumnIndex("DateAdded");
		do {
			WeatherDetailsDTO dataRow = new WeatherDetailsDTO();
			dataRow.setWeatherDetailsID(reader.getInt(weatherDetailsIDIndex));
			dataRow.setLocationName(reader.getString(locationNameIndex));
			dataRow.setWeatherLocationID(reader
					.getString(weatherLocationIDIndex));
			dataRow.setWeatherDate(new Date(reader.getString(weatherDateIndex)));
			dataRow.setSunrise(new Date(reader.getString(sunriseIndex)));
			dataRow.setSunset(new Date(reader.getString(sunsetIndex)));
			dataRow.setTemperature(Double.valueOf(reader
					.getString(temperatureIndex)));
			dataRow.setMinTemperature(Double.valueOf(reader
					.getString(minTemeratureIndex)));
			dataRow.setMaxTemperature(Double.valueOf(reader
					.getString(maxTemperatureIndex)));
			dataRow.setHumidity(Double.valueOf(reader.getString(humidityIndex)));
			dataRow.setPressure(Double.valueOf(reader.getString(pressureIndex)));
			dataRow.setPressureGround(Double.valueOf(reader
					.getString(pressureGroundIndex)));
			dataRow.setPressureSea(Double.valueOf(reader
					.getString(pressureSeaIndex)));
			dataRow.setConditionCode(reader.getString(conditionCodeIndex));
			dataRow.setWindSpeed(Double.valueOf(reader
					.getString(windSpeedIndex)));
			
			dataRow.setWindDegree(Double.valueOf(reader
					.getString(windDegreeIndex)));
			dataRow.setClouds(reader.getString(cloudsIndex));
			String value = reader.getString(weatherDateFromIndex);
			if (value != null && value.trim().length() != 0) {
				dataRow.setWeatherDateFrom(new Date(value));
				dataRow.setWeatherDateTo(new Date(reader
						.getString(weatherDateToIndex)));
			}
			dataRow.setIsValidData(reader.getInt(isValidDataIndex));
			dataRow.setWeatherTypeID(reader.getInt(weatherTypeIDIndex));
			dataRow.setDateAdded(new Date(reader.getString(dateAddedIndex)));
			dataToReturn.add(dataRow);
		} while (reader.moveToNext());
		return dataToReturn;
	}

}
