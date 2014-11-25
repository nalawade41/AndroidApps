package common.base.app.farmerfriend.Classes.DTO;

import java.util.Date;
import common.base.app.farmerfriend.Classes.Result.*;

public class LocationTypeDTO implements IDatabaseModels {

	public int LocationTypeID;
	public String LocationType;
	public Date DateAdded;

	public LocationTypeDTO() {
	
	}

	public LocationTypeDTO(GeonameResult result) {
		this.LocationTypeID = -1;
		this.LocationType = result.LocationType;
		this.DateAdded = new Date();
	}

	public int getLocationTypeID() {
		return LocationTypeID;
	}

	public String getLocationType() {
		return LocationType;
	}

	public Date getDateAdded() {
		return DateAdded;
	}

	public void setLocationTypeID(int locationTypeID) {
		LocationTypeID = locationTypeID;
	}

	public void setLocationType(String locationType) {
		LocationType = locationType;
	}

	public void setDateAdded(Date dateAdded) {
		DateAdded = dateAdded;
	}
}
