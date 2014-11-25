package common.base.app.farmerfriend.Classes.DTO;

import java.util.Date;

public class WeatherDetail implements IDatabaseModels {

	int _weatherDetailsID;
	int _locationID;
	String _weatherLocationID;
	String _dateAdded;

	public WeatherDetail() {
	}

	public WeatherDetail(int weatherDetailsID, int locationID,
			String weatherLocationID) {
		this._dateAdded = (new Date()).toString();
		;
		this._locationID = locationID;
		this._weatherDetailsID = weatherDetailsID;
		this._weatherLocationID = weatherLocationID;
	}

	public WeatherDetail(int locationID, String weatherLocationID) {
		this._dateAdded = (new Date()).toString();
		;
		this._locationID = locationID;
		this._weatherLocationID = weatherLocationID;
	}

	public int getWeatherDetailsID() {
		return _weatherDetailsID;
	}

	public void setWeatherDetailsID(int _weatherDetailsID) {
		this._weatherDetailsID = _weatherDetailsID;
	}

	public int getLocationID() {
		return _locationID;
	}

	public void setLocationID(int _locationID) {
		this._locationID = _locationID;
	}

	public String getWeatherLocationID() {
		return _weatherLocationID;
	}

	public void setWeatherLocationID(String _weatherLocationID) {
		this._weatherLocationID = _weatherLocationID;
	}

	public String getDateAdded() {
		return _dateAdded;
	}

	public void setDateAdded(String _dateAdded) {
		this._dateAdded = (_dateAdded).toString();
	}

}
