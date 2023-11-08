package com.magic.hotel.service.services;

import java.util.List;

import com.magic.hotel.service.entites.Hotel;

public interface HotelService {
	
	Hotel saveHotel(Hotel hotel);
	
	List<Hotel> getAllHotel();
	
	Hotel getHotel(String hotelId);

}
