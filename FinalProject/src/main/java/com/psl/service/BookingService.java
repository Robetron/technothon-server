package com.psl.service;

import java.util.List;

import com.psl.dao.BookingDao;
import com.psl.entity.Booking;

public class BookingService {
	private BookingDao dao;

	public BookingService() {
		super();
		this.dao = new BookingDao();
	}
	
	public BookingDao getDao() {
		return dao;
	}

	public void setDao(BookingDao dao) {
		this.dao = dao;
	}
	public void addBooking(Booking booking) {
		this.dao.addBooking(booking);
	}

	public List<Long> getTrainingIDList(long roomID) {
		return this.dao.getTrainingIDList(roomID);
	}
}
