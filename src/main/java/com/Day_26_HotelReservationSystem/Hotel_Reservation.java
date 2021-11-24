package com.Day_26_HotelReservationSystem;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;


public class Hotel_Reservation 
{
	public List<Hotels> list;
	
	public Hotel_Reservation()
	{
		this.list = new ArrayList<Hotels>();
	}
	
	public void addHotels(Hotels hotel)
	{
		this.list.add(hotel);
	}
	
	public List<Hotels> getHotels()
	{
		return this.list;
	}
	
	public  Hotels getCheapestHotel(LocalDate startDate, LocalDate endDate) 
	{
        Optional<Hotels> sortedHotelList = list.stream().min(Comparator.comparing(Hotels::getRegularRates));
        return sortedHotelList.get();
    }
}























