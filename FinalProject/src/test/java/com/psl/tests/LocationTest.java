package com.psl.tests;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import java.util.Arrays;
import java.util.List;
import junit.framework.TestCase;
import org.junit.BeforeClass;
import org.junit.Test;
import com.psl.dao.LocationDao;
import com.psl.entity.Location;

public class LocationTest extends TestCase {
	private static LocationDao locationDao = null;
	private static Location location1 = null, location2 = null;

	@BeforeClass
	public void setUp() {
		locationDao = mock(LocationDao.class);
		location1 = new Location(101, "PT");
		location2 = new Location(102, "Goa");

		when(locationDao.getLocationList()).thenReturn(Arrays.asList(location1, location2));
		when(locationDao.addLocation(location1)).thenReturn(true);
	}

	@Test
	public void testGetLocationList() {
		List<Location> locationsList = null;
		Location location = null;
		
		locationsList = locationDao.getLocationList();
		assertNotNull(locationsList);
		
		location = locationsList.get(0);
		assertEquals(location1.getLocationId(), location.getLocationId());
		assertEquals(location1.getLocationName(), location.getLocationName());
		
		location = locationsList.get(1);
		assertEquals(location2.getLocationId(), location.getLocationId());
		assertEquals(location2.getLocationName(), location.getLocationName());
	}
}