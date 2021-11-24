package com.Day_26_HotelReservationSystem;

public class Hotels
{
	private String hotelName = " ";
	private int regularRates = 0;

	public Hotels()
	{
		
	}
	
	public Hotels(String hotelName, int regularRates) 
	{
		this.hotelName = hotelName;
		this.regularRates = regularRates;
	}

	/*
	 * These Get Methods get the data from Hotel Reservation System Class to Hotels. These Set
	 * Methods set the data from Hotel Reservation System variables to the Hotels variable.
	 */

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public int getRegularRates() {
		return regularRates;
	}

	public void setRegularRates(int regularRates) {
		this.regularRates = regularRates;
	}
	

	/*
	 * This Display Method Displays Details Just Got Added To The Array List.
	 */

	public void display() {
		System.out.println(" ");
		System.out.println("Hotel Name :: " + hotelName);
		System.out.println("Regular Rates :: " + regularRates);
	}

	@Override
	public String toString() {
		return "\nHotel Details:" + 
		"\nHotel Name :: " + hotelName+
		"\nRegular Rates :: " + regularRates;
	}
}










