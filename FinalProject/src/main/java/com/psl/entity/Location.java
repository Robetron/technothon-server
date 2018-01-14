package com.psl.entity;

public class Location {
	long locationID;
	String locationName;

	public long getLocationId() {
		return locationID;
	}

	public void setLocationId(long locationId) {
		this.locationID = locationId;
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public Location(long locationId, String locationName) {
		super();
		this.locationID = locationId;
		this.locationName = locationName;
	}

	public Location() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public String toString() {
		return "Location [locationID=" + locationID + ", locationName="
				+ locationName + "]";
	}

}
