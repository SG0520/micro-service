package com.magic.rating.service.services;

import java.util.List;

import com.magic.rating.service.entites.Rating;

public interface RatingService {
	
	Rating saveRating(Rating rating);
	
	List<Rating> getAllRatings();
	
	List<Rating> getRatingByUserId(String userId);
    
	List<Rating> getRatingByHotelId(String hotelId);
}
