package com.psl.entity;

public class Room {

	private long roomID;
	private String roomName;
	private String roomType;
	private long capacity;
	private String location;
	
	public Room() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Room [roomID=" + roomID + ", roomName=" + roomName
				+ ", roomType=" + roomType + ", capacity=" + capacity
				+ ", location=" + location + "]";
	}
	
	

	public long getRoomID() {
		return roomID;
	}

	public void setRoomID(long roomID) {
		this.roomID = roomID;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public long getCapacity() {
		return capacity;
	}

	public void setCapacity(long capacity) {
		this.capacity = capacity;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Room(long roomID, String roomName, String roomType, long capacity,
			String location) {
		super();
		this.roomID = roomID;
		this.roomName = roomName;
		this.roomType = roomType;
		this.capacity = capacity;
		this.location = location;
	}
	
	
}
