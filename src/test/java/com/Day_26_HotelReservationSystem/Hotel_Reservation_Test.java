package com.Day_26_HotelReservationSystem;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;
import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class Hotel_Reservation_Test 
{
	Hotel_Reservation hr = new Hotel_Reservation();
	
	@Test
	public void addingDetailsOfHotelsAndTestingWeatherAddedOrNot() 
	{
		Hotels hotel01 = new Hotels("Lakewood", 220, 110, 90);
		hotel01.display();
		Hotels hotel02 = new Hotels("Bridgewood", 260, 150, 50);
		hotel02.display();
		Hotels hotel03 = new Hotels("Ridgewood", 330, 220, 150);
		hotel03.display();
		hr.addHotels(hotel01);
		hr.addHotels(hotel02);
		hr.addHotels(hotel03);
		List<Hotels> hotels = Arrays.asList(hotel01, hotel02, hotel03);
		List<Hotels> result = hr.getHotels();
		Assert.assertEquals(result, hotels);
	}
}



















