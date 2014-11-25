package common.base.app.farmerfriend.Classes.DTO;

import java.util.Date;

public class WeatherDetailsDTO implements IDatabaseModels {

	public int WeatherDetailsID;
	public String LocationName;
	public String WeatherLocationID;
	public Date WeatherDate;
	public Date Sunrise;
	public Date Sunset;
	public double Temperature;
	public double MinTemperature;
	public double MaxTemperature;
	public double Humidity;
	public double Pressure;
	public double PressureGround;
	public double PressureSea;
	public String ConditionCode;
	public double WindSpeed;
	public double WindDegree;
	public String Clouds;
	public Date WeatherDateFrom;
	public Date WeatherDateTo;
	public int IsValidData;
	public Date DateAdded;

	public WeatherDetailsDTO() {

	}

	public int getWeatherDetailsID() {
		return WeatherDetailsID;
	}

	public String getLocationName() {
		return LocationName;
	}

	public String getWeatherLocationID() {
		return WeatherLocationID;
	}

	public Date getWeatherDate() {
		return WeatherDate;
	}

	public Date getSunrise() {
		return Sunrise;
	}

	public Date getSunset() {
		return Sunset;
	}

	public double getTemperature() {
		return Temperature;
	}

	public double getMinTemperature() {
		return MinTemperature;
	}

	public double getMaxTemperature() {
		return MaxTemperature;
	}

	public double getHumidity() {
		return Humidity;
	}

	public double getPressure() {
		return Pressure;
	}

	public double getPressureGround() {
		return PressureGround;
	}

	public double getPressureSea() {
		return PressureSea;
	}

	public String getConditionCode() {
		return ConditionCode;
	}

	public double getWindSpeed() {
		return WindSpeed;
	}

	public double getWindDegree() {
		return WindDegree;
	}

	public String getClouds() {
		return Clouds;
	}

	public Date getWeatherDateFrom() {
		return WeatherDateFrom;
	}

	public Date getWeatherDateTo() {
		return WeatherDateTo;
	}

	public int getIsValidData() {
		return IsValidData;
	}

	public Date getDateAdded() {
		return DateAdded;
	}

	public void setWeatherDetailsID(int weatherDetailsID) {
		WeatherDetailsID = weatherDetailsID;
	}

	public void setLocationName(String locationName) {
		LocationName = locationName;
	}

	public void setWeatherLocationID(String weatherLocationID) {
		WeatherLocationID = weatherLocationID;
	}

	public void setWeatherDate(Date weatherDate) {
		WeatherDate = weatherDate;
	}

	public void setSunrise(Date sunrise) {
		Sunrise = sunrise;
	}

	public void setSunset(Date sunset) {
		Sunset = sunset;
	}

	public void setTemperature(double temperature) {
		Temperature = temperature;
	}

	public void setMinTemperature(double minTemperature) {
		MinTemperature = minTemperature;
	}

	public void setMaxTemperature(double maxTemperature) {
		MaxTemperature = maxTemperature;
	}

	public void setHumidity(double humidity) {
		Humidity = humidity;
	}

	public void setPressure(double pressure) {
		Pressure = pressure;
	}

	public void setPressureGround(double pressureGround) {
		PressureGround = pressureGround;
	}

	public void setPressureSea(double pressureSea) {
		PressureSea = pressureSea;
	}

	public void setConditionCode(String conditionCode) {
		ConditionCode = conditionCode;
	}

	public void setWindSpeed(double windSpeed) {
		WindSpeed = windSpeed;
	}

	public void setWindDegree(double windDegree) {
		WindDegree = windDegree;
	}

	public void setClouds(String clouds) {
		Clouds = clouds;
	}

	public void setWeatherDateFrom(Date weatherDateFrom) {
		WeatherDateFrom = weatherDateFrom;
	}

	public void setWeatherDateTo(Date weatherDateTo) {
		WeatherDateTo = weatherDateTo;
	}

	public void setIsValidData(int isValidData) {
		IsValidData = isValidData;
	}

	public void setDateAdded(Date dateAdded) {
		DateAdded = dateAdded;
	}
}
