package com.psl.service;

import java.util.List;
import com.psl.dao.RoomDao;
import com.psl.entity.Room;

public class RoomService {
	private RoomDao dao;

	public RoomDao getDao() {
		return dao;
	}

	public void setDao(RoomDao dao) {
		this.dao = dao;
	}

	public RoomService() {
		super();
		this.dao = new RoomDao();
	}
	public boolean insertRoomDetails(Room room){
		return this.dao.insertRoomDetails(room);
	}
	
	public List<Room> getRoomByLocation(String loc){
		return this.dao.getRoomByLocation(loc);
		
	}
	public List<Room> getRoomByLocationByType(String loc,String roomType){
		return this.dao.getRoomByLocationByType(loc, roomType);
	}
}
