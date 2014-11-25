package common.base.app.farmerfriend.Classes.DTO;

import java.util.Date;

public class WeatherConditionCodeDTO implements IDatabaseModels{

	public int ConditionID;
	public String ConditionCode;
	public String Description;
	public String ImageName;
	public Date DateAdded;

	public WeatherConditionCodeDTO() {

	}

	public int getConditionID() {
		return ConditionID;
	}

	public String getConditionCode() {
		return ConditionCode;
	}

	public String getDescription() {
		return Description;
	}

	public String getImageName() {
		return ImageName;
	}

	public Date getDateAdded() {
		return DateAdded;
	}

	public void setConditionID(int conditionID) {
		ConditionID = conditionID;
	}

	public void setConditionCode(String conditionCode) {
		ConditionCode = conditionCode;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public void setImageName(String imageName) {
		ImageName = imageName;
	}

	public void setDateAdded(Date dateAdded) {
		DateAdded = dateAdded;
	}

}
