package com.magic.rating.service.services.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.magic.rating.service.entites.Rating;
import com.magic.rating.service.repositories.RatingRepository;
import com.magic.rating.service.services.RatingService;

@Service
public class RatingServiceImpl implements RatingService {

	@Autowired
	private RatingRepository ratingRepository;

	@Override
	public Rating saveRating(Rating rating) {
		String randomRatingId = UUID.randomUUID().toString();
		rating.setRatingId(randomRatingId);
		return ratingRepository.save(rating);
	}

	@Override
	public List<Rating> getAllRatings() {

		return ratingRepository.findAll();
	}

	@Override
	public List<Rating> getRatingByUserId(String userId) {

		return ratingRepository.findByUserId(userId);
	}

	@Override
	public List<Rating> getRatingByHotelId(String hotelId) {

		return ratingRepository.findByHotelId(hotelId);
	}

}
