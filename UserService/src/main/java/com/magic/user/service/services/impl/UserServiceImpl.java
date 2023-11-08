package com.magic.user.service.services.impl;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.magic.user.service.Vo.Hotel;
import com.magic.user.service.Vo.Rating;
import com.magic.user.service.entites.User;
import com.magic.user.service.exceptions.ResourceNotFoundException;
import com.magic.user.service.external.services.HotelService;
import com.magic.user.service.repositories.UserRepository;
import com.magic.user.service.services.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private HotelService hotelService;

	@Override
	public User saveUser(User user) {
		String randomUserId = UUID.randomUUID().toString();
		user.setUserId(randomUserId);
		return userRepository.save(user);
	}    

	@Override
	public List<User> getAllUser() {

		return userRepository.findAll();
	}

	@Override
	public User getUser(String userId) {

		User userObj = userRepository.findById(userId).orElseThrow(
				() -> new ResourceNotFoundException("User with given id is not found on server !! :" + userId));
		
		Rating[] ratingOfUsers = restTemplate.getForObject("http://RATING-SERVICE/ratings/users/" + userId,
				Rating[].class);
		List<Rating> ratings=Arrays.stream(ratingOfUsers).toList();
		List<Rating> ratingList = ratings.stream().map(rating -> {
			
			//ResponseEntity<Hotel> forEntity = restTemplate.getForEntity("http://HOTEL-SERVICE/hotels/"+rating.getHotelId(), Hotel.class);
			//Hotel hotelObj = forEntity.getBody();
			Hotel hotelObj = hotelService.getHotel(rating.getHotelId());
			rating.setHotel(hotelObj);
			return rating;

		}).collect(Collectors.toList());

		userObj.setRatings(ratingList);
		return userObj;
	}

}
