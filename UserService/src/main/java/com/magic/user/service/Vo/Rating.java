package com.magic.user.service.Vo;




import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Rating {
	private String ratingId;
	private String userId;
	private String hotelId;
	private int RatingValue;
	private String feedback;
	private Hotel hotel;

}
