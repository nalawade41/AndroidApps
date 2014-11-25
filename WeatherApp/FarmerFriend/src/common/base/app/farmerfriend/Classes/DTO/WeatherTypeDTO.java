package common.base.app.farmerfriend.Classes.DTO;

import java.util.Date;

public class WeatherTypeDTO implements IDatabaseModels {

	public int WeatherTypeID;
	public String WeatherType;
	public Date DateAdded;

	public WeatherTypeDTO() {

	}

	public int getWeatherTypeID() {
		return WeatherTypeID;
	}

	public String getWeatherType() {
		return WeatherType;
	}

	public Date getDateAdded() {
		return DateAdded;
	}

	public void setWeatherTypeID(int weatherTypeID) {
		WeatherTypeID = weatherTypeID;
	}

	public void setWeatherType(String weatherType) {
		WeatherType = weatherType;
	}

	public void setDateAdded(Date dateAdded) {
		DateAdded = dateAdded;
	}

}
