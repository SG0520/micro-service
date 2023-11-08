package com.magic.user.service.external.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

import com.magic.user.service.Vo.Rating;

@FeignClient(name="RATING-SERVICE")
public interface RatingService {
	//create method
	
	@PostMapping("/ratings")
	public Rating createRating(Rating rating);
	
	
	

}
