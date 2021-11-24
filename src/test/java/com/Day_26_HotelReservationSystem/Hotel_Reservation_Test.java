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
		Hotels hotel01 = new Hotels("Lakewood", 100);
		Hotels hotel02 = new Hotels("Bridgewood", 140);
		Hotels hotel03 = new Hotels("Ridgewood", 210);
		hr.addHotels(hotel01);
		hr.addHotels(hotel02);
		hr.addHotels(hotel03);
		List<Hotels> hotels = Arrays.asList(hotel01, hotel02, hotel03);
		List<Hotels> result = hr.getHotels();
		Assert.assertEquals(result, hotels);
	}
	
	@Test
	public void addingDetailsOfHotelsAndFindingCheapestHotelWithRegularRates() 
	{
		Hotels hotel01 = new Hotels("Lakewood", 220);
		Hotels hotel02 = new Hotels("Bridgewood", 260);
		Hotels hotel03 = new Hotels("Ridgewood", 330);
		hr.addHotels(hotel01);
		hr.addHotels(hotel02);
		hr.addHotels(hotel03);
		LocalDate startDate = LocalDate.of(2020, Month.SEPTEMBER, 10);
	    LocalDate endDate = LocalDate.of(2020, Month.SEPTEMBER, 11);
		Hotels hotel = hr.getCheapestHotel(startDate, endDate);
		Assert.assertEquals("Lakewood", hotel.getHotelName());
	}
	
}



















