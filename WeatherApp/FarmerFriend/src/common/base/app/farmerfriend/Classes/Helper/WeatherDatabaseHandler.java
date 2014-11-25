package common.base.app.farmerfriend.Classes.Helper;

import java.util.*;
import common.base.app.farmerfriend.Classes.DTO.*;
import common.base.app.farmerfriend.Database.*;
import android.content.Context;

public class WeatherDatabaseHandler {

	public static DatabaseExecuter dbExecuter;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static String[] GetCityListToBind(Context context) {
		dbExecuter = new DatabaseExecuter(context);
		String query = "SELECT * FROM " + DatabaseHelper.TABLE_LOCATIONS;
		WeatherSharedDataHolder.LocationList = (List<LocationDTO>) (List) dbExecuter
				.getTableData(query, DatabaseHelper.TABLE_LOCATIONS);
		if (WeatherSharedDataHolder.LocationList != null) {
			List<String> allCityList = new ArrayList<String>();
			for (LocationDTO locationToAdd : WeatherSharedDataHolder.LocationList) {
				allCityList.add(locationToAdd.getLocationName());
			}
			return allCityList.toArray(new String[0]);
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public static HashMap<String, Integer> GetAvailableLocationTypes(
			Context context) {
		dbExecuter = new DatabaseExecuter(context);
		String query = "SELECT * FROM " + DatabaseHelper.TABLE_LOCATIONTYPES;
		@SuppressWarnings("rawtypes")
		List<LocationTypeDTO> allTypes = (List<LocationTypeDTO>) (List) dbExecuter
				.getTableData(query, DatabaseHelper.TABLE_LOCATIONTYPES);
		if (allTypes != null) {
			HashMap<String, Integer> allLocationTypes = new HashMap<String, Integer>();
			for (LocationTypeDTO locationTypeToAdd : allTypes) {
				allLocationTypes.put(locationTypeToAdd.getLocationType(),
						locationTypeToAdd.getLocationTypeID());
			}
			return allLocationTypes;
		}
		return null;
	}
}
