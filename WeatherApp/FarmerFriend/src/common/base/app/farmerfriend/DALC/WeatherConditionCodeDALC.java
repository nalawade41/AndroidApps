package common.base.app.farmerfriend.DALC;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import android.content.ContentValues;
import android.database.Cursor;
import common.base.app.farmerfriend.Classes.DTO.*;

public class WeatherConditionCodeDALC {

	public static ContentValues createContentValuesToInsert(
			WeatherConditionCodeDTO rowData) {
		ContentValues values = new ContentValues();
		values.put("ConditionCode",
				((WeatherConditionCodeDTO) rowData).getConditionCode());
		values.put("Description",
				((WeatherConditionCodeDTO) rowData).getDescription());
		values.put("ImageName",
				((WeatherConditionCodeDTO) rowData).getImageName());
		values.put("DateAdded", ((WeatherConditionCodeDTO) rowData)
				.getDateAdded().toString());
		return values;
	}

	@SuppressWarnings("deprecation")
	public static List<Object> getAllData(Cursor reader) {
		List<Object> dataToReturn = new ArrayList<Object>();
		int conditionIDIndex = reader.getColumnIndex("ConditionID");
		int conditionCodeIndex = reader.getColumnIndex("ConditionCode");
		int descriptionIndex = reader.getColumnIndex("Description");
		int imageNameIndex = reader.getColumnIndex("ImageName");
		int dateAddedIndex = reader.getColumnIndex("DateAdded");
		do {
			WeatherConditionCodeDTO dataRow = new WeatherConditionCodeDTO();
			dataRow.setConditionID(reader.getInt(conditionIDIndex));
			dataRow.setConditionCode(reader.getString(conditionCodeIndex));
			dataRow.setDescription(reader.getString(descriptionIndex));
			dataRow.setImageName(reader.getString(imageNameIndex));
			dataRow.setDateAdded(new Date(reader.getString(dateAddedIndex)));
			dataToReturn.add(dataRow);
		} while (reader.moveToNext());
		return dataToReturn;
	}
}
