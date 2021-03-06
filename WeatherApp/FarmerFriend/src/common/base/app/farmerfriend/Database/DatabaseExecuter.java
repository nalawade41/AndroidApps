package common.base.app.farmerfriend.Database;

import java.util.*;

import common.base.app.farmerfriend.Classes.DTO.*;
import common.base.app.farmerfriend.Classes.Result.CurrentWeatherResult;
import common.base.app.farmerfriend.DALC.*;
import android.content.*;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.UrlQuerySanitizer.ValueSanitizer;

public class DatabaseExecuter implements ITableDefination {

	private DatabaseHelper _dataBaseHelper ;
	
	public DatabaseExecuter (Context context){
		_dataBaseHelper = new DatabaseHelper(context);
	}
	
	public static void createTables(SQLiteDatabase db) {
		db.execSQL(CREATE_TABLE_LOCATIONS);
		db.execSQL(CREATE_TABLE_LOCATION_TYPE);
		db.execSQL(CREATE_TABLE_WEATHER_DETAILS);
		db.execSQL(CREATE_TABLE_WEATHEER_TYPE);
		db.execSQL(CREATE_TABLE_WEATHER_CONDITION_CODES);
	}

	public static void dropTables(SQLiteDatabase db) {
		db.execSQL("DROP TABLE IF EXISTS " + CREATE_TABLE_LOCATIONS);
		db.execSQL("DROP TABLE IF EXISTS " + CREATE_TABLE_LOCATION_TYPE);
		db.execSQL("DROP TABLE IF EXISTS " + CREATE_TABLE_WEATHER_DETAILS);
		db.execSQL("DROP TABLE IF EXISTS " + CREATE_TABLE_WEATHEER_TYPE);
		db.execSQL("DROP TABLE IF EXISTS "
				+ CREATE_TABLE_WEATHER_CONDITION_CODES);
	}

	public long insertTableData(IDatabaseModels rowData, String tableName) {
		if (rowData != null) {
			ContentValues values = new ContentValues();
			if (rowData instanceof LocationDTO) {
				values =  LocationDALC.createContentValuesToInsert((LocationDTO)rowData);
			} else if (rowData instanceof LocationTypeDTO) {
				values =  LocationTypeDALC.createContentValuesToInsert((LocationTypeDTO)rowData);
			} else if (rowData instanceof CurrentWeatherResult) {
				values =  WeatherDetailsDALC.createContentValuesToInsert((CurrentWeatherResult)rowData);
			}else if (rowData instanceof WeatherTypeDTO) {
				values =  WeatherTypeDALC.createContentValuesToInsert((WeatherTypeDTO)rowData);
			}else if (rowData instanceof WeatherConditionCodeDTO) {
				values =  WeatherConditionCodeDALC.createContentValuesToInsert((WeatherConditionCodeDTO)rowData);
			}
			return _dataBaseHelper.insertRecord(values, tableName);
		}
		return -1;
	}

	public List<Object> getTableData(String sqlQuery, String tableName){
		Cursor reader = _dataBaseHelper.getRecordData(sqlQuery, tableName);
		List<Object> dataToReturn = null;
		if(reader!= null && reader.moveToFirst()){
			if (tableName.equals(TABLE_LOCATIONS)) {
				dataToReturn = LocationDALC.getAllData(reader);
			}
			if (tableName.equals(TABLE_LOCATIONTYPES)) {
				dataToReturn = LocationTypeDALC.getAllData(reader);
			}
			if (tableName.equals(TABLE_WEATHER_DETAILS)) {
				dataToReturn = WeatherDetailsDALC.getAllData(reader);
			}
			if (tableName.equals(TABLE_WEATHEER_TYPE)) {
				dataToReturn = WeatherTypeDALC.getAllData(reader);
			}
			if (tableName.equals(TABLE_WEATHER_CONDITION_CODES)) {
				dataToReturn = WeatherConditionCodeDALC.getAllData(reader);
			}
		}
		return dataToReturn;
	}

	public  void updateLocationForWeatherLocationID(String valueToUpdate,String conditionValue){
		ContentValues value = LocationDALC.updateLocationForWeatherDetailsID(valueToUpdate);
		_dataBaseHelper.updateRecord(value, TABLE_LOCATIONS, conditionValue);
	} 
}
