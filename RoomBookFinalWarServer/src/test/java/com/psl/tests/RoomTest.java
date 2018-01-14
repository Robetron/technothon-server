package com.psl.tests;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import junit.framework.TestCase;

import org.junit.BeforeClass;
import org.junit.Test;

import com.psl.dao.RoomDao;
import com.psl.entity.Room;

public class RoomTest extends TestCase {
	private static RoomDao roomDao = null;
	private static Room room1 = null;

	@BeforeClass
	public void setUp() {
		roomDao = mock(RoomDao.class);
		room1 = new Room(11, "Topaz", "LAb", 20, "HJ");
		// when(mockRoomDao.insertRoomDetails(room1)).thenReturn(true);
		when(roomDao.getRoomByLocation("HJ")).thenReturn(
				Arrays.asList(room1));
		when(roomDao.getRoomByLocationByType("HJ", "Lab")).thenReturn(
				Arrays.asList(room1));

	}

	@Test
	public void testGetRoomByLocation() {
		RoomDao roomDao = mock(RoomDao.class);
		assertNotNull(roomDao.getRoomByLocation("HJ"));
		assertNotNull(roomDao.getRoomByLocationByType("HJ", "Lab"));

	}
}