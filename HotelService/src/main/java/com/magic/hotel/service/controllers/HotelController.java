package com.magic.hotel.service.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.magic.hotel.service.entites.Hotel;
import com.magic.hotel.service.services.HotelService;

@RestController
@RequestMapping("/hotels")
public class HotelController {
	
@Autowired
private HotelService hotelService;
@PreAuthorize("hasAuthority('SCOPE_internal')|| hasAuthority('Admin')")	
@PostMapping()
public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel){
	Hotel hotelObj=hotelService.saveHotel(hotel);
	return ResponseEntity.status(HttpStatus.CREATED).body(hotelObj);
}
@PreAuthorize("hasAuthority('SCOPE_internal')")
@GetMapping("/{hotelId}")
public  ResponseEntity<Hotel> getUserById(@PathVariable String hotelId){
	Hotel hotelObj=hotelService.getHotel(hotelId);
	return ResponseEntity.ok(hotelObj);
	}
@PreAuthorize("hasAuthority('SCOPE_internal')|| hasAuthority('Admin')")
@GetMapping
public  ResponseEntity<List<Hotel>> getAllHotel(){
 List<Hotel> hotelList=hotelService.getAllHotel();
 return ResponseEntity.ok(hotelList);
}
}
