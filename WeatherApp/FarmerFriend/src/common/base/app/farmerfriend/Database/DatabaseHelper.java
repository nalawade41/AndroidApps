package common.base.app.farmerfriend.Database;

import android.content.*;
import android.database.Cursor;
import android.database.sqlite.*;

public class DatabaseHelper extends SQLiteOpenHelper implements
		ITableDefination {

	public DatabaseHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		DatabaseExecuter.createTables(db);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// on upgrade drop older tables
		DatabaseExecuter.dropTables(db);
		// create new tables
		onCreate(db);
	}

	public long insertRecord(ContentValues values, String tableName) {
		return this.getWritableDatabase().insert(tableName, null, values);
	}

	public Cursor getRecordData(String sqlQuery, String tableName) {
		return  this.getReadableDatabase().rawQuery(sqlQuery, null);
	}

	public void updateRecord(ContentValues values,String tableName,String condition){
		this.getReadableDatabase().update(tableName, values, condition, null);
	} 
	
	public void FirstRunDeletion(Context context) {
		context.deleteDatabase(DATABASE_NAME);
	}
}
