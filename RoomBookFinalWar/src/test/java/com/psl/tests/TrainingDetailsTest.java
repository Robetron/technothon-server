package com.psl.tests;

import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import junit.framework.TestCase;

import org.junit.BeforeClass;
import org.junit.Test;

import com.psl.dao.TrainingDetailsDao;
import com.psl.entity.TrainingDetails;

public class TrainingDetailsTest extends TestCase{
	private static TrainingDetailsDao trainingDetailsDao = null;
	private static TrainingDetails trainingDetails1 = null,
			trainingDetails2 = null;

	@BeforeClass
	public void setUp() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		trainingDetailsDao = mock(TrainingDetailsDao.class);
		trainingDetails1 = new TrainingDetails(82, 2, 11,
				sdf.parse("2014-12-02"), sdf.parse("2014-12-02"), "ELTP",
				"9:00", "12:00", "Ganesh", "cep");
		trainingDetails2 = new TrainingDetails(82, 2, 11,
				sdf.parse("2014-12-02"), sdf.parse("2014-12-02"), "ELTP",
				"9:00", "12:00", "Ganesh", "cep");

		when(trainingDetailsDao.getTrainingDetails(82)).thenReturn(Arrays.asList(trainingDetails1, trainingDetails2));
		doNothing().when(trainingDetailsDao).deleteTrainingDetails((isA(Long.class)));
		trainingDetailsDao.deleteTrainingDetails(0);
		verify(trainingDetailsDao, times(1)).deleteTrainingDetails(0);

		when(trainingDetailsDao.showTrainingid(sdf.parse("2014-12-02"),"9:00", 11)).thenReturn((long) 82);
		doNothing().when(trainingDetailsDao).insertTrainingDetails((isA(TrainingDetails.class)));
		trainingDetailsDao.insertTrainingDetails(trainingDetails1);
		verify(trainingDetailsDao, times(1)).insertTrainingDetails(trainingDetails1);

		when(trainingDetailsDao.isRoomAvailable(11,sdf.parse("2014-12-02"), sdf.parse("2014-12-02"),"9:00", "12:00")).thenReturn(true);

	}
	@Test
	public void testSample(){
		
	}
	/*
	 * @Test public void testGetRoomByLocation() { List<Location> allLocation =
	 * mockLocationDao.getLocationList(); assertEquals(2, allLocation.size());
	 * Location myLocation = allLocation.get(0); assertEquals(101,
	 * myLocation.getLocationId()); assertEquals("PT",
	 * myLocation.getLocationName()); Location myLocation1 = allLocation.get(1);
	 * assertEquals(102, myLocation1.getLocationId()); assertEquals("Goa",
	 * myLocation1.getLocationName());
	 * 
	 * }
	 * 
	 * }
	 * 
	 * @Test public void testShowTrainingid() {
	 * 
	 * 
	 * 
	 * }
	 */

}
