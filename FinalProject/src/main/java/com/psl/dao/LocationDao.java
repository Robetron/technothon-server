package com.psl.dao;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import com.psl.entity.*;
import com.psl.util.HibernateUtility;

public class LocationDao {

	public List<Location> getLocationList() {
		Session session = HibernateUtility.getSesssion();

		Query query = session.createQuery("from Location");
		List<Location> list = query.list();
		for (Location location : list) {
			System.out.println(location.getLocationId() + "\t"
					+ location.getLocationName());
		}

		return list;
	}

	public boolean addLocation(Location location) {
		Session session = HibernateUtility.getSesssion();
		Query query = session.createQuery("from Location");
		List<Location> list = query.list();
		System.out.println("Size:" + list.size());
		if (list.size() == 0) {
			session.save(location);
			session.beginTransaction().commit();
			return true;
		} else {
			/* System.out.println("Add Location"+location.getLocationName()) */;
			for (Location l : list) {
				if (l.getLocationName().equalsIgnoreCase(
						location.getLocationName())) {
					System.out.println("Already exists");
					return false;
				} else {
					session.save(location);
					session.beginTransaction().commit();
				}
			}
			return true;
		}
	}
/*
	public static void main(String[] args) {
		LocationDao ld = new LocationDao();
		List<Location> list = ld.getLocationList();
		System.out.println(list);
		Location l = new Location(101, "PT");

		ld.addLocation(l);
	}*/

}
