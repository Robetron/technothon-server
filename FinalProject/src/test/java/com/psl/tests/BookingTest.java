package com.psl.tests;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import java.util.Arrays;
import java.util.List;
import junit.framework.TestCase;
import org.junit.BeforeClass;
import org.junit.Test;
import com.psl.dao.BookingDao;
import com.psl.entity.Booking;

public class BookingTest extends TestCase {
	private static BookingDao bookingDao = null;
	private static Booking booking1 = null, booking2 = null;

	@BeforeClass
	public void setUp() {
		bookingDao = mock(BookingDao.class);
		booking1 = new Booking(111, 222, 3333);
		booking2 = new Booking(444, 222, 6666);

		when(bookingDao.getTrainingIDList(booking1.getRoomID())).thenReturn(Arrays.asList(booking1.getTrainingID(), booking2.getTrainingID()));
		
	}
	
	@Test
	public void testGetTrainingIDList() {
		List<Long> trainingDetailsList = null;
		trainingDetailsList = bookingDao.getTrainingIDList(booking1.getRoomID());
		assertNotNull(trainingDetailsList);
		assertEquals((long)booking1.getTrainingID(), (long)trainingDetailsList.get(0));
		assertEquals((long)booking2.getTrainingID(), (long)trainingDetailsList.get(1));
	}
}
