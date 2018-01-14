package com.psl.entity;

import java.util.Date;

public class Training {
	long trainingID;
	long employeeID;
	Date startDate;
	Date endDate;
	String trainingType;
	Date startTime;
	Date endTime;
	long roomID;
public Training() {
	// TODO Auto-generated constructor stub
}

	public long getTrainingID() {
	return trainingID;
}

	
	
public Training(long trainingID, long employeeID, Date startDate,
			Date endDate, String trainingType, Date startTime, Date endTime,
			long roomID) {
		super();
		this.trainingID = trainingID;
		this.employeeID = employeeID;
		this.startDate = startDate;
		this.endDate = endDate;
		this.trainingType = trainingType;
		this.startTime = startTime;
		this.endTime = endTime;
		this.roomID = roomID;
	}

public void setTrainingID(long trainingID) {
	this.trainingID = trainingID;
}

public long getEmployeeID() {
	return employeeID;
}

public void setEmployeeID(long employeeID) {
	this.employeeID = employeeID;
}

public Date getStartDate() {
	return startDate;
}

public void setStartDate(Date startDate) {
	this.startDate = startDate;
}

public Date getEndDate() {
	return endDate;
}

public void setEndDate(Date endDate) {
	this.endDate = endDate;
}

public String getTrainingType() {
	return trainingType;
}

public void setTrainingType(String trainingType) {
	this.trainingType = trainingType;
}

public Date getStartTime() {
	return startTime;
}

public void setStartTime(Date startTime) {
	this.startTime = startTime;
}

public Date getEndTime() {
	return endTime;
}

public void setEndTime(Date endTime) {
	this.endTime = endTime;
}

public long getRoomID() {
	return roomID;
}

public void setRoomID(long roomID) {
	this.roomID = roomID;
}

	@Override
public String toString() {
	return "Training [trainingID=" + trainingID + ", employeeID=" + employeeID
			+ ", startDate=" + startDate + ", endDate=" + endDate
			+ ", trainingType=" + trainingType + ", startTime=" + startTime
			+ ", endTime=" + endTime + ", roomID=" + roomID + "]";
}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
