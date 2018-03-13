package Seathing.TheaterSeating.serviceTest;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import Seathing.TheaterSeating.model.TheaterLayout;
import Seathing.TheaterSeating.model.TheaterRequest;
import Seathing.TheaterSeating.service.TheaterSeatingServiceImpl;

public class TheaterSeatingServiceImplTest {

	TheaterSeatingServiceImpl theaterSeatingService = new TheaterSeatingServiceImpl();
	 
	String ticketRequests ="Smith 2\n" + 
			"Jones 5\n" + 
			"Davis 6\n" + 
			"Wilson 100\n" + 
			"Johnson 3\n" + 
			"Williams 4\n" + 
			"Brown 8\n" + 
			"Miller 12";
	
	String theaterLayout = "6 6\n" +
			"3 5 5 3\n" +
			"4 6 6 4\n" +
			"2 8 8 2\n" +
			"6 6";
	
	@Test
	public void getTicketRequestse() {
		List<TheaterRequest> testList = new ArrayList<TheaterRequest>();
		testList = theaterSeatingService.getTicketRequests(ticketRequests);
		assertEquals(testList.size(), 8);
	}
	
	@Test
	public void getTheaterLayout() {
		TheaterLayout theater = new TheaterLayout();
		theater = theaterSeatingService.getTheaterLayout(theaterLayout);
		assertEquals(theater.getAvailableSeats(), 80);
		assertEquals(theater.getTotalCapacity(), 80);
		assertEquals(theater.getSections().size(), 16);
	}
}
