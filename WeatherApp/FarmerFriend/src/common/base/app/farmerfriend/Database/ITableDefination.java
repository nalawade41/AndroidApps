package common.base.app.farmerfriend.Database;

public interface ITableDefination {

	// Database Version
	public static final int DATABASE_VERSION = 1;
	// Database Name
	public static final String DATABASE_NAME = "myFarmDatabase";

	// Table Names
	public static final String TABLE_LOCATIONS = "Locations";
	public static final String TABLE_LOCATIONTYPES = "LocationTypes";
	public static final String TABLE_WEATHER_DETAILS = "WeatherDetails";
	public static final String TABLE_WEATHEER_TYPE = "WeatherType";
	public static final String TABLE_WEATHER_CONDITION_CODES = "WeatherConditons";
	// Repeated columns
	public static final String PRIMARY_KEY = "ID";
	public static final String ADDED_TIME_KEY = "DateAdded";

	public static final String CREATE_TABLE_LOCATIONS = "CREATE TABLE "
			+ TABLE_LOCATIONS + "(" + " Location" + PRIMARY_KEY
			+ " INTEGER PRIMARY KEY," + " LocationName TEXT,"
			+ " LocationLatitude REAL," + " LocationLongitude REAL,"
			+ " GeoNameID TEXT," + " LocationTypeID INTEGER,"
			+ " WeatherLocationID TEXT, " + ADDED_TIME_KEY + " DATETIME" + ")";

	public static final String CREATE_TABLE_LOCATION_TYPE = "CREATE TABLE "
			+ TABLE_LOCATIONTYPES + "(" + "LocationType" + PRIMARY_KEY
			+ " INTEGER PRIMARY KEY," + " LocationType TEXT," + ADDED_TIME_KEY
			+ " DATETIME" + ")";

	public static final String CREATE_TABLE_WEATHER_DETAILS = "CREATE TABLE "
			+ TABLE_WEATHER_DETAILS + "(" + "WeatherDetails" + PRIMARY_KEY
			+ " INTEGER PRIMARY KEY," + " LocationName TEXT,"
			+ " WeatherLocationID TEXT," + " WeatherDate DATETIME,"
			+ " Sunrise DATETIME," + " Sunset DATETIME," + " Temperature REAL,"
			+ " MinTemperature REAL," + " MaxTemperature REAL,"
			+ " Humidity REAL," + " Pressure REAL," + " PressureGround REAL,"
			+ " PressureSea REAL," + " ConditionCode TEXT,"
			+ " WindSpeed REAL," + " WindDegree REAL," + " Clouds TEXT,"
			+ " WeatherDateFrom DATETIME," + " WeatherDateTo DATETIME,"
			+ " IsValidData INTEGER," + " WeatherTypeID INTEGER,"
			+ ADDED_TIME_KEY + " DATETIME" + ")";

	public static final String CREATE_TABLE_WEATHEER_TYPE = "CREATE TABLE "
			+ TABLE_WEATHEER_TYPE + "(" + "WeatherType" + PRIMARY_KEY
			+ " INTEGER PRIMARY KEY," + " WeatherType TEXT," + ADDED_TIME_KEY
			+ " DATETIME" + ")";

	public static final String CREATE_TABLE_WEATHER_CONDITION_CODES = "CREATE TABLE "
			+ TABLE_WEATHER_CONDITION_CODES
			+ "("
			+ "Condition"
			+ PRIMARY_KEY
			+ " INTEGER PRIMARY KEY,"
			+ " ConditionCode TEXT,"
			+ " Description TEXT,"
			+ " ImageName TEXT,"
			+ ADDED_TIME_KEY
			+ " DATETIME" + ")";

}
