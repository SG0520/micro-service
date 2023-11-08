package com.magic.hotel.service.services.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.magic.hotel.service.entites.Hotel;
import com.magic.hotel.service.exceptions.ResourceNotFoundException;
import com.magic.hotel.service.repositories.HotelRepository;
import com.magic.hotel.service.services.HotelService;

@Service
public class HotelServiceImpl implements HotelService {
     
    @Autowired
    private HotelRepository hotelRepository;
	@Override
	public Hotel saveHotel(Hotel hotel) {
		String randomHotelId=UUID.randomUUID().toString();
		hotel.setHotelId(randomHotelId);
		return  hotelRepository.save(hotel);
	}

	@Override
	public List<Hotel> getAllHotel() {
		
		return hotelRepository.findAll();
	}

	@Override
	public Hotel getHotel(String hotelId) {
		
		return hotelRepository.findById(hotelId).orElseThrow(()->new ResourceNotFoundException("User with given id is not found on server !! :"+hotelId));
	}

}
