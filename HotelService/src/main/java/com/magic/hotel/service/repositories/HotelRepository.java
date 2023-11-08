package com.magic.hotel.service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.magic.hotel.service.entites.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, String> {

}
