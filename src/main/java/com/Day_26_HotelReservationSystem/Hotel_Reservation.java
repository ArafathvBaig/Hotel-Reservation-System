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
		int totalWeekDays = totalNumberOfWeekDays(date1, date2);
		int weekEndDays = totalDays - totalWeekDays;
		return getCheapestHotels(totalWeekDays, weekEndDays);
	}
	
	public Map<Hotels, Integer> searchFor1(String date1, String date2) 
	{
		int totalDays = totalNumberOfDays(date1, date2);
		int totalWeekDays = totalNumberOfWeekDays(date1, date2);
		int weekEndDays = totalDays - totalWeekDays;
		return getBestRatedHotels(totalWeekDays, weekEndDays);
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
		return totalDays;
	}

	/**
	 * use to get total number of week days in booking dates
	 */
	public int totalNumberOfWeekDays(String date1, String date2) 
	{
		LocalDate startDate = toLocalDate(date1);
		LocalDate endDate = toLocalDate(date2);
		DayOfWeek startDay = startDate.getDayOfWeek();
		DayOfWeek endDay = endDate.getDayOfWeek();
		int days = (int) (ChronoUnit.DAYS.between(startDate, endDate) + 1);
		int daysWithoutWeekends = days - 2 * ((days + startDay.getValue()) / 7);
		int totalWeekDays = (int) daysWithoutWeekends + (startDay == DayOfWeek.SUNDAY ? 1 : 0)
				+ (endDay == DayOfWeek.SUNDAY ? 1 : 0);
		return totalWeekDays;
	}

	public LocalDate toLocalDate(String date) 
	{
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMMyyyy");
		LocalDate localDate = LocalDate.parse(date, formatter);
		return localDate;
	}
	
	public Map<Hotels, Integer> getCheapestAndBestRatedHotels(String date1, String date2) 
	{
		Map<Hotels, Integer> bestHotels = new HashMap<Hotels, Integer>();
		Map<Hotels, Integer> cheapestHotels = searchFor(date1, date2);
		int highestRating = (cheapestHotels.keySet().stream().max(Comparator.comparingInt(Hotels::getRating)).get())
				.getRating();
		cheapestHotels.forEach((k, v) -> {
			if (k.getRating() == highestRating)
				bestHotels.put(k, k.getRating());
		});
		return bestHotels;
	}
	
	public Map<Hotels, Integer> getBestRatedHotels(int date1, int date2)
	{
		Map<Hotels, Integer> hotel = new HashMap<>();
		Map<Hotels, Integer> bestRatedHotels = new HashMap<>();
		list.stream().forEach(n -> hotel.put(n, n.getRating()));
		Integer rating = hotel.values().stream().max(Integer::compare).get();
		hotel.forEach((k, v) -> {
			if (v == rating)
				bestRatedHotels.put(k, v);
		});
		return bestRatedHotels;
	}
}























