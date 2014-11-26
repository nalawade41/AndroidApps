package common.base.app.farmerfriend.Classes.Parser;

import java.io.*;
import java.util.*;
import android.annotation.SuppressLint;
import android.util.*;
import common.base.app.farmerfriend.Classes.Result.*;

public class GeoNameParser implements IJsonParser {

	@Override
	public List<IWebResult> readJsonStream(InputStream in) throws IOException {
		JsonReader reader = new JsonReader(new InputStreamReader(in, Encoding));
		try {
			List<IWebResult> data =readMessagesArray(reader);
			return data;
		} catch (Exception e) {
			Log.e("error", e.getMessage());
			throw new IOException();
		} finally {
			reader.close();
		}
	}

	private List<IWebResult> readMessagesArray(JsonReader reader)
			throws IOException {
		List<IWebResult> messages = new ArrayList<IWebResult>();
		reader.beginObject();
		// Skip the count of return array
		reader.nextName();
		reader.nextString();
		reader.nextName();

		reader.beginArray();
		while (reader.hasNext()) {
			messages.add(readMessage(reader));
		}
		reader.endArray();
		return messages;
	}

	@SuppressLint("NewApi")
	private GeonameResult readMessage(JsonReader reader) throws IOException {
		GeonameResult result = new GeonameResult();
		reader.beginObject();
		while (reader.hasNext()) {
			String name = reader.nextName();
			if (name.equals("lng")) {
				result.Longitude = reader.nextString();
			} else if (name.equals("lat")) {
				result.Latitude = reader.nextString();
			} else if (name.equals("geonameId")) {
				result.GeonameID = String.valueOf(reader.nextLong());
			} else if (name.equals("name")) {
				String value = reader.nextString();
				value = value.replace("Division", "").replace("District", "");
				result.LocationName = value.trim();
			} else if (name.equals("fcodeName")) {
				String valueOfLocationType = reader.nextString();
				result.LocationType = valueOfLocationType
						.contains("first-order") ? "State"
						: (valueOfLocationType.contains("second-order") ? "District"
								: "Locale");
			} else {
				reader.skipValue();
			}
		}
		reader.endObject();
		return result;
	}

}
