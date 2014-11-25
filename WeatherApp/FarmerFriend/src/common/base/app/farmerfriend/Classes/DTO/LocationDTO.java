package common.base.app.farmerfriend.Classes.DTO;

import java.util.Date;

import common.base.app.farmerfriend.Classes.Result.*;

public class LocationDTO implements IDatabaseModels {

	public int LocationID;
	public String LocationName;
	public double LocationLatitude;
	public double LocationLongitude;
	public String GeoNameID;
	public int LocationTypeID;
	public String WeatherLocationID;
	public Date DateAdded;

	public LocationDTO() {
	}

	public LocationDTO(GeonameResult result) {
		this.LocationName = result.LocationName;
		this.LocationLatitude = Double.valueOf(result.Latitude);
		this.LocationLongitude = Double.valueOf(result.Longitude);
		this.GeoNameID = result.GeonameID;
		this.WeatherLocationID = "";
		this.DateAdded = new Date();
	}

	public int getLocationID() {
		return LocationID;
	}

	public String getLocationName() {
		return LocationName;
	}

	public double getLocationLatitude() {
		return LocationLatitude;
	}

	public double getLocationLongitude() {
		return LocationLongitude;
	}

	public String getGeoNameID() {
		return GeoNameID;
	}

	public int getLocationTypeID() {
		return LocationTypeID;
	}

	public String getWeatherLocationID() {
		return WeatherLocationID;
	}

	public Date getDateAdded() {
		return DateAdded;
	}

	public void setLocationID(int locationID) {
		LocationID = locationID;
	}

	public void setLocationName(String locationName) {
		LocationName = locationName;
	}

	public void setLocationLatitude(double locationLatitude) {
		LocationLatitude = locationLatitude;
	}

	public void setLocationLongitude(double locationLongitude) {
		LocationLongitude = locationLongitude;
	}

	public void setGeoNameID(String geoNameID) {
		GeoNameID = geoNameID;
	}

	public void setLocationTypeID(int locationTypeID) {
		LocationTypeID = locationTypeID;
	}

	public void setWeatherLocationID(String weatherLocationID) {
		WeatherLocationID = weatherLocationID;
	}

	public void setDateAdded(Date dateAdded) {
		DateAdded = dateAdded;
	}
}
