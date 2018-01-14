package com.psl.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.psl.entity.Booking;
import com.psl.util.HibernateUtility;

public class BookingDao {

	public void addBooking(Booking booking) {
		Session session = HibernateUtility.getSesssion();
		session.save(booking);
		session.beginTransaction().commit();
	}

	public List<Long> getTrainingIDList(long roomID) {
		List<Long> trainigList = new ArrayList<Long>();
		Session session = HibernateUtility.getSesssion();
		Query query = session
				.createQuery("from Booking b WHERE b.roomID = :room_id");
		query.setParameter("room_id", roomID);
		List<Booking> list = query.list();
		for (Booking b : list) {
			trainigList.add(b.getTrainingID());
		}
		System.out.println(list + "\n" + trainigList);
		return trainigList;
	}

	public static void main(String op[]) {

	}
}
