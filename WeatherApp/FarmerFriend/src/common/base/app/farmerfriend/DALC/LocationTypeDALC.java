package common.base.app.farmerfriend.DALC;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import android.content.ContentValues;
import android.database.Cursor;
import common.base.app.farmerfriend.Classes.DTO.*;

public class LocationTypeDALC implements IDatabaseDALC {
	
	public static ContentValues createContentValuesToInsert(
			LocationTypeDTO rowData) {
		ContentValues values = new ContentValues();
		values.put("LocationType",
				((LocationTypeDTO) rowData).getLocationType());
		values.put("DateAdded", ((LocationTypeDTO) rowData).getDateAdded()
				.toString());
		return values;
	}
	
	@SuppressWarnings("deprecation")
	public static List<Object> getAllData(Cursor reader) {
		List<Object> dataToReturn = new ArrayList<Object>();
		int locationTypeIndex = reader.getColumnIndex("LocationType");
		int locationTypeIDIndex = reader.getColumnIndex("LocationTypeID");
		int dateAddedIndex = reader.getColumnIndex("DateAdded");
		do {
			LocationTypeDTO dataRow = new LocationTypeDTO();
			dataRow.setLocationTypeID(reader.getInt(locationTypeIDIndex));
			dataRow.setDateAdded(new Date(reader.getString(dateAddedIndex)));
			dataRow.setLocationType(reader.getString(locationTypeIndex));
			dataToReturn.add(dataRow);
		} while (reader.moveToNext());
		return dataToReturn;
	}
}
