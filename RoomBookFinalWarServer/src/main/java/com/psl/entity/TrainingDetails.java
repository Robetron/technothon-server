package com.psl.entity;

import java.util.Date;

public class TrainingDetails {

	private long trainingID;
	private long employeeID;
	private long roomID;
	private Date startDate;
	private Date endDate;
	private String trainingType;
	private String startTime;
	private String endTime;
	private String ownerName;
	public String getTrainingName() {
		return trainingName;
	}


	public void setTrainingName(String trainingName) {
		this.trainingName = trainingName;
	}

	private String trainingName;
	
	public TrainingDetails() {
		// TODO Auto-generated constructor stub
	}

	
	public long getTrainingID() {
		return trainingID;
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

	public long getRoomID() {
		return roomID;
	}

	public void setRoomID(long roomID) {
		this.roomID = roomID;
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

	

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}


	@Override
	public String toString() {
		return "TrainingDetails [trainingID=" + trainingID + ", employeeID="
				+ employeeID + ", roomID=" + roomID + ", startDate="
				+ startDate + ", endDate=" + endDate + ", trainingType="
				+ trainingType + ", startTime=" + startTime + ", endTime="
				+ endTime + ", ownerName=" + ownerName + "]";
	}

	

	public TrainingDetails(long trainingID, long employeeID, long roomID,
			Date startDate, Date endDate, String trainingType,
			String startTime, String endTime, String ownerName, String trainingName) {
		super();
		this.trainingID = trainingID;
		this.employeeID = employeeID;
		this.roomID = roomID;
		this.startDate = startDate;
		this.endDate = endDate;
		this.trainingType = trainingType;
		this.startTime = startTime;
		this.endTime = endTime;
		this.ownerName = ownerName;
		this.trainingName=trainingName;
	}


	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	
	
}
