package com.psl.entity;

public class Booking {

	long bookingID;
	long roomID;
	long trainingID;

	public Booking() {
		// TODO Auto-generated constructor stub
	}

	public Booking(long bookingID, long roomID, long trainingID) {
		super();
		this.bookingID = bookingID;
		this.roomID = roomID;
		this.trainingID = trainingID;
	}

	public long getBookingID() {
		return bookingID;
	}

	public void setBookingID(long bookingID) {
		this.bookingID = bookingID;
	}

	public long getRoomID() {
		return roomID;
	}

	public void setRoomID(long roomID) {
		this.roomID = roomID;
	}

	public long getTrainingID() {
		return trainingID;
	}

	public void setTrainingID(long trainingID) {
		this.trainingID = trainingID;
	}

	@Override
	public String toString() {
		return "Booking [bookingID=" + bookingID + ", roomID=" + roomID
				+ ", trainingID=" + trainingID + "]";
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
