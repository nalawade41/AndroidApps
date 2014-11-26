package common.base.app.farmerfriend.DALC;

import java.util.*;
import common.base.app.farmerfriend.Classes.DTO.LocationDTO;
import android.content.ContentValues;
import android.database.Cursor;

public class LocationDALC implements IDatabaseDALC {

	public static ContentValues createContentValuesToInsert(LocationDTO rowData) {
		ContentValues values = new ContentValues();
		values.put("LocationName", ((LocationDTO) rowData).getLocationName());
		values.put("LocationLatitude",
				((LocationDTO) rowData).getLocationLatitude());
		values.put("LocationLongitude",
				((LocationDTO) rowData).getLocationLongitude());
		values.put("LocationTypeID",
				((LocationDTO) rowData).getLocationTypeID());
		values.put("WeatherLocationID",
				((LocationDTO) rowData).getWeatherLocationID());
		values.put("GeoNameID", ((LocationDTO) rowData).getGeoNameID());
		values.put("DateAdded", ((LocationDTO) rowData).getDateAdded()
				.toString());
		return values;
	}

	@SuppressWarnings("deprecation")
	public static List<Object> getAllData(Cursor reader) {
		List<Object> dataToReturn = new ArrayList<Object>();
		int locationIDIndex = reader.getColumnIndex("LocationID");
		int locationLatiIndex = reader.getColumnIndex("LocationLatitude");
		int locationNameIndex = reader.getColumnIndex("LocationName");
		int locationLongiIndex = reader.getColumnIndex("LocationLongitude");
		int locationTypeIndex = reader.getColumnIndex("LocationTypeID");
		int dateAddedIndex = reader.getColumnIndex("DateAdded");
		int geoNameIDIndex = reader.getColumnIndex("GeoNameID");
		int weatherLocationID = reader.getColumnIndex("WeatherLocationID");
		do {
			LocationDTO dataRow = new LocationDTO();
			dataRow.setLocationID(reader.getInt(locationIDIndex));
			dataRow.setDateAdded(new Date(reader.getString(dateAddedIndex)));
			dataRow.setLocationLatitude(reader.getDouble(locationLatiIndex));
			dataRow.setLocationLongitude(reader.getDouble(locationLongiIndex));
			dataRow.setLocationName(reader.getString(locationNameIndex));
			dataRow.setLocationTypeID(reader.getInt(locationTypeIndex));
			dataRow.setGeoNameID(reader.getString(geoNameIDIndex));
			dataRow.setWeatherLocationID(reader.getString(weatherLocationID));
			dataToReturn.add(dataRow);
		} while (reader.moveToNext());
		return dataToReturn;
	}

	public static ContentValues updateLocationForWeatherDetailsID(String valueToUpdate) {
		ContentValues values = new ContentValues();
		values.put("WeatherLocationID", valueToUpdate);
		return values;
	}
}
