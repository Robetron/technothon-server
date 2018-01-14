package com.psl.service;

import java.util.List;
import com.psl.dao.LocationDao;
import com.psl.entity.Location;

public class LocationService {
	private LocationDao dao;
	
	public LocationService() {
		super();
		dao = new LocationDao();
	}

	public LocationDao getDao() {
		return dao;
	}

	public void setDao(LocationDao dao) {
		this.dao = dao;
	}

	public List<Location> getLocationList() {
		return this.dao.getLocationList();
	}

	public boolean addLocation(Location location) {
		return this.dao.addLocation(location);
	}
}
