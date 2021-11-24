package com.Day_26_HotelReservationSystem;

import java.util.ArrayList;
import java.util.List;


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
}























