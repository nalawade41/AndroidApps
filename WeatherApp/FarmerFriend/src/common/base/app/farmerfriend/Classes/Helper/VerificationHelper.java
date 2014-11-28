package common.base.app.farmerfriend.Classes.Helper;

import java.util.Date;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class VerificationHelper {

	public static Boolean IsFetchLocationSucces = true;

	public static Boolean IsNetworkConnected(Context context) {
		ConnectivityManager manager = (ConnectivityManager) context
				.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo[] networks = manager.getAllNetworkInfo();
		for (NetworkInfo network : networks) {
			if (network.getTypeName().equalsIgnoreCase("WIFI")) {
				if (network.isConnected() && network.isAvailable()
						&& network.isConnectedOrConnecting()) {
					return true;
				}
			}
			if (network.getTypeName().equalsIgnoreCase("MOBILE")) {
				if (network.isConnected() && network.isAvailable()
						&& network.isConnectedOrConnecting()) {
					return true;
				}
			}
		}
		return false;
	}

	public static Boolean IsLocationFetchSuccess() {
		return IsFetchLocationSucces;
	}

	public static Boolean IsWeatherDetailsAvailable(String location,
			Context context) {
		if (WeatherDatabaseHandler.GetAvailableWeatherDetails(new Date(),
				location, context).size() > 0) {
			return true;
		}
		return false;
	}
}
