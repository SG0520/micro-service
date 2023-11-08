package com.magic.rating.service.controllers;

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

import com.magic.rating.service.entites.Rating;
import com.magic.rating.service.services.RatingService;

@RestController
@RequestMapping("/ratings")
public class RatingController {
	
@Autowired
private  RatingService ratingService;
@PreAuthorize("hasAuthority('Admin')")
@PostMapping()	
public ResponseEntity<Rating> createRating(@RequestBody Rating rating){
	Rating ratingObj=ratingService.saveRating(rating);
	return ResponseEntity.status(HttpStatus.CREATED).body(ratingObj);
}
@PreAuthorize("hasAuthority('SCOPE_internal')|| hasAuthority('Admin')")
@GetMapping()
public  ResponseEntity<List<Rating>> getAllRatings(){
	List<Rating> ratingList=ratingService.getAllRatings();
	return ResponseEntity.ok(ratingList);
	}
@PreAuthorize("hasAuthority('SCOPE_internal')|| hasAuthority('Admin')")
@GetMapping("/users/{userId}")
public  ResponseEntity<List<Rating>> getRatingsByUserId(@PathVariable String userId){
 List<Rating> ratingList=ratingService.getRatingByUserId(userId);
 return ResponseEntity.ok(ratingList);
}
@PreAuthorize("hasAuthority('SCOPE_internal')")
@GetMapping("/hotels/{hotelId}")
public  ResponseEntity<List<Rating>> getRatingsByHotelId(@PathVariable String hotelId){
 List<Rating> ratingList=ratingService.getRatingByHotelId(hotelId);
 return ResponseEntity.ok(ratingList);
}
}
