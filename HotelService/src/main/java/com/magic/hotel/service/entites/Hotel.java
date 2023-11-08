package com.magic.hotel.service.entites;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity 
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="hotels")
public class Hotel {
	
	@Id
	private String hotelId;
	private String hotelName;
	private String location;
	private String about;
	
	
	
	

}
