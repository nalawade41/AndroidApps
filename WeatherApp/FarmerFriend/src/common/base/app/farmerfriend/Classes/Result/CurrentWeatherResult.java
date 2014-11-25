package common.base.app.farmerfriend.Classes.Result;

import java.util.Date;

public class CurrentWeatherResult implements IWebResult {

	public Date _sunrise;
	public Date _sunset;
	private String _weather_StateId;
	public String _weather_Description;
	public String _weather_Title;
	public String _avg_Temperature;
	public String _min_Temperature;
	public String _max_Temperature;
	public String _pressure;
	public String _sea_Level;
	public String _ground_Level;
	public String _humidity;
	public String _wind_Speed;
	public String _wind_Direction;
	public String _clouds_Prercent;
	public Date _weather_Date;
	private String _weather_LocationId;
	public String _weather_Location;

	public String getSunrise() {
		return _sunrise.toString() == "" || _sunrise == null ? "" : _sunrise
				.toString();
	}

	public String getSunset() {
		return _sunset.toString() == "" || _sunset == null ? "" : _sunset
				.toString();
	}

	public String getWeatherStateId() {
		return _weather_StateId == "" || _weather_StateId == null ? ""
				: _weather_StateId;
	}

	public String getWeatherDescription() {
		return _weather_Description == "" || _weather_Description == null ? ""
				: _weather_Description;
	}

	public String getWeatherTitleMain() {
		return _weather_Title == "" || _weather_Title == null ? ""
				: _weather_Title;
	}

	public String getAavarageTemperature() {
		return _avg_Temperature == "" || _avg_Temperature == null ? ""
				: _avg_Temperature;
	}

	public String getMinTemperature() {
		return _min_Temperature == "" || _min_Temperature == null ? ""
				: _min_Temperature;
	}

	public String getMaxTemperature() {
		return _max_Temperature == "" || _max_Temperature == null ? ""
				: _max_Temperature;
	}

	public String getPressure() {
		return _pressure == "" || _pressure == null ? "" : _pressure;
	}

	public String getSeaLevel() {
		return _sea_Level == "" || _sea_Level == null ? "" : _sea_Level;
	}

	public String getGroundLevel() {
		return _ground_Level == "" || _ground_Level == null ? ""
				: _ground_Level;
	}

	public String getHumidity() {
		return _humidity == "" || _humidity == null ? "" : _humidity;
	}

	public String getWindSpeed() {
		return _wind_Speed == "" || _wind_Speed == null ? "" : _wind_Speed;
	}

	public String getWindDirection() {
		return _wind_Direction == "" || _wind_Direction == null ? ""
				: _wind_Direction;
	}

	public String getCloudsPrercent() {
		return _clouds_Prercent == "" || _clouds_Prercent == null ? ""
				: _clouds_Prercent;
	}

	public String getWeatherDate() {
		return _weather_Date.toString() == "" || _weather_Date == null ? ""
				: _weather_Date.toString();
	}

	public String getWeatherLocationId() {
		return _weather_LocationId == "" || _weather_LocationId == null ? ""
				: _weather_LocationId;
	}

	public String getWeatherLocation() {
		return _weather_Location == "" || _weather_Location == null ? ""
				: _weather_Location;
	}

	public void setSunrise(String _sunrise) {
		this._sunrise = new Date(Long.valueOf(_sunrise) * 1000);
	}

	public void setSunset(String _sunset) {
		this._sunset = new Date(Long.valueOf(_sunset) * 1000);
	}

	public void setWeatherStateId(String _weatherStateId) {
		this._weather_StateId = _weatherStateId;
	}

	public void setWeatherDescription(String _weatherDescription) {
		this._weather_Description = _weatherDescription;
	}

	public void setWeatherTitleMain(String _weatherTitleMain) {
		this._weather_Title = _weatherTitleMain;
	}

	public void setAvarageTemperature(String _avgTemperature) {
		this._avg_Temperature = _avgTemperature;
	}

	public void setMinTemperature(String _minTemperature) {
		this._min_Temperature = _minTemperature;
	}

	public void setMaxTemperature(String _maxTemperature) {
		this._max_Temperature = _maxTemperature;
	}

	public void setPressure(String _pressure) {
		this._pressure = _pressure;
	}

	public void setSeaLevel(String _seaLevel) {
		this._sea_Level = _seaLevel;
	}

	public void setGroundLevel(String _groundLevel) {
		this._ground_Level = _groundLevel;
	}

	public void setHumidity(String _humidity) {
		this._humidity = _humidity;
	}

	public void setWindSpeed(String _windSpeed) {
		this._wind_Speed = _windSpeed;
	}

	public void setWindDirection(String _windDirection) {
		this._wind_Direction = _windDirection;
	}

	public void setCloudsPrercent(String _cloudsPrercent) {
		this._clouds_Prercent = _cloudsPrercent;
	}

	public void setWeatherDate(String _weatherDate) {
		this._weather_Date = new Date(Long.valueOf(_weatherDate) * 1000);
	}

	public void setWeatherLocationId(String _weatherLocationId) {
		this._weather_LocationId = _weatherLocationId;
	}

	public void setWeatherLocation(String _weatherLocation) {
		this._weather_Location = _weatherLocation;
	}
}
