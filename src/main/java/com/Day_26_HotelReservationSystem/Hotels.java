package com.Day_26_HotelReservationSystem;

public class Hotels
{
	private String hotelName = " ";
	private int regularRates = 0;
	private int weekDayRegularRate = 0;
	private int weekEndRegularRate = 0;

	public Hotels()
	{
		
	}
	
	public Hotels(String hotelName, int regularRates, int weekDayRegularRate, int weekEndRegularRate) 
	{
		this.hotelName = hotelName;
		this.regularRates = regularRates;
		this.weekDayRegularRate = weekDayRegularRate;
		this.weekEndRegularRate = weekEndRegularRate;
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
	
	public int getWeekDayRegularRate() {
		return weekDayRegularRate;
	}

	public void setWeekDayRegularRate(int weekDayRegularRate) {
		this.weekDayRegularRate = weekDayRegularRate;
	}
	
	public int getWeekEndRegularRate() {
		return weekDayRegularRate;
	}

	public void setWeekEndRegularRate(int weekEndRegularRate) {
		this.weekEndRegularRate = weekEndRegularRate;
	}

	/*
	 * This Display Method Displays Details Just Got Added To The Array List.
	 */

	public void display() 
	{
		System.out.println(" ");
		System.out.println("Hotel Name :: " + hotelName);
		System.out.println("Regular Rates :: " + regularRates);
		System.out.println("Week Day Regular Rate :: " + weekDayRegularRate);
		System.out.println("Week End Regular Rate :: " + weekEndRegularRate);
	}

	@Override
	public String toString() 
	{
		return "\nHotel Details:" + 
		"\nHotel Name :: " + hotelName+
		"\nRegular Rates :: " + regularRates+
		"\nWeek Day Regular Rate :: " + weekDayRegularRate+
		"\nWeek End Regular Rate :: " + weekEndRegularRate;
	}
}










