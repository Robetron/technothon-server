package com.psl.entity;

import java.util.Date;

public class Status {
	long statusID;
	String trainingID;
	

	public String getTrainingID() {
		return trainingID;
	}


	public void setTrainingID(String trainingID) {
		this.trainingID = trainingID;
	}


	public long getStatusID() {
		return statusID;
	}


	public void setStatusID(long statusID) {
		this.statusID = statusID;
	}


	long roomID;	
	Date	date;
	long	status;	
public Status() {
	// TODO Auto-generated constructor stub
}


	public Status(long roomID, Date date, long status) {
	super();
	this.roomID = roomID;
	this.date = date;
	this.status = status;
}


	public long getRoomID() {
		return roomID;
	}


	public void setRoomID(long roomID) {
		this.roomID = roomID;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public long getStatus() {
		return status;
	}


	public void setStatus(long status) {
		this.status = status;
	}


	@Override
	public String toString() {
		return "Status [statusID=" + statusID + ", roomID=" + roomID
				+ ", date=" + date + ", status=" + status +"trainingid"+ trainingID+"]";
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}


	public Status(long statusID, long roomID, Date date, long status) {
		super();
		this.statusID = statusID;
		this.roomID = roomID;
		this.date = date;
		this.status = status;
	}

}
