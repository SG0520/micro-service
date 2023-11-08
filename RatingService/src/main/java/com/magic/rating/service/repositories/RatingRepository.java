package com.magic.rating.service.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.magic.rating.service.entites.Rating;

public interface RatingRepository extends JpaRepository<Rating, String> {
List<Rating> findByUserId(String userId);
List<Rating> findByHotelId(String hotelId);
}
