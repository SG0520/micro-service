package com.magic.user.service.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.magic.user.service.entites.User;
import com.magic.user.service.services.UserService;

import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {
	
@Autowired
private UserService userService;
	
@PostMapping()	
public ResponseEntity<User> createUser(@RequestBody User user){
	User userObj=userService.saveUser(user);
	return ResponseEntity.status(HttpStatus.CREATED).body(userObj);
}
//int retryCount=1;
//@CircuitBreaker(name = "ratingHotelBreaker",fallbackMethod = "ratingHotelFallback")
//@Retry(name = "ratingHotelRetry",fallbackMethod = "ratingHotelFallback")
@RateLimiter(name = "userRateLimiter",fallbackMethod = "ratingHotelFallback")
@GetMapping("/{userId}")
public  ResponseEntity<User> getUserById(@PathVariable String userId){
    log.info("Get Single User Handler:UserController");
    //log.info("Retry count {}",retryCount);
   // retryCount++;
	User userObj=userService.getUser(userId);
	return ResponseEntity.ok(userObj);
	}

public  ResponseEntity<User> ratingHotelFallback(String userId,Exception ex){
	log.info("Fallback is executed because service is down:",ex.getMessage());
	User userObj=User.builder()
			.userId(userId)
			.email("dummy email")
			.name("dummy")
			.userId("1412345")
			.build();
	ex.printStackTrace();
	return new ResponseEntity<>(userObj,HttpStatus.OK);
	
}

@GetMapping
public  ResponseEntity<List<User>> getAllUser(){
 List<User> userList=userService.getAllUser();
 return ResponseEntity.ok(userList);
}
}
