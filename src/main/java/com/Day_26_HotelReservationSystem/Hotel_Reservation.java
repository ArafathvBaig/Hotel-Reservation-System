package com.Day_26_HotelReservationSystem;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
	
	public Map<Hotels, Integer> searchFor(String date1, String date2) 
	{
		int totalDays = totalNumberOfDays(date1, date2);
		System.out.println("Total Days:: "+totalDays);
		int totalWeekDays = totalNumberOfWeekDays(date1, date2);
		System.out.println("Total Week Days:: "+totalWeekDays);
		int weekEndDays = totalDays - totalWeekDays;
		System.out.println("Total Week End Days:: "+weekEndDays);
		return getCheapestHotels(totalWeekDays, weekEndDays);
	}

	/**
	 * get cheapest hotel
	 */
	public Map<Hotels, Integer> getCheapestHotels(int weekDays, int weekendDays) 
	{
		Map<Hotels, Integer> hotelCosts = new HashMap<>();
		Map<Hotels, Integer> cheapestHotel = new HashMap<>();
		if (list.size() == 0)
			return null;
		this.list.stream().forEach(n -> hotelCosts.put(n,
				(n.getWeekDayRegularRate() * weekDays + n.getWeekEndRegularRate() * weekendDays)));
		Integer cheap = hotelCosts.values().stream().min(Integer::compare).get();
		hotelCosts.forEach((k, v) -> {
			if (v == cheap)
				cheapestHotel.put(k, v);
		});

		return cheapestHotel;
	}

	/**
	 * count total number of days
	 */
	public int totalNumberOfDays(String date1, String date2) 
	{
		LocalDate startDate = toLocalDate(date1);
		LocalDate endDate = toLocalDate(date2);
		int totalDays = Period.between(startDate, endDate).getDays() + 1;
		System.out.println("Total Days:: "+totalDays);
		return totalDays;
	}

	/**
	 * use to get total number of week days in booking dates
	 */
	public int totalNumberOfWeekDays(String date1, String date2) {
		LocalDate startDate = toLocalDate(date1);
		LocalDate endDate = toLocalDate(date2);
		DayOfWeek startDay = startDate.getDayOfWeek();
		DayOfWeek endDay = endDate.getDayOfWeek();
		int days = (int) (ChronoUnit.DAYS.between(startDate, endDate) + 1);
		System.out.println("Days:: "+days);
		int daysWithoutWeekends = days - 2 * ((days + startDay.getValue()) / 7);
		System.out.println("Days With Out Week Ends:: "+daysWithoutWeekends);
		int totalWeekDays = (int) daysWithoutWeekends + (startDay == DayOfWeek.SUNDAY ? 1 : 0)
				+ (endDay == DayOfWeek.SUNDAY ? 1 : 0);
		System.out.println("Total Week Days:: "+totalWeekDays);
		return totalWeekDays;
	}

	public LocalDate toLocalDate(String date) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMMyyyy");
		LocalDate localDate = LocalDate.parse(date, formatter);
		return localDate;
	}
}























